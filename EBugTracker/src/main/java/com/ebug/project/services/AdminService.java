package com.ebug.project.services;

import org.springframework.stereotype.Service;

import com.ebug.project.entities.Admin;

@Service
public interface AdminService {

	public Admin getAdmin(String username, String password);

	public Admin validateLogin(String username, String password);

	public Admin saveAdmin();



}
