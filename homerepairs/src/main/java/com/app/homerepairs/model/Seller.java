package com.app.homerepairs.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "seller")
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email")
	private String email;
	
	@Column(name = "first_name" )
	private String firstName;
	
	@Column(name = "last_name" )
	private String lastName;
	
	@Column(name = "phone_number" )
	private String phoneNumber;
	
	@Column(name = "dob" )
	private LocalDate dob;
	
	@Column(name = "address" )
	private String address;
	
	@Column(name = "seller_type" )
	private String sellerType;

	@ManyToMany()
	@JoinTable(name = "seller_service",
    joinColumns = @JoinColumn(name = "seller_id"),
    inverseJoinColumns = @JoinColumn(name = "service_id"))
	@JsonBackReference
	private List<SellerServiceInfo> sellerServiceInfo;
	
	public List<SellerServiceInfo> getSellerServiceInfo() {
		return sellerServiceInfo;
	}

	public void setSellerServiceInfo(List<SellerServiceInfo> sellerServiceInfo) {
		this.sellerServiceInfo = sellerServiceInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSellerType() {
		return sellerType;
	}

	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}
	
	

}
