package com.ebug.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebug.project.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

	@Query("from Admin ad where ad.username=?1 and ad.password=?2")
	public Admin admin(String username, String password);
	

}
