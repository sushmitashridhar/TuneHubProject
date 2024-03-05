package com.kodnest.tunehub.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.Service.SongService;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceImpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl serviceImpl;
	
	@Autowired 
	SongService songService; 

	public UserController(UserServiceImpl serviceImpl) {
		super();
		this.serviceImpl = serviceImpl;
	}
	@PostMapping("/registration")
	public String addUser(@ModelAttribute User user)
	{
		
		//email taken from registration form
		String email=user.getEmail();
		
		//checking if email as entered in registration form is present in DB or not 
		Boolean status =serviceImpl.emailExists(email);
		if(status == false) {
			serviceImpl.addUser(user);
			System.out.println("User added");
			
		}else {
			System.out.println("User already exists");
		}		
		return "Login";
		
	}	
	 @GetMapping("/validate")//we can even use the get mapping
	    public String validate(@RequestParam ("email") String email,
	    		@RequestParam("password") String password,HttpSession session,Model model) {
	    	
	    	if(serviceImpl.validateUser(email,password)==true){
	    		String role = serviceImpl.getRole(email);
	    		session.setAttribute("email", email);
	    		if(role.equals("admin")) {
	    			return "AdminHome";//this will return home.html
	    		}else {
	    			User user=serviceImpl.getUser(email);
	    			boolean userstatus=user.isIspremium();
	    			//logic
	    			List<Song> songList=songService.fetchAllSongs();
	    			model.addAttribute("songs", songList);
	    			
	    			model.addAttribute("ispremium", userstatus);
	    			return "CustomerHome";
	    		}
	    	}else {
	    		return "Login";
	    		
	    	}
	    	
	    }
        	
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "Login";
		 
	 }
		

}
