package com.shane.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shane.auth.dto.LoginRequest;
import com.shane.auth.dto.RegisterRequest;
import com.shane.auth.model.AppUser;
import com.shane.auth.service.AuthService;
import com.shane.auth.utils.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final AuthService authService;
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	
	public AuthController(AuthService authService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authService = authService;
		this.authenticationManager = authenticationManager;
		this.jwtUtil= jwtUtil; 
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
		
		AppUser user = authService.register(request.getUsername(), request.getPassword());
		
		return ResponseEntity.ok("User registered successfully: " + user.getUsername());
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest request) {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(),
						request.getPassword()
				)
			);
		
		AppUser user = authService.findByUsername(request.getUsername());
		String token = jwtUtil.generateToken(user);
		
		return ResponseEntity.ok(token);
	
	}

}
