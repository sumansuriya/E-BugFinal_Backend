package com.ebug.project.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebug.project.entities.Staff;
import com.ebug.project.exceptions.StaffNotFoundException;
import com.ebug.project.repositories.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {
	
	
	@Autowired 
	StaffRepository staffrepo;
	

	 @Override
	 public Staff addStaffDetails(Staff user) {
		 
		 String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz@#$!&";
		 String pwd = RandomStringUtils.random(8, characters);
		 user.setPassword(pwd);
		 
		 String chars = user.getName();
		 String usrId = RandomStringUtils.random(6, chars);
		 String usr = usrId.toUpperCase();
		 user.setUserId(usr);
		 
		 System.out.println("addmethod");
		 
	 return staffrepo.save(user);
	 }

	 
	 @Override
	 public Staff adminUpdateStaffDetails(Integer staffId, Staff user) {
	 Optional<Staff> optionalEntity = staffrepo.findById(staffId);
	 Staff staff = getStaffById(staffId);
	 if (optionalEntity.isPresent()) {
	 staff.setEmailId(user.getEmailId());
	 staff.setDesignation(user.getDesignation());
	 return staffrepo.save(staff);
	 } else {
	 throw new StaffNotFoundException("Staff not found for given Id :"+staffId);
	 }
	 }
	 
	 @Override
		public Staff staffUpdateStaffDetails(Integer id, Staff user) {
			// TODO Auto-generated method stub
		 Staff stf = getStaffById(id);
		 stf.setName(user.getName());
		 stf.setMobileNo(user.getMobileNo());
		 stf.setPassword(user.getPassword());
		 return staffrepo.save(stf);
		}

	@Override
	public Staff getStaffById(Integer staffId) {
	Optional<Staff> userById = staffrepo.findById(staffId);
	if (userById.isPresent())
	return userById.get();
	else
	throw new StaffNotFoundException("Staff not found for given Id :"+staffId);
	}
	
	
	@Override
	public List<Staff> getStaffDetails() {
		
		return staffrepo.findAll();
	 
	}

	@Override
	public void deleteStaff(Integer staffId) {

	Optional<Staff> userById = staffrepo.findById(staffId);
	if (userById.isPresent()) {
	staffrepo.deleteById(staffId);
	} else {
	throw new StaffNotFoundException("Staff not found for given Id :"+staffId);
	}
	}
	

	@Override
	public Staff findStaffLoginById(String userId, String password) {
		Optional<Staff> loginById = staffrepo.findById(userId);
		if (loginById.isPresent()) {
			if(loginById.get().getPassword().equals(password)) {
		         return loginById.get();  
			}
		}
		return null;
		}


	

	
}

 

 


