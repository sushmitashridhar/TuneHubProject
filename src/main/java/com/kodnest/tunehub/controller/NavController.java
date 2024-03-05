package com.kodnest.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/login")
    public String login() {
        return "login"; // This will return login.html
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration"; // This will return registration.html
    }
    @GetMapping("/NewSong")
    public String NewSong() {
        return "NewSong"; // This will return registration.html
    }
   
	

}
