package com.app.homerepairs.service;

import java.util.List;

import com.app.homerepairs.model.AppUser;
import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.request.AppUserDTO;

public interface AppUserService
{
	//public GeneralResponse addUser(AppUser appUser);

	public List<AppUser> getAllUsers();

	public Boolean updateUser(AppUserDTO appUserDTO);

	public GeneralResponse deleteByUsername(String username);

	public GeneralResponse addUser(AppUserDTO appUserDTO);
}
  