package com.ebug.project.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	
	private String message;
	
	// CONSTRUTOR
	public CustomerNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
