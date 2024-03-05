package com.kodnest.tunehub.Service;

import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
@Service
public interface UserService {
	public String addUser(User user);

	public Boolean emailExists(String email);
	
	public boolean validateUser(String email, String password);
	public String getRole(String email);
	public User getUser(String email);
	public void updateUser(User user);
		

	

}
