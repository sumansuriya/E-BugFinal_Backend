package com.ebug.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebug.project.entities.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
	
	
	@Query("from Staff s where s.userId=?1")
	Optional<Staff> findById(String userId);
	
	@Query("from Staff s where s.staffId=?1")
	public Staff findStaffById(int staffId);
	

}
