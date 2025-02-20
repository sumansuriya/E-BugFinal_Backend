package com.ebug.project.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



import com.ebug.project.entities.Project;

import com.ebug.project.repositories.ProjectRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {

@MockBean
private ProjectRepository ptr;

@Autowired
private ProjectService pts;



Project project = new Project();



@Test
void testid() {
project.setProjectId(1);
assertEquals(1, project.getProjectId());
}




@Test
void testName() {
project.setProjectName("EBug Tracker");
assertNotNull(project.getProjectName());
}



@Test
void testDescription() {
project.setProjectDescription("find the bugs");
assertNotNull(project.getProjectDescription());
}



@Test
void addProjectTest1() {
Project prt = new Project();

prt.setProjectName("EBug Tracker");
prt.setProjectDescription("find the bugs");

Mockito.when(ptr.save(prt)).thenReturn(prt);
assertEquals(prt, pts.addProject(prt));

}



//@Test
//void addProjectTest2() {
//Project prt = new Project();
//
//prt.setProjectName("EBug Tracker");
//prt.setProjectDescription("find the bugs");
//
//Mockito.when(ptr.save(prt)).thenReturn(prt);
//assertNull(pts.addProject(prt));
//
//}




}