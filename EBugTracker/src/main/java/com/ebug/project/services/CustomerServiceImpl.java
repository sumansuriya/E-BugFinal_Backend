package com.ebug.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebug.project.entities.Customer;
import com.ebug.project.exceptions.CustomerNotFoundException;
import com.ebug.project.repositories.CustomerRepository;

@Service 
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository repo;

	@Override
	public List<Customer> getAllCustomers() {
		
		return repo.findAll();
	}

	
	@Override
	public Customer getCustomerById(Integer customerId) {

	Optional<Customer> customerById = repo.findById(customerId);
	if (customerById.isPresent()) 
	return customerById.get();
	else 
    throw new CustomerNotFoundException("Customer not found for given Id :"+customerId); 
	}
	
	
	@Override
	public Customer saveCustomers(Customer customer) {
		
		repo.save(customer);
		System.out.println("Hello");
		return repo.save(customer);
	}

	@Override
	public Customer validateLogin(String username, String password) {

		List<Customer> customers = repo.findAll();
		for (Customer customer : customers) {
			if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
				return customer;
			}
		}
		return null;
	}


	@Override
	public Customer getByEmailId(String emailid) {
		
		return repo.getByEmailid(emailid);
	}


	
	@Override
	public Customer updateCustomer(Customer customer, int customerId) {

		Customer cst = getCustomerById(customerId);
		cst.setName(customer.getName());
		cst.setPassword(customer.getPassword());
		cst.setMobilenumber(customer.getMobilenumber());
		cst.setEmailid(customer.getEmailid());
		cst.setUsername(customer.getUsername());
		
		return repo.save(cst);
	}


	
}
