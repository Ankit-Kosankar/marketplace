package com.app.homerepairs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.homerepairs.model.AppUser;
import com.app.homerepairs.repo.AppUserRepo;
import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.request.AppUserDTO;


@Service
public class AppUserServiceImpl implements AppUserService {
	
	@Autowired
	private AppUserRepo appUserRepo;
	
	@Override
	public GeneralResponse addUser(AppUser appUser)
	{	
		GeneralResponse generalResponse = new GeneralResponse();
		Optional<AppUser> byUsername = 
				appUserRepo.findByUsername(appUser.getUsername());
		if(byUsername.isPresent())
		{
			generalResponse.setMessage("UserName aleady Exists! Please Choose different Username");
			generalResponse.setStatus(HttpStatus.CONFLICT);
			return generalResponse;
		}
		else
		{
			AppUser save = appUserRepo.save(appUser);	
			Long userId = save.getId();
			if(userId > 0)
			{
				//Object created manualluy
				generalResponse.setMessage("User Saved Successfulluy");
				generalResponse.setStatus(HttpStatus.OK);	
				return generalResponse;
			}
			else
			{
				
				generalResponse.setMessage("User Could Not Be Saved");
				generalResponse.setStatus(HttpStatus.NOT_FOUND);
				return generalResponse;
			}
		}

	}

	@Override
	public List<AppUser> getAllUsers() {
		List<AppUser> allUsers = appUserRepo.findAll();
		return allUsers;
	}

	@Override
	public Boolean updateUser(AppUserDTO appUserDTO) {
		String username = appUserDTO.getUsername();
		Optional<AppUser> user = appUserRepo.findByUsername(username);
		if(user.isPresent())
		{
			AppUser appUser = user.get();
			updateUserParameters(appUser,appUserDTO);
			AppUser savedUser = appUserRepo.save(appUser);
			if(savedUser.getId() > 0)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public AppUser updateUserParameters(AppUser appUser, AppUserDTO appUserDto)
	{
		if(appUserDto.getAddress() != null)	
		{
			appUser.setAddress(appUserDto.getAddress());
		}
		if(appUserDto.getEmail() != null)	
		{
			appUser.setEmail(appUserDto.getEmail());
		}
		if(appUserDto.getName() != null)	
		{
			appUser.setName(appUserDto.getName());
		}
		if(appUserDto.getPassword() != null)	
		{
			appUser.setPassword(appUserDto.getPassword());
		}
		if(appUserDto.getPhoneNumber() != null)	
		{
			appUser.setPhoneNumber(appUserDto.getPhoneNumber());
		}
		return appUser;
	}
}
