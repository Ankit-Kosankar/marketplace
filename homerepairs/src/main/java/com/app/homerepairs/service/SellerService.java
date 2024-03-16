package com.app.homerepairs.service;

import com.app.homerepairs.model.Seller;
import com.app.homerepairs.reponse.GeneralResponse;

public interface SellerService 
{
	public GeneralResponse addSeller(Seller seller);

	public GeneralResponse getSellerDetails(String sellerDetails);
}
