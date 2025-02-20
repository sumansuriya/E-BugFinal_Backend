package com.ebug.project.services;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebug.project.entities.Staff;
import com.ebug.project.repositories.StaffRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffServiceTest {

	
	@MockBean
	private StaffRepository str;
	
    @Autowired
    private StaffService stsr;
    

    Staff staff = new Staff();


@Test
void testName() {
staff.setName("Harsha");
assertNotNull(staff.getName());
}


@Test
void testemail() {
staff.setEmailId("suman@gmail.com");
assertNotNull(staff.getEmailId());
}


@Test
void testDesignation() {
staff.setDesignation("Developer");
assertNotNull(staff.getDesignation());
}


@Test
void addStaffTest1() {
Staff stf = new Staff();

stf.setName("Moosa");
stf.setMobileNo(1353786543);
stf.setEmailId("ms@sk.com");
stf.setDesignation("Developer");
stf.setBugCount(3);

Mockito.when(str.save(stf)).thenReturn(stf);
assertEquals(stf, stsr.addStaffDetails(stf));
}


//@Test
//void addStaffTest2() {
//Staff stf = new Staff();
//
//stf.setName("Moosa");
//stf.setMobileNo(1353786543);
//stf.setEmailId("ms@sk.com");
//stf.setDesignation("Developer");
//stf.setBugCount(3);
//
//Mockito.when(str.save(stf)).thenReturn(stf);
//assertNull(stsr.addStaffDetails(stf));
//}



@Test
void testStaffList1() {
	
	List<Staff> stffList = stsr.getStaffDetails();
	assertNotNull(stffList);	
}


//@Test
//void testStaffList2() {
//	
//	List<Staff> stfList = stsr.getStaffDetails();
//	assertNull(stfList);
//}


}