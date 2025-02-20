package com.ebug.project.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebug.project.entities.Admin;
import com.ebug.project.repositories.AdminRepository;
import com.ebug.project.repositories.StaffRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository repoAdmin;

	@Autowired
	StaffRepository repoStaff;


   
	@Override
	public Admin getAdmin(String username, String password) {

		Admin roleCheck = repoAdmin.admin(username, password);

		return roleCheck;
		
	}
	

	@Override
	public Admin validateLogin(String username, String password) {
	
		
		Admin admin = repoAdmin.admin(username, password);

		if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
			return admin;
		}

		return null;
	}

	
	public Admin saveAdmin() {
		

		Admin ad = new Admin();
		ad.setUsername("admin");
		ad.setPassword("admin");
		return	repoAdmin.save(ad);
	}

	

}
