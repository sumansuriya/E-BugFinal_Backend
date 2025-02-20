package com.ebug.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebug.project.entities.Staff;
import com.ebug.project.exceptions.StaffNotFoundException;
import com.ebug.project.repositories.StaffRepository;
import com.ebug.project.services.StaffService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/v1")

public class StaffController {
	@Autowired
	StaffRepository staffrepo;
	@Autowired
	StaffService staffService;
	

	
	@PostMapping("/staff/login")
	public ResponseEntity<Staff> validateStaff(@RequestBody Staff user) throws StaffNotFoundException {
         Staff stff = null;
         Staff stf = null;
		stff = staffService.findStaffLoginById(user.getUserId(), user.getPassword());

		if (stff != null) {
			if (stff.getUserId().equals(user.getUserId())
					&& stff.getPassword().equals(user.getPassword())) {
				stf = stff;
			}
		}
		else {
			throw new StaffNotFoundException("Staff not found for this id ::  " + user.getUserId());
		}

		return new ResponseEntity<>(stf, HttpStatus.OK);
	}

	
	@GetMapping("/staff/view")
	public List<Staff> getStaffDetails() {
		return staffService.getStaffDetails();
	}

	@GetMapping("/staff/view/{staffId}")
	public ResponseEntity<Staff> getStaffById(@PathVariable Integer staffId) {
		Staff staff = staffService.getStaffById(staffId);
		return new ResponseEntity<>(staff,HttpStatus.OK);
	}

	@PostMapping("/staff/add")
	public ResponseEntity<String> addStaffDetails(@RequestBody Staff user) {
		staffService.addStaffDetails(user);
		return new ResponseEntity<>("Staff added Successfully", HttpStatus.OK);
	}

	@PutMapping("/staff/update/{staffId}")
	public ResponseEntity<String> adminUpdateStaffDetails(@PathVariable Integer staffId, @RequestBody Staff user) {
		staffService.adminUpdateStaffDetails(staffId, user);
		return new ResponseEntity<>("Staff updated successfully", HttpStatus.OK);
	}
	
	@PutMapping("/update/{staffId}")
	public ResponseEntity<String> staffUpdateStaffDetails(@PathVariable Integer staffId, @RequestBody Staff user) {
		staffService.staffUpdateStaffDetails(staffId, user);
		return new ResponseEntity<>("updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/staff/delete/{staffId}")
	public ResponseEntity<String> deleteStaff(@PathVariable Integer staffId) {
		staffService.deleteStaff(staffId);
		return new ResponseEntity<>("Staff has been deleted", HttpStatus.OK);
	}
	
}
