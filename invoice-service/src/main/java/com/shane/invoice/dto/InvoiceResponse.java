package com.shane.invoice.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.shane.invoice.model.Invoice;
import com.shane.invoice.model.InvoiceStatus;
import com.shane.invoice.model.MatchStatus;

public class InvoiceResponse {
	
	private UUID id;
	private String invoiceNumber;
	private String customerName;
	private BigDecimal invoiceAmount;
	private String currency;
	private InvoiceStatus status;
	private MatchStatus matchStatus;
	
	public InvoiceResponse() {}
	
	public InvoiceResponse(UUID id, String invoiceNumber, String customerName, BigDecimal invoiceAmount, String currency, InvoiceStatus status, MatchStatus matchStatus) {
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.customerName = customerName;
		this.invoiceAmount = invoiceAmount;
		this.currency = currency;
		this.status = status;
		this.matchStatus = matchStatus;
	}
	
	// Getters and Setters
    public UUID getId() { 
    	return id; 
    }
    
    public void setId(UUID id) { 
    	this.id = id; 
    }
    
    public String getInvoiceNumber() {
    	return invoiceNumber;
    }
    
    public void setInvoiceNumber(String invoiceNumber) {
    	this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() { 
    	return customerName; 
    }
    
    public void setCustomerName(String customerName) { 
    	this.customerName = customerName; 
    }

    public BigDecimal getInvoiceAmount() { 
    	return invoiceAmount; 
    }
    
    public void setInvoiceAmount(BigDecimal invoiceAmount) { 
    	this.invoiceAmount = invoiceAmount; 
    }
    
    public String getCurrency() {
    	return currency;
    }
    
    public void setCurrency(String currency) {
    	this.currency = currency;
    }

    public InvoiceStatus getStatus() { 
    	return status; 
    }
    
    public void setStatus(InvoiceStatus status) { 
    	this.status = status; 
    }
    
    public MatchStatus getMatchStatus() {
    	return matchStatus;
    }
    
    public void setMatchStatus(MatchStatus matchStatus) {
    	this.matchStatus = matchStatus;
    }
    
    public static InvoiceResponse from(Invoice invoice) {
    	return new InvoiceResponse(
    			invoice.getId(),
    			invoice.getInvoiceNumber(),
    			invoice.getCustomerName(),
    			invoice.getInvoiceAmount(),
    			invoice.getCurrency(),
    			invoice.getStatus(),
    			invoice.getMatchStatus()
    		);
    }

}
