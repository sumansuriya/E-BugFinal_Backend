package com.ebug.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebug.project.entities.Customer;

@Service
public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	
	public Customer saveCustomers(Customer customer);
	
	public Customer validateLogin(String username, String password);
	
	public Customer getCustomerById(Integer customerId);
	
	public  Customer updateCustomer(Customer customer , int customerId);
	
	public Customer getByEmailId(String emailid);
	

}
