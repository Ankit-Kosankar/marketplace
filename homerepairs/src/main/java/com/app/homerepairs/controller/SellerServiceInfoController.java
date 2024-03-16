package com.app.homerepairs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.homerepairs.model.SellerServiceInfo;
import com.app.homerepairs.reponse.GeneralResponse;
import com.app.homerepairs.service.SellerServiceInfoService;

@RestController
@RequestMapping("/serviceinfo")
public class SellerServiceInfoController 
{

	@Autowired
	private SellerServiceInfoService sellerServiceInfoService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addSeller(@RequestBody SellerServiceInfo sellerServiceInfo) {
		GeneralResponse  sellerResponse = sellerServiceInfoService.addSellerMasterInfo(sellerServiceInfo);
		return ResponseEntity.ok(sellerResponse);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getALServices() {
		GeneralResponse  sellerResponse = sellerServiceInfoService.getAllServiceDetails();
		return ResponseEntity.ok(sellerResponse);
	}
	
}
