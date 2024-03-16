package com.app.homerepairs.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.homerepairs.model.AppUser;
import com.app.homerepairs.model.Roles;
import com.app.homerepairs.repo.AppUserRepo;
import com.app.homerepairs.repo.RoleRepo;
import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.request.AppUserDTO;


@Service
public class AppUserServiceImpl implements AppUserService {
	
	@Autowired
	private AppUserRepo appUserRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public GeneralResponse addUser(AppUserDTO appUserDTO)
	{	
		//Username and phone are same 
		//new keyword provides address of memory to the object in ram
		
		GeneralResponse generalResponse = new GeneralResponse();
		String userRole = appUserDTO.getRole();
		Optional<Roles> byRoleName = roleRepo.findByRoleName(userRole);
		if(byRoleName.isEmpty())
		{
			generalResponse.setMessage("Role Not Found");
			generalResponse.setStatus(HttpStatus.NOT_FOUND);
			return generalResponse;
		}
		AppUser appUser = mapDTOtoUser(appUserDTO);
		
		appUser.setUsername(appUser.getPhoneNumber());
		Optional<AppUser> byUsername = 
				appUserRepo.findByUsername(appUser.getUsername());
		if(byUsername.isPresent())
		{
			generalResponse.setMessage("Phone aleady Exists! Please Choose different Username");
			generalResponse.setStatus(HttpStatus.CONFLICT);
			return generalResponse;
		}
		else
		{
			appUser.setUsername(appUser.getPhoneNumber()); 
			appUser.setRole(byRoleName.get());
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

	private AppUser mapDTOtoUser(AppUserDTO appUserDTO)
	{
		String address = appUserDTO.getAddress();
		LocalDate dob = appUserDTO.getDob();
		String email = appUserDTO.getEmail();
		String name = appUserDTO.getName();
		String password = appUserDTO.getPassword();
		String phoneNumber = appUserDTO.getPhoneNumber();
		String role = appUserDTO.getRole();
		String username = appUserDTO.getUsername();
		
		AppUser appUser = new AppUser();
		
		appUser.setAddress(address);
		appUser.setEmail(email);
		appUser.setName(username);
		appUser.setPassword(password);
		appUser.setPhoneNumber(phoneNumber);
		//appUser.setRole();
		appUser.setUsername(username);
		appUser.setName(name);
		return appUser;
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

	@Override
	public GeneralResponse deleteByUsername(String username)
	{	
		GeneralResponse generalResponse = new GeneralResponse();
		Optional<AppUser> deleteByUsername = appUserRepo.findByUsername(username);	
		if(deleteByUsername.isPresent())
		{
			appUserRepo.deleteById(deleteByUsername.get().getId());
			generalResponse.setMessage("Deleted Successfully");
			generalResponse.setStatus(HttpStatus.OK);
			return generalResponse;
		}
		else
		{
			generalResponse.setMessage("User Name Not Found");
			generalResponse.setStatus(HttpStatus.NOT_FOUND);
			return generalResponse;
		}
		
	}
}
