package com.app.homerepairs.service;

import com.app.homerepairs.model.Cart;
import com.app.homerepairs.reponse.GeneralResponse;

public interface CartService {

	public GeneralResponse addToCart(Cart cart);

	public GeneralResponse getAllCartItemsByPhoneNumber(Cart cart);

	

}
