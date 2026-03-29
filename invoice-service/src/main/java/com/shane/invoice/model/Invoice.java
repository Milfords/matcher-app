package com.shane.invoice.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "owner_id", nullable = false)
	private UUID ownerId;
	
	@Column(unique = true, nullable = false)
	private String invoiceNumber;
	
	private String customerName;
	private BigDecimal invoiceAmount;
	private String currency;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private InvoiceStatus status;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MatchStatus matchStatus;
	
	//Default constructor
	public Invoice() {}
	
	//Constructor for creating a new invoice with owner id
	public Invoice(UUID ownerId, String invoiceNumber, String customerName, BigDecimal invoiceAmount, String currency) {
		this.ownerId = ownerId;
		this.invoiceNumber = invoiceNumber;
		this.customerName = customerName;
		this.invoiceAmount = invoiceAmount;
		this.currency = currency;
		
		this.status = InvoiceStatus.OPEN;
		this.matchStatus = MatchStatus.UNMATCHED;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public UUID getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(UUID ownerId) {
		this.ownerId = ownerId;
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
	
	public void update(String customerName, BigDecimal invoiceAmount, String currency) {
		this.setCustomerName(customerName);
		this.setInvoiceAmount(invoiceAmount);
		this.setCurrency(currency);
	}
	
	public void updateInvoiceStatusToPartiallyPaid() {
		this.status = InvoiceStatus.PARTIALLY_PAID;
	}
	
	public void updateInvoiceStatusToPaid() {
		this.status = InvoiceStatus.PAID;
	}
	
	public void updateMatchStatus() {
		this.matchStatus = MatchStatus.MATCHED;
	}
	
}
