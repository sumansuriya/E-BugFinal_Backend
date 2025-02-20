package com.ebug.project.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebug.project.entities.Bug;
import com.ebug.project.entities.BugReport;
import com.ebug.project.entities.Customer;
import com.ebug.project.entities.Staff;
import com.ebug.project.exceptions.BugDetailsNotFound;
import com.ebug.project.exceptions.BugNotFoundException;
import com.ebug.project.exceptions.CustomerNotFoundException;
import com.ebug.project.repositories.BugRepository;
import com.ebug.project.repositories.CustomerRepository;
import com.ebug.project.repositories.StaffRepository;

@Service
public class BugServiceImpl implements BugService {

	
	@Autowired
	private BugRepository bugrepo;
	
	@Autowired
	private BugService bugservice;

	@Autowired
	private CustomerRepository customerrepo;
	
	@Autowired
	private CustomerService customerservice;

	@Autowired
	private StaffRepository staffrepo;
	
	@Autowired
	private StaffService staffservice;



	@Override
	public Bug provideBugSolution(int bugId, Bug bug) {
		
    if (bugrepo.findBugByBugId(bugId) == null) {
	     throw new BugDetailsNotFound("Bug not found for given Id : "+bugId);
    }
	else {
	   Bug bg = bugrepo.findBugByBugId(bugId);
	   bg.setBugSolution(bug.getBugSolution());
	   bg.setBugStatus("Solved");
	   
	 return bugrepo.save(bg);
	}
	}



	@Override
	public List<Bug> viewAllBugs() {
		
		return bugrepo.findAll();
	
	}


	@Override
	public Bug findByBugId(int bugId) {
	Optional<Bug> bybugId = bugrepo.findById(bugId);
	if (bybugId.isPresent()) {
	return bybugId.get();
	}
	throw new BugNotFoundException("Bug not found for given Id :"+bugId);
	}
	


	@Override
	public Bug raiseBug(Bug bug) {

		
		Customer cst = customerservice.getCustomerById(bug.getCustomer().getCustomerId());
		
		if (cst.equals(null)) {
			throw new CustomerNotFoundException("customer not found");	
		}
		else {
			cst.setTicketcount(cst.getTicketcount()+1);
			customerrepo.save(cst);
			
			Staff stf = staffservice.getStaffById(bug.getStaff().getStaffId());
			stf.setBugCount(stf.getBugCount()+1);
			staffrepo.save(stf);
		
			 String characters = "0123456789";
			 String pwd = RandomStringUtils.random(6, characters);
			 bug.setTicketId("BGN" + pwd);
			 bug.setBugStatus("open");
			 
			bugrepo.save(bug);
			
		}
		return bug;
	}

	@Override
	public Bug assignBug(int bugId, Bug bug) {

	Bug bg = bugservice.findByBugId(bugId);	
	Staff stf = staffservice.getStaffById(bg.getStaff().getStaffId());
	
	 Bug b = bg;	
	 Staff stff = stf;
	  
	 if(stff.getBugCount()>0) {
	  stff.setBugCount(stff.getBugCount()-1);
	  staffrepo.save(stff);
	 }
	 
	  b.setStaff(bug.getStaff());
	  Bug bug1 = bugrepo.save(b);
		
	  Staff stf1 = staffservice.getStaffById(bug.getStaff().getStaffId());
	  
	  stf1.setBugCount(stf1.getBugCount()+1);
	  staffrepo.save(stf1);
				
	   return bug1;
	
	}


	@Override
	public BugReport viewReport() {
		
		BugReport br = new BugReport();
	
	List<Bug> listOfBugs = bugrepo.findAll();
	br.setTotalBugs(listOfBugs.size());
	
	for(Bug bug: listOfBugs) {
	if(bug.getBugStatus().equalsIgnoreCase("solved")) {
		br.setCompletedBugs(br.getCompletedBugs()+1);
	  }
	}
	
	for(Bug bug: listOfBugs) {
		if(bug.getBugStatus().equalsIgnoreCase("open")) {
			br.setPendingBugs(br.getPendingBugs()+1);
		  }
		}
	
	float bg = br.getCompletedBugs();
    float bgs = br.getTotalBugs();
	float value = (bg/bgs)*100;
	
	br.setCompletedPercentage(value);
		
	return br;
	}



	@Override
	public List<Bug> viewAllBugsBystaffId(int staffId) {

		Staff stf = staffservice.getStaffById(staffId);
		List<Bug> staffBugs = bugrepo.findBugsBystaffId(stf);	
		
		return staffBugs;
	}
	


	@Override
	public List<Bug> viewAllBugsBycustomerId(int customerId) {

		Customer cst = customerservice.getCustomerById(customerId);
		List<Bug> customerBugs = bugrepo.findBugsBycustomerId(cst);
		return customerBugs;
	}

	
	
	
}
