package com.shane.invoice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.shane.invoice.dto.InvoiceRequest;
import com.shane.invoice.dto.InvoiceResponse;
import com.shane.invoice.model.Invoice;
import com.shane.invoice.service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
	
	private final InvoiceService invoiceService;
	
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@PostMapping
	public ResponseEntity<InvoiceResponse> createInvoice(
			@RequestBody InvoiceRequest request, 
			@AuthenticationPrincipal Jwt jwt) {
		
		UUID ownerId = extractOwnerId(jwt);
		
		Invoice saved = invoiceService.createInvoice(ownerId, request);
		
		return ResponseEntity.ok(InvoiceResponse.from(saved));
	}
	
	@GetMapping
	public ResponseEntity<List<InvoiceResponse>> getAllInvoices(@AuthenticationPrincipal Jwt jwt) {
		
		UUID ownerId = extractOwnerId(jwt);
		
		List<InvoiceResponse> invoices = invoiceService.getInvoicesByOwnerId(ownerId)
				.stream()
				.map(InvoiceResponse::from)
				.toList();
		
		return ResponseEntity.ok(invoices);
	}
	
	@PutMapping("/{invoiceNumber}")
	public ResponseEntity<InvoiceResponse> updateInvoice(
			@PathVariable String invoiceNumber,
			@RequestBody InvoiceRequest request,
			@AuthenticationPrincipal Jwt jwt) {
		
		UUID ownerId = UUID.fromString(jwt.getSubject());
		
		Invoice updated = invoiceService.updateInvoice(invoiceNumber, ownerId, request);
		
		return ResponseEntity.ok(InvoiceResponse.from(updated));
	}
	
	@DeleteMapping("/{invoiceNumber}")
	public ResponseEntity<Void> deleteInvoiceByByInvoiceNumber(
			@PathVariable String invoiceNumber, 
			@AuthenticationPrincipal Jwt jwt) {
		
		UUID ownerId = extractOwnerId(jwt);
		
		boolean deleted = invoiceService.deleteByInvoiceNumberAndOwnerId(invoiceNumber, ownerId);
		
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
	
	//Helper method
	private UUID extractOwnerId(Jwt jwt) {
		return UUID.fromString(jwt.getSubject());
	}

}
