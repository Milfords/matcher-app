package com.shane.payment.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shane.payment.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
	
	List<Payment> findByOwnerId(UUID ownerId);
	
	Optional<Payment> findByPaymentIdAndOwnerId(UUID paymentId, UUID ownerId);

}
