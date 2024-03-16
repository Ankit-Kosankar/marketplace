package com.app.homerepairs.service;
import com.app.homerepairs.model.SellerServiceInfo;
import com.app.homerepairs.reponse.GeneralResponse;

public interface SellerServiceInfoService
{
	public GeneralResponse addSellerMasterInfo(SellerServiceInfo sellerMasterInfo);

	public GeneralResponse getAllServiceDetails();
}
