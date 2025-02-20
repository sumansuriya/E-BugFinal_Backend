package com.ebug.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebug.project.entities.Staff;


@Service
public interface StaffService {

	
	Staff addStaffDetails(Staff user);
	
	Staff adminUpdateStaffDetails(Integer id, Staff user);
	
	Staff staffUpdateStaffDetails(Integer id, Staff user);
	
	Staff getStaffById(Integer id);
	
	List<Staff> getStaffDetails();

    void deleteStaff(Integer id);

	
//Staff Login
   public Staff findStaffLoginById(String userId, String password);
   
   
}
