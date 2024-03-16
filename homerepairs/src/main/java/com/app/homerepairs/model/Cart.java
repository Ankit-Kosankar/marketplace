package com.app.homerepairs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "seller_service_id" )
	private Long sellerServiceId;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "order_id")
	private String orderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSellerServiceId() {
		return sellerServiceId;
	}

	public void setSellerServiceId(Long sellerServiceId) {
		this.sellerServiceId = sellerServiceId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
