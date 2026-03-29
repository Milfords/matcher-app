package com.shane.payment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shane.payment.dto.PaymentRequest;
import com.shane.payment.dto.PaymentResponse;
import com.shane.payment.model.Payment;
import com.shane.payment.service.PaymentService;

import org.springframework.security.oauth2.jwt.Jwt;

@Controller
@RequestMapping("/api/payment")
public class PaymentController {
	
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping
	public ResponseEntity<PaymentResponse> createPayment(
			@RequestBody PaymentRequest request,
			@AuthenticationPrincipal Jwt jwt) {
		
		UUID ownerId = extractOwnerId(jwt);
		
		Payment saved = paymentService.createPayment(ownerId, request);
		
		return ResponseEntity.ok(PaymentResponse.from(saved));
		
	}
	
	@GetMapping
	public ResponseEntity<List<PaymentResponse>> getAllPayments(@AuthenticationPrincipal Jwt jwt) {
		
		UUID ownerId = extractOwnerId(jwt);
		
		List<PaymentResponse> payments = paymentService.getPaymentsByOwnerId(ownerId)
				.stream()
				.map(PaymentResponse::from)
				.toList();
		
		return ResponseEntity.ok(payments);
		
	}
	
	@PutMapping("/{paymentId}")
	public ResponseEntity<PaymentResponse> updatePayment(
			@PathVariable UUID paymentId, 
			@RequestBody PaymentRequest request, 
			@AuthenticationPrincipal Jwt jwt) {
		
		UUID ownerId = extractOwnerId(jwt);
		
		Payment updated = paymentService.updatePayment(paymentId, ownerId, request);
		
		return ResponseEntity.ok(PaymentResponse.from(updated));
	}
	
	private UUID extractOwnerId(Jwt jwt) {
		return UUID.fromString(jwt.getSubject());
	}

}
