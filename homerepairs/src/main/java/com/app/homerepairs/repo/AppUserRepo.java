package com.app.homerepairs.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.homerepairs.model.AppUser;

// this interface used to interect witn datasbase example save find 



// T = entity model , Id = primary key data type
@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long>
{	
	//keyword tell JPA to generate a query 
	//Username : username
	//user defined method
	Optional<AppUser> findByUsername(String username);
	
	//Native Query [Not JPQL ->]
	@Query(value = "SELECT username,name  FROM user WHERE username = :username" , nativeQuery = true)
	List<Object[]> getUser(@Param("username") String username);

	Optional<AppUser> deleteByUsername(String username);

	@Query(value = "SELECT COUNT(username) FROM user WHERE username =:username" , nativeQuery = true)
	Long isUsernameExists(@Param("username") String username);

}
