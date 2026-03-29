package com.shane.matcher.kafka.event;

import java.math.BigDecimal;
import java.util.UUID;

public class InvoiceEvent {
	
	private String eventType;
	private UUID id;
	private UUID ownerId;
	private String invoiceNumber;
	private BigDecimal invoiceAmount;
	private String currency;
	
	private String status;
	private String matchStatus;
	
	public InvoiceEvent() {}
	
	public InvoiceEvent(String eventType, UUID id, UUID ownerId, String invoiceNumber, 
						BigDecimal invoiceAmount, String currency, String status, String matchStatus) {
		this.eventType = eventType;
        this.id = id;
        this.ownerId = ownerId;
        this.invoiceNumber = invoiceNumber;
        this.invoiceAmount = invoiceAmount;
        this.currency = currency;
        this.status = status;
        this.matchStatus = matchStatus;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}

}
