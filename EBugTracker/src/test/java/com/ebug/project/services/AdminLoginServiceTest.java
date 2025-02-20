package com.ebug.project.services;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ebug.project.entities.Admin;

@RunWith(SpringRunner.class)
@SpringBootTest 

public class AdminLoginServiceTest {
	
    Admin admin = new Admin();
    
    @Test    
    void testName() {
        admin.setUsername("admin");
        assertNotNull(admin.getUsername());
    }
    
    @Test    
    void testPassword() {
        admin.setPassword("admin");
        assertNotNull(admin.getPassword());
    }
}