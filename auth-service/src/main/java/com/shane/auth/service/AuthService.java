package com.shane.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.shane.auth.model.AppUser;
import com.shane.auth.repository.UserRepository;

@Service
public class AuthService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public AppUser register(String username, String password) {
		
		if (userRepository.findByUsername(username).isPresent()) {
			throw new RuntimeException("Username already exists");
		}
		
		AppUser user = new AppUser();
		
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setRole("USER");
		
		return userRepository.save(user);
		
	}
	
	public AppUser findByUsername(String username) {
		
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User not found"));
	}

}
