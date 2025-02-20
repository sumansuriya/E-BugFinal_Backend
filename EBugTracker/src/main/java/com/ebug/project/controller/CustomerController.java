package com.ebug.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebug.project.entities.Customer;
import com.ebug.project.exceptions.CustomerNotFoundException;
import com.ebug.project.repositories.CustomerRepository;
import com.ebug.project.services.CustomerService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/v1")

public class CustomerController {
	
	@Autowired
	CustomerService customerservice;
	
	@Autowired
	CustomerRepository repo;
	
	
	// TO GET LIST & DETAILS OF ALL CUSTOMERS	

		@GetMapping(path = "/customer/view", produces = { "application/json" })
		public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customerlist = customerservice.getAllCustomers();
		return new ResponseEntity<>(customerlist, HttpStatus.OK);
		
		}
	
		// CUSTOMER REGISTRATION
		
		@PostMapping(path = "/customer/add", consumes = { "application/json" })
		public ResponseEntity<Customer> saveCustomers(@RequestBody Customer customer) {
			
			Customer newCustomer = customerservice.saveCustomers(customer);
			
			return new ResponseEntity<>(newCustomer, HttpStatus.OK);
		}
		
		
	
// CUSTOMER LOGIN	
	
	@PostMapping(path = "/customer/login", consumes = { "application/json" } )
	public ResponseEntity<Customer> loginCheck(@RequestBody Customer customer) {
		String message = null;
		
		Customer customerlogin = customerservice.validateLogin(customer.getUsername(), customer.getPassword());
		if (customerlogin == null) {
			throw new CustomerNotFoundException("Username or Password Incorrect.. Please, Enter correct credentials");
			
		}else {
			message= "Welcome " + String.valueOf(customerlogin.getUsername());
		}
		return new ResponseEntity<>(customerlogin, HttpStatus.OK);
	}
	
// CUSTOMER UPDATE
	
	@PutMapping(path = "/customer/update/{customerId}", consumes = { "application/json" } )
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customers) {
		
		Customer cs = customerservice.updateCustomer(customers, customerId);
		
		
		return new ResponseEntity<>(cs , HttpStatus.OK);
	
		
	}
	
	@GetMapping("/customer/view/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId) {
	Customer customer = customerservice.getCustomerById(customerId);
	return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	 
	
}

	

	

