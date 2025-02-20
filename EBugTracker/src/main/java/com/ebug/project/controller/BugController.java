package com.ebug.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebug.project.entities.Bug;
import com.ebug.project.entities.BugReport;
import com.ebug.project.services.BugService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/v1")
public class BugController {
	
	@Autowired
	private BugService bugService;
	
	@GetMapping("/bugs")
	public List<Bug> getAllBugs() {
		List<Bug> bugs = bugService.viewAllBugs();
		
		return bugs;
	}

	@GetMapping("/bug/{bugId}")
	public Bug getBugById(@PathVariable int bugId) {
		return bugService.findByBugId(bugId);
	}

	@PutMapping("/bug/solution/{bugId}")
	public ResponseEntity<String> provideBugSolution(@PathVariable ("bugId") int bugId, @RequestBody Bug bug) {	
		bugService.provideBugSolution(bugId, bug);
		return new ResponseEntity<>("Solution Provided :)", HttpStatus.OK);
	}
	
	

	 @GetMapping(path = "/view/report", produces = { "application/json" }) 
		public ResponseEntity<BugReport> viewReport() {
			BugReport report = bugService.viewReport();
			return new ResponseEntity<>(report, HttpStatus.OK);
	 }
	 
	 
	
		@PostMapping("/raise/bug")
		public ResponseEntity<Bug> raiseBug(@RequestBody Bug bug) {
		Bug bg = bugService.raiseBug(bug);
		return new ResponseEntity<>(bg, HttpStatus.OK);
		}
		
		@PutMapping("/assign/bug/{bugId}")
		public ResponseEntity<Bug> assignBug(@PathVariable ("bugId") int bugId, @RequestBody Bug bug) {
			Bug bg = bugService.assignBug(bugId, bug);
			return new ResponseEntity<>(bg, HttpStatus.OK); 
		}
	
		
		
		@GetMapping("/staff/bugs/view/{staffId}")
		public ResponseEntity<List<Bug>> viewAllBugsBystaffId(@PathVariable ("staffId") int staffId) {
			List<Bug> bugsByStaffId = bugService.viewAllBugsBystaffId(staffId);
		  return new ResponseEntity<>(bugsByStaffId, HttpStatus.OK);
		}
		
		
		@GetMapping("/customer/bugs/view/{customerId}")
		public ResponseEntity<List<Bug>> viewAllBugsBycustomerId(@PathVariable ("customerId") int customerId) {
			List<Bug> bugsByCustomerId = bugService.viewAllBugsBycustomerId(customerId);
		  return new ResponseEntity<>(bugsByCustomerId, HttpStatus.OK);
		}
		
		

	
}

