package com.ebug.project.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebug.project.entities.Customer;
import com.ebug.project.repositories.CustomerRepository;


@RunWith(SpringRunner.class)
@SpringBootTest

public class CustomerServiceTest {
	
@MockBean
private CustomerRepository repo;

Customer customer = new Customer();

@Test
void testid() {
customer.setCustomerId(1);
assertEquals(1, customer.getCustomerId());
}


 @Test
void testName() {
customer.setUsername("Vishnu");
assertNotNull(customer.getUsername());
}
@Test
void testemail() {
customer.setEmailid("Vishnu@gmail.com");
assertNotNull(customer.getEmailid());
}


 @Test
void testGender() {
customer.setGender("Male");
assertNotNull(customer.getGender());
}

}