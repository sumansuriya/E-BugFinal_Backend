package com.ebug.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.ebug.project.entities.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>  {



	@Query("from Project p where p.projectId=?1")
	public Project getById(int id);

	
	
}
