package com.ebug.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebug.project.entities.Admin;
import com.ebug.project.exceptions.StaffNotFoundException;
import com.ebug.project.services.AdminService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/v1")
public class AdminController {

	@Autowired
	AdminService adminService;


	//	ADMIN LOGIN ( "http://localhost:8080/api/v1/admin/login" )

	@PostMapping(path = "/admin/login", consumes = {"application/json"})
	public ResponseEntity<String> adminCheck(@RequestBody Admin adminLogin) {
		String message = null;

		adminService.saveAdmin();
		
		Admin admin = adminService.getAdmin(adminLogin.getUsername(), adminLogin.getPassword());

		if (admin == null) {
			throw new StaffNotFoundException("You are not Admin");

		} else {
			Admin checkAdmin = adminService.validateLogin(adminLogin.getUsername(), adminLogin.getPassword());

			if (checkAdmin == null) {
				throw new StaffNotFoundException("Username or Password Incorrect... Enter correct credentials please");
			}
			else {
				message = "Welcome " + checkAdmin.getUsername();
			}
			return new ResponseEntity<>(message, HttpStatus.OK);

		}
	}
}
