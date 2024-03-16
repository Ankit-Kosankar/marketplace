package com.app.homerepairs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.homerepairs.model.Cart;
import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addToCart(@RequestBody Cart cart)
	{
		GeneralResponse toCart = cartService.addToCart(cart);
		return ResponseEntity.ok(toCart);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getALlCartItems(@RequestBody Cart cart) {
		List<?> generalList = new ArrayList<>();
		GeneralResponse  sellerResponse = cartService.getAllCartItemsByPhoneNumber(cart);
		return ResponseEntity.ok(sellerResponse);
	}
}
