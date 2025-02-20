package com.ebug.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebug.project.entities.Bug;
import com.ebug.project.entities.BugReport;

@Service
public interface BugService {

	
	public Bug raiseBug(Bug bug);
	
	public BugReport viewReport();
	
	public Bug provideBugSolution(int bugId, Bug bug);
	
	public Bug findByBugId(int bugId);
	
	public List<Bug> viewAllBugs();
	
	public List<Bug> viewAllBugsBystaffId(int staffId);
	
    public List<Bug> viewAllBugsBycustomerId(int customerId);
	
    public Bug assignBug(int bugId, Bug bug);
    


	
}
