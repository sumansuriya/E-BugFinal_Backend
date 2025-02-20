package com.ebug.project.services;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebug.project.entities.Bug;
import com.ebug.project.repositories.BugRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BugServiceTest {
	
	@MockBean
	private BugRepository bgr;
	
	
	@Autowired
     private BugService bgsr;
	
	
  
     Bug bug = new Bug();
	
	@Test
	void testBugTitle() {
		bug.setBugTitle("E-Bug Tracker");
	assertNotNull(bug.getBugTitle());
	}
	
	@Test
	void testBugDescription() {
		bug.setBugDescription("E-Bug Tracker Application");
	assertNotNull(bug.getBugDescription());
	}
	
	@Test
	void testBugSolution() {
		bug.setBugSolution("Solved Successfully");
	assertNotNull(bug.getBugSolution());
	}
	
	
	


	@Test
	void testBugList1() {
		List<Bug> bgs = bgsr.viewAllBugs();
		assertNotNull(bgs);
	}

	
//	@Test
//	void testBugList2() {
//		List<Bug> bgs = bgsr.viewAllBugs();
//		assertNull(bgs);
//	}
}
