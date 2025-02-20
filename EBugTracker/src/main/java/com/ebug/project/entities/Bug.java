package com.ebug.project.entities;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "bug")
public class Bug {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int bugId;
private String bugTitle;
private String ticketId;
private String bugDescription;
private String criticalLevel;

@CreationTimestamp
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate bugRaisedDate;

private String bugStatus;
private String bugSolution;


public Bug() {
super();
}

public Bug(int bugId, String bugTitle, String ticketId, String bugDescription, String criticalLevel,
		LocalDate bugRaisedDate, String bugStatus, String bugSolution, Customer customer, Staff staff,
		Project project) {
	super();
	this.bugId = bugId;
	this.bugTitle = bugTitle;
	this.ticketId = ticketId;
	this.bugDescription = bugDescription;
	this.criticalLevel = criticalLevel;
	this.bugRaisedDate = bugRaisedDate;
	this.bugStatus = bugStatus;
	this.bugSolution = bugSolution;
	this.customer = customer;
	this.staff = staff;
	this.project = project;
}





@ManyToOne
@JoinColumn(name = "customerId")
private Customer customer;


@ManyToOne
@JoinColumn(name = "staffId")
private Staff staff;


@ManyToOne
@JoinColumn(name = "projectId")
private Project project;


public int getBugId() {
return bugId;
}

public void setBugId(int bugId) {
this.bugId = bugId;
}


public String getBugTitle() {
return bugTitle;
}

public void setBugTitle(String bugTitle) {
this.bugTitle = bugTitle;
}


public String getTicketId() {
	return ticketId;
}

public void setTicketId(String ticketId) {
	this.ticketId = ticketId;
}


public String getBugDescription() {
return bugDescription;
}

public void setBugDescription(String bugDescription) {
this.bugDescription = bugDescription;
}


public String getCriticalLevel() {
return criticalLevel;
}

public void setCriticalLevel(String criticalLevel) {
this.criticalLevel = criticalLevel;
}



public LocalDate getBugRaisedDate() {
	return bugRaisedDate;
}

public void setBugRaisedDate(LocalDate bugRaisedDate) {
	this.bugRaisedDate = bugRaisedDate;
}

public String getBugStatus() {
return bugStatus;
}

public void setBugStatus(String bugStatus) {
this.bugStatus = bugStatus;
}


public String getBugSolution() {
return bugSolution;
}

public void setBugSolution(String bugSolution) {
this.bugSolution = bugSolution;
}


public Staff getStaff() {
return staff;
}


public void setStaff(Staff staff) {
this.staff = staff;
}


public Project getProject() {
return project;
}

public void setProject(Project project) {
this.project = project;
}



public Customer getCustomer() {
return customer;
}

public void setCustomer(Customer customer) {
this.customer = customer;
}





@Override
public String toString() {
	return "Bug [bugId=" + bugId + ", bugTitle=" + bugTitle + ", ticketId=" + ticketId + ", bugDescription="
			+ bugDescription + ", criticalLevel=" + criticalLevel + ", bugRaisedDate=" + bugRaisedDate + ", bugStatus="
			+ bugStatus + ", bugSolution=" + bugSolution + ", customer=" + customer + ", staff=" + staff + ", project="
			+ project + "]";
}



}

