package com.shane.invoice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shane.invoice.dto.InvoiceRequest;
import com.shane.invoice.model.Invoice;
import com.shane.invoice.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	private final InvoiceRepository invoiceRepository;
	
	public InvoiceService(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}
	
	public Invoice createInvoice(UUID ownerId, InvoiceRequest request) {
		
		Invoice invoice = new Invoice(
				ownerId,
				request.getInvoiceNumber(),
				request.getCustomerName(),
				request.getInvoiceAmount(),
				request.getCurrency()
			);
			
			return invoiceRepository.save(invoice);
	}
	
	public List<Invoice> getInvoicesByOwnerId(UUID ownerId) {
		return invoiceRepository.findByOwnerId(ownerId);
	}
	
	@Transactional
	public Invoice updateInvoice(String invoiceNumber, UUID ownerId, InvoiceRequest request) {
		
		Invoice invoice = invoiceRepository.findByInvoiceNumberAndOwnerId(invoiceNumber, ownerId)
				.orElseThrow(() -> new RuntimeException("Invoice not found"));
		
		invoice.update(
				request.getCustomerName(),
				request.getInvoiceAmount(),
				request.getCurrency()
			);
		
		return invoice;
	}
	
	@Transactional
	public boolean deleteByInvoiceNumberAndOwnerId(String invoiceNumber, UUID ownerId) {
		
        if (invoiceRepository.existsByInvoiceNumberAndOwnerId(invoiceNumber, ownerId)) {
        	
            invoiceRepository.deleteByInvoiceNumberAndOwnerId(invoiceNumber, ownerId);
            return true;
        }
        return false;
    }

}
