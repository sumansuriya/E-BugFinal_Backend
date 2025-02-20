package com.ebug.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebug.project.entities.Bug;
import com.ebug.project.entities.Customer;
import com.ebug.project.entities.Staff;

@Repository
public interface BugRepository extends JpaRepository<Bug, Integer> {


	@Query("from Bug b where b.bugId=?1")
	public Bug findBugByBugId(int bugId);
	
	@Query("from Bug b where b.customer=?1")
	public List<Bug> findBugsBycustomerId(Customer customer);
	
	@Query("from Bug b where b.staff=?1")
	public List<Bug> findBugsBystaffId(Staff staff);

	
}
