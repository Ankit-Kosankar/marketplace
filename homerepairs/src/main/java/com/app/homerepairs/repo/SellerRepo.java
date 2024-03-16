package com.app.homerepairs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.homerepairs.model.Seller;

public interface SellerRepo extends JpaRepository<Seller, Long>
{

	Optional<Seller> findByPhoneNumber(String phoneNumber);
	
}
