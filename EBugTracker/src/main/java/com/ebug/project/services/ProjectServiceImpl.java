package com.ebug.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ebug.project.entities.Project;
import com.ebug.project.exceptions.ProjectNotFoundException;
import com.ebug.project.repositories.ProjectRepository;


@Component
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository repo;

	@Override
	public Project addProject(Project user) {

		Project newUsers = repo.save(user);
		return newUsers;
	}

	@Override
	public List<Project> getAllUsers() {

		return repo.findAll();
	}

	@Override
	public Project findprojectById(int id) {

		Optional<Project> user = repo.findById(id);
		if(user.isEmpty()) {
			throw new ProjectNotFoundException("Project details Not Found For The Given ID : " +id);
		}
		
		return user.get();
	}

	@Override
	public void updateProject(Project users) {
		
		Project project = findprojectById(users.getProjectId());
		
		project.setProjectName(users.getProjectName());
		project.setProjectDescription(users.getProjectDescription());
		
		repo.save(project);
		
	}

	@Override
	public void deleteProjectById(int id) {

		repo.deleteById(id);
		
	}

}
