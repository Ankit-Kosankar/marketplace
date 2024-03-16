package com.app.homerepairs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.homerepairs.model.AppUser;
import com.app.homerepairs.repo.AppUserRepo;
import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.request.LoginRequest;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AppUserRepo appUserRepo;
	
	@Override
	public GeneralResponse checkLogin(LoginRequest loginRequest) {
		
		GeneralResponse generalResponse = new GeneralResponse();
		String username = loginRequest.getUsername();
		Optional<AppUser> findyByUsername = appUserRepo.findByUsername(username);
		//List<Object[]> user = appUserRepo.getUser(username);
		String message = "";
		if(!findyByUsername.isEmpty())
		{
			System.err.println("User is Present");
			message = "User is Present! Login Successfull";
			generalResponse.setStatus(HttpStatus.OK);
			generalResponse.setMessage(message);
			generalResponse.setAppUser(findyByUsername.get());
		}
		else
		{
			System.err.print("User is Not Present! Please Check Username and Password");
			message = "User is Not Present! Please Check Username and Password";
			generalResponse.setStatus(HttpStatus.NOT_FOUND);
			generalResponse.setMessage(message);
//			generalResponse.setAppUser(findyByUsername.get());
		}		
		return generalResponse;
	}
	
	

}
