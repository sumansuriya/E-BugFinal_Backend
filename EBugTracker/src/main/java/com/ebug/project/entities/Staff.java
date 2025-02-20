package com.ebug.project.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "staff")
public class Staff {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int staffId;
private String name;


private String emailId;
private String userId;
protected String password;
private long mobileNo;
private int bugCount;
private String designation;


public Staff() {
super();
}


public Staff(int staffId, String name, String emailId, String userId, String password, long mobileNo, int bugCount,
		String designation) {
	super();
	this.staffId = staffId;
	this.name = name;
	this.emailId = emailId;
	this.userId = userId;
	this.password = password;
	this.mobileNo = mobileNo;
	this.bugCount = bugCount;
	this.designation = designation;
}




public int getStaffId() {
return staffId;
}


public void setStaffId(int staffId) {
this.staffId = staffId;
}


public String getName() {
return name;
}


public void setName(String name) {
this.name = name;
}


public String getEmailId() {
return emailId;
}


public void setEmailId(String emailId) {
this.emailId = emailId;
}

public String getUserId() {
	return userId;
}


public void setUserId(String userId) {
	this.userId = userId;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public long getMobileNo() {
	return mobileNo;
}

public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}



public int getBugCount() {
	return bugCount;
}


public void setBugCount(int bugCount) {
	this.bugCount = bugCount;
}


public String getDesignation() {
return designation;
}


public void setDesignation(String designation) {
this.designation = designation;
}





@Override
public String toString() {
	return "Staff [staffId=" + staffId + ", name=" + name + ", emailId=" + emailId + ", userId=" + userId
			+ ", password=" + password + ", mobileNo=" + mobileNo + ", bugCount=" + bugCount + ", designation="
			+ designation + "]";
}




}
