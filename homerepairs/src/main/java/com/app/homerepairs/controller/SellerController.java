package com.app.homerepairs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.homerepairs.model.Seller;
import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {

	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addSeller(@RequestBody Seller seller) {
		GeneralResponse  sellerResponse = sellerService.addSeller(seller);
		return ResponseEntity.ok(sellerResponse);
	}
	
	@PostMapping("/get")
	public ResponseEntity<?> addSeller(@RequestParam String sellerDetails) {
		GeneralResponse  sellerResponse = sellerService.getSellerDetails(sellerDetails);
		return ResponseEntity.ok(sellerResponse);
	}
	
	
}
