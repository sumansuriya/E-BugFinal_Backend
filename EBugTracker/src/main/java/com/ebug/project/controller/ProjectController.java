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


import com.ebug.project.entities.Project;
import com.ebug.project.services.ProjectService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/v1")

public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	
	 @GetMapping(path = "/project/view", produces = { "application/json" }) 
		public ResponseEntity<List<Project>> getAllUsers() {
			List<Project> userList = proService.getAllUsers();
			return new ResponseEntity<>(userList, HttpStatus.OK);
		}
	 
	 @GetMapping(path = "/project/view/{id}", produces = { "application/json" }) 
		public ResponseEntity<Project> findprojectById(@PathVariable("id") int id) {
			Project user = proService.findprojectById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}


	
	@PostMapping(path = "/project/add", consumes = {"application/json"})
	public ResponseEntity<String> saveUsers(@RequestBody Project user){
		proService.addProject(user);

		String msg= "Project has been added successfully.";

		return new ResponseEntity<>(msg, HttpStatus.OK);

	}
	

	// updating an Project details
		@PutMapping(path = "/project/update", consumes = {"application/json"})
		public ResponseEntity<Project> updateUser(@RequestBody Project users) {
			proService.updateProject(users);
			Project usr = proService.findprojectById(users.getProjectId());
			

			return new ResponseEntity<>(usr, HttpStatus.OK);
		}
		
		@DeleteMapping("/project/delete/{id}")
		public ResponseEntity<List<Project>> deleteUserById(@PathVariable("id") int id) {
			Project user = proService.findprojectById(id);

			if(user==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				proService.deleteProjectById(id);
			}
			List<Project> usersList = proService.getAllUsers();
			return new ResponseEntity<>(usersList, HttpStatus.OK);
		}

		 
	


}
