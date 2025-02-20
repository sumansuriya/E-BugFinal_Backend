package com.ebug.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "admin")
public class Admin {

	@Id
	private String username;

	protected String password;

	public Admin() {
     super();
	}

	
	
	//	CONSTRUCTORS 

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
     
     
     
	

	//	GETTERS & SETTERS

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//	TO STRING

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}

}
