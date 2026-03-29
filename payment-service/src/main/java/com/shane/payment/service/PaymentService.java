package com.shane.payment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shane.payment.dto.PaymentRequest;
import com.shane.payment.model.MatchStatus;
import com.shane.payment.model.Payment;
import com.shane.payment.repository.PaymentRepository;

@Service
public class PaymentService {
	
	private final PaymentRepository paymentRepository;
	
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public Payment createPayment(UUID ownerId, PaymentRequest request) {
		
		Payment payment;
		
		if (request.getInvoiceNumber() != null && !request.getInvoiceNumber().isEmpty()) {
			payment = new Payment(
					ownerId,
					request.getAccountNumber(),
					request.getRoutingNumber(),
					request.getRemitterName(),
					request.getPaymentAmount(),
					request.getCurrency(),
					request.getInvoiceNumber()
					);
		} else {
			payment = new Payment(
					ownerId,
					request.getAccountNumber(),
					request.getRoutingNumber(),
					request.getRemitterName(),
					request.getPaymentAmount(),
					request.getCurrency()
					);
		}
		
		return paymentRepository.save(payment);
		
	}
	
	public List<Payment> getPaymentsByOwnerId(UUID ownerId) {
		return paymentRepository.findByOwnerId(ownerId);
	}
	
	@Transactional
	public Payment updatePayment(UUID paymentId, UUID ownerId, PaymentRequest request) {
		
		Payment payment = paymentRepository.findByPaymentIdAndOwnerId(paymentId, ownerId)
				.orElseThrow(() -> new RuntimeException("Payment not found"));
		
		if (payment.getMatchStatus() != MatchStatus.UNMATCHED) {
			throw new IllegalStateException("Only UNMATCHED payments can be updated");
		}
		
		payment.update(
				request.getRemitterName(),
				request.getPaymentAmount(),
				request.getCurrency(),
				request.getInvoiceNumber()
			);
		
		return payment;
		
	}

}
