package com.app.homerepairs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.homerepairs.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Long>
{

	public List<Cart> findAllByPhoneNumber(String phoneNumber);

}
