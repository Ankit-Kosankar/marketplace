package com.app.homerepairs.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AppUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "phone_number") 
	private String phoneNumber;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "name" )
	private String name;
	
	@Column(name = "password" )
	private String password;
	
//	@Column(name = "dob" )
//	@JsonFormat
//	private LocalDate dob;
	
	@Column(name = "address" )
	private String address;
	
	@Column(name = "email" )
	private String email;   
	
	@ManyToOne
	@JoinTable(name = "role_id")  //name is column name 
	@JsonManagedReference
	private Roles role;			//Object 
	
	//Only for many to many
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(
//		  name = "user_roles", 
//	      joinColumns = @JoinColumn(name = "user_id"), 
//	      inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private List<Roles> role;
	
//	public List<Roles> getRole() {
//		return role;
//	}
//
//	public void setRole(List<Roles> role) {
//		this.role = role;
//	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AppUser() {
		super();
	}

	public AppUser(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
		this.username = phoneNumber;
	}
	
	public AppUser(String password, LocalDate dob) {
		super();
		this.password = password;
		
	}

	public AppUser(Long id, String phoneNumber, String username, String name, String password, LocalDate dob,
			String address, String email, String role) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.name = name;
		this.password = password;
		
		this.address = address;
		this.email = email;
	}
	
	
	
	
	
}
