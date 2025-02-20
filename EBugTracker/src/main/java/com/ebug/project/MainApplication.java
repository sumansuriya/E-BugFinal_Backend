package com.ebug.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
			
		SpringApplication.run(MainApplication.class, args);
	
		System.out.println("Server is Running");
		
	}

}
