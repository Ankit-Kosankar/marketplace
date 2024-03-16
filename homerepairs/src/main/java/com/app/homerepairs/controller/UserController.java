package com.app.homerepairs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.homerepairs.model.AppUser;
import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.request.AppUserDTO;
import com.app.homerepairs.service.AppUserService;
//Basic Crud Operations 
@RestController 
@RequestMapping("/user") // base path 
public class UserController {
	
	//Object of service to acess service method 
	@Autowired
	AppUserService appUserService;   
	
	// save an user [CREATE]
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody AppUserDTO appUserDTO) {
		GeneralResponse user = appUserService.addUser(appUserDTO);
		return ResponseEntity.ok(user);
	}

	//get all User [Read]
	@GetMapping("/all")
	public ResponseEntity<?> getallUsers()
	{
		List<AppUser> allUsers = appUserService.getAllUsers();
		
		if(allUsers.isEmpty())
		{
			GeneralResponse genRes = 
					new GeneralResponse("Users Not Found",HttpStatus.NOT_FOUND,allUsers);
			
			return ResponseEntity.ok(genRes);	
		}
		else
		{
			GeneralResponse genRes = 
					new GeneralResponse("all Users List",HttpStatus.OK,allUsers);
			return ResponseEntity.ok(genRes);	
		}
	}

	//update the User [Update]
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody AppUserDTO appUserDTO) {
		Boolean updateUser = appUserService.updateUser(appUserDTO);
		if(updateUser == true)
		{
			//Object created manualluy
			GeneralResponse generalResponse = new GeneralResponse();
			generalResponse.setMessage("User Updated Successfulluy");
			generalResponse.setStatus(HttpStatus.OK);
			return ResponseEntity.ok(generalResponse);	
		}
		else
		{
			GeneralResponse generalResponse = new GeneralResponse();
			generalResponse.setMessage("User Could Not Be Updated");
			generalResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return ResponseEntity.ok(generalResponse);	
		}
	}
	
	//update the User [Delete]
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(@RequestParam String username)
	{
		appUserService.deleteByUsername(username);
		return null;
	}
	
}
