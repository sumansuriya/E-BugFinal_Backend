package com.ebug.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ebug.project.entities.Customer;
@Service
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	@Query("from Customer c where c.emailid=?1")
	public Customer getByEmailid(String emailid);
	
	@Query("from Customer c where c.customerId=?1")
	public Customer getCustomerById(int customerId);

}
