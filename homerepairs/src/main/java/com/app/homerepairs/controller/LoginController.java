package com.app.homerepairs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.request.LoginRequest;
import com.app.homerepairs.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	private LoginService loginService; //object 
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest)
	{
		GeneralResponse checkLogin = loginService.checkLogin(loginRequest);	
		return ResponseEntity.ok(checkLogin);
	}
}
