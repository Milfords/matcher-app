package com.shane.auth.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shane.auth.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, UUID> {
	
	Optional<AppUser> findByUsername(String username);

}
