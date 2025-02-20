package com.ebug.project.exceptions;

public class ProjectNotFoundException extends RuntimeException {
	
	private String message;

	public ProjectNotFoundException(String message) {
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
