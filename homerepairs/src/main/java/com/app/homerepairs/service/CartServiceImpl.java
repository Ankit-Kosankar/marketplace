package com.app.homerepairs.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.homerepairs.model.Cart;
import com.app.homerepairs.model.SellerServiceInfo;
import com.app.homerepairs.repo.CartRepo;
import com.app.homerepairs.repo.SellerMasterInfoRepo;
import com.app.homerepairs.reponse.GeneralResponse;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private  SellerMasterInfoRepo sellerMasterInfoRepo;
	
	@Override
	public GeneralResponse addToCart(Cart cart) {
		GeneralResponse generalResponse = new GeneralResponse();
		
		Cart save = cartRepo.save(cart);
		if(save.getId()>0)
		{
			generalResponse.setMessage("Item Added To Cart");
			generalResponse.setStatus(HttpStatus.OK);
		}
		else
		{
			generalResponse.setMessage("Item Added To Cart");
			generalResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return generalResponse;
	}

	//get all cart items + total Amount
	@Override
	public GeneralResponse getAllCartItemsByPhoneNumber(Cart cart)
	{
		GeneralResponse generalResponse = new GeneralResponse();
		List<SellerServiceInfo> listSellerServieInfo = new ArrayList<>();
		List<Cart> allByPhoneNumber = cartRepo.findAllByPhoneNumber(cart.getPhoneNumber());
		BigDecimal totalAmount = BigDecimal.ZERO;
		Integer totalItems = 0;
		if(allByPhoneNumber.size() > 0)
		{
			for(int i = 0; i < allByPhoneNumber.size() ; i++)
			{
				Long sellerServiceId = allByPhoneNumber.get(i).getSellerServiceId();
				Optional<SellerServiceInfo> byId = sellerMasterInfoRepo.findById(sellerServiceId);
				if(byId.isPresent())
				{
					SellerServiceInfo sellerServiceInfo = byId.get();
					totalAmount = totalAmount.add(sellerServiceInfo.getServicePrice());
					totalItems = totalItems + 1;
					listSellerServieInfo.add(sellerServiceInfo);
				}
			}
			generalResponse.setMessage("All Items In Cart");
			generalResponse.setStatus(HttpStatus.OK);
			generalResponse.setSellerService(listSellerServieInfo);
			generalResponse.setTotalItems(totalItems);
		}
		else
		{
			generalResponse.setMessage("No Items In Cart");
			generalResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		generalResponse.setTotalAmount(totalAmount);
		return generalResponse;
	}
}
