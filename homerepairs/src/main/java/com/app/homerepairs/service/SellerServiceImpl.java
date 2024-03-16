package com.app.homerepairs.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.homerepairs.model.AppUser;
import com.app.homerepairs.model.Seller;
import com.app.homerepairs.repo.AppUserRepo;
import com.app.homerepairs.repo.SellerRepo;
import com.app.homerepairs.reponse.GeneralResponse;

@Service
public class SellerServiceImpl implements SellerService
{

	@Autowired
	private SellerRepo sellerRepo;
	 
	@Autowired
	private AppUserRepo appUserRepo;
	
	@Override
	public GeneralResponse addSeller(Seller seller)
	{
		Optional<AppUser> Username = 
				appUserRepo.findByUsername(seller.getPhoneNumber());
		GeneralResponse generalResponse = new GeneralResponse();
		if(Username.isEmpty())
		{
			Seller save = sellerRepo.save(seller);
			if(save.getId() > 0)
			{
				AppUser mapSellerDataToUser = mapSellerDataToUser(seller);
				appUserRepo.save(mapSellerDataToUser);
				generalResponse.setMessage("Seller Registration Successfull");
				generalResponse.setStatus(HttpStatus.OK);
			}
		}
		else
		{
			generalResponse.setMessage("Phone Number already Exists! Please Use Different Phone");
			generalResponse.setStatus(HttpStatus.CONFLICT);
		}
		return generalResponse;
	}
	
	public AppUser mapSellerDataToUser(Seller seller)
	{
		String email = seller.getEmail();
		String firstName = seller.getFirstName();
		String lastName = seller.getLastName();
		String phoneNumber = seller.getPhoneNumber();
		String address = seller.getAddress();
		LocalDate dob = seller.getDob();
		AppUser appUser = new AppUser();
		appUser.setUsername(phoneNumber);
		appUser.setPassword("123456");
		appUser.setPhoneNumber(phoneNumber);
		appUser.setName(firstName+" "+lastName);
		appUser.setAddress(address);
//		appUser.setRole("seller");
//		appUser.setDob(dob);
		appUser.setEmail(email);
		return appUser;	
	}

	@Override
	public GeneralResponse getSellerDetails(String phoneNumber) {
		
		GeneralResponse generalResponse = new GeneralResponse();
		Optional<Seller> byPhoneNumber = sellerRepo.findByPhoneNumber(phoneNumber);
		if(byPhoneNumber.isPresent())
		{
			
			generalResponse.setMessage("Seller Registration Successfull");
			generalResponse.setStatus(HttpStatus.OK);	
			generalResponse.setSeller(byPhoneNumber.get());
		}
		else
		{
			generalResponse.setMessage("Seller Does not Exist or Registered! Please Register First");
			generalResponse.setStatus(HttpStatus.NOT_FOUND);
		}
		return generalResponse;
	}
	
	

}
