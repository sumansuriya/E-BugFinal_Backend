package com.ebug.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebug.project.entities.Project;

@Service
public interface ProjectService {

	Project addProject(Project user);

	List<Project> getAllUsers();

	Project findprojectById(int id);

	void updateProject(Project users);

	void deleteProjectById(int id);

	
	

}
