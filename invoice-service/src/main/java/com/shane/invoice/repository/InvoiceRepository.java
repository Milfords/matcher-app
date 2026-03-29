package com.shane.invoice.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shane.invoice.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
	
	List<Invoice> findByOwnerId(UUID ownerId);
	
	Optional<Invoice> findByInvoiceNumberAndOwnerId(String invoiceNumber, UUID ownerId);
	
	void deleteByInvoiceNumberAndOwnerId(String invoiceNumber, UUID ownerId);
	
	boolean existsByInvoiceNumberAndOwnerId(String invoiceNumber, UUID ownerId);

}
