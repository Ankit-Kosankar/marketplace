package com.app.homerepairs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.homerepairs.repo.AppUserRepo;
import com.app.homerepairs.request.LoginRequest;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AppUserRepo appUserRepo;
	
	@Override
	public String checkLogin(LoginRequest loginRequest) {
		String username = loginRequest.getUsername();
		//Optional<AppUser> findyByUsername = appUserRepo.findByUsername(username);
		List<Object[]> user = appUserRepo.getUser(username);
		String message = "";
		if(!user.isEmpty())
		{
			System.err.println("User is Present");
			message = "User is Present! Login Successfull";
		}
		else
		{
			System.err.print("User is Not Present! Please Check Username and Password");
			message = "User is Not Present! Please Check Username and Password";
		}		
		return message;
	}
	
	

}
