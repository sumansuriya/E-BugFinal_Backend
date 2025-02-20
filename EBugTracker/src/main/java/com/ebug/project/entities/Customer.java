package com.ebug.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int customerId;
	private String name;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String gender;
	
	private int ticketcount;
	
	private long mobilenumber;
	
	private String emailid;
	 
	
	// Constructors

	public Customer(int customerId, String name, String username, String password, String gender, int ticketcount, long mobilenumber,
			String emailid, Bug bugs) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.ticketcount = ticketcount;
		this.mobilenumber = mobilenumber;
		this.emailid = emailid;
		this.bugs = bugs;
	}
	
	
	
	public Customer () {
	 super ();
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "bug", nullable = true)
	@JsonIgnore
	private Bug bugs;
	
	
	public Bug getBugs() {
		return bugs;
	}
	public void setBugs(Bug bugs) {
		this.bugs = bugs;
	}
	
	// Setters & getters

	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getTicketcount() {
		return ticketcount;
	}

	public void setTicketcount(int ticketcount) {
		this.ticketcount = ticketcount;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}




	// To String
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", username=" + username + ", password="
				+ password + ", gender=" + gender + ", ticketcount=" + ticketcount + ", mobilenumber=" + mobilenumber
				+ ", emailid=" + emailid + ", bugs=" + bugs + "]";
	}



	 


	


	


	
	

	
   
	
	
	
	
	

}
