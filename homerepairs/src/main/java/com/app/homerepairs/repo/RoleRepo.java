package com.app.homerepairs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.homerepairs.model.Roles;

public interface RoleRepo extends JpaRepository<Roles, Long>
{
	Optional<Roles> findByRoleName(String roleName);
}
