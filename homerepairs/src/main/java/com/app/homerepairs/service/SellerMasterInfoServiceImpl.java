package com.app.homerepairs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.homerepairs.model.SellerServiceInfo;
import com.app.homerepairs.repo.AppUserRepo;
import com.app.homerepairs.repo.SellerMasterInfoRepo;
import com.app.homerepairs.reponse.GeneralResponse;

@Service
public class SellerMasterInfoServiceImpl implements SellerServiceInfoService {

	@Autowired
	private SellerMasterInfoRepo sellerMasterInfoRepo;
	
	@Autowired
	private AppUserRepo appUserRepo;

	@Override
	public GeneralResponse addSellerMasterInfo(SellerServiceInfo sellerMasterInfo) {
		GeneralResponse generalResponse = new GeneralResponse();
		
		String createdBy = sellerMasterInfo.getCreatedBy();
		Long usernameExists = appUserRepo.isUsernameExists(createdBy);
		
		if( usernameExists > 0)
		{
			SellerServiceInfo save = sellerMasterInfoRepo.save(sellerMasterInfo);
			if(save.getId() > 0)
			{
				generalResponse.setMessage("Service Added Succesfully!");
				generalResponse.setStatus(HttpStatus.OK);
			}
			else
			{
				generalResponse.setMessage("Service Could Not Be Added!");
				generalResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else
		{
			generalResponse.setMessage("Seller Not FOund to add the Service!");
			generalResponse.setStatus(HttpStatus.OK);
		}
		
		return generalResponse;
	}

	@Override
	public GeneralResponse getAllServiceDetails() 
	{
		GeneralResponse generalResponse = new GeneralResponse();
		List<SellerServiceInfo>  findAll = sellerMasterInfoRepo.findAll();
		if(findAll.size() > 0)
		{
			generalResponse.setMessage("All Services!");
			generalResponse.setSellerService(findAll);
			generalResponse.setStatus(HttpStatus.OK);
		}
		else
		{
			generalResponse.setMessage("Service Could Not Be Added!");
			generalResponse.setSellerService(findAll);
			generalResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return generalResponse;
	}

	
	
}
