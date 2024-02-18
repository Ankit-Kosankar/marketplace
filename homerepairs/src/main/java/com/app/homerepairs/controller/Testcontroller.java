package com.app.homerepairs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.homerepairs.service.AppUserService;

@RequestMapping("/api")
@RestController
public class Testcontroller {

	@Autowired
	AppUserService appUserService;

	
	@GetMapping("/home")
	public String home() {
		return "welcome to home";
	};


    


}


