package com.shane.invoice.dto;

import java.math.BigDecimal;

public class InvoiceRequest {
	
	private String invoiceNumber;
	private String customerName;
	private BigDecimal invoiceAmount;
	private String currency;
	
	public InvoiceRequest() {}
	
	public InvoiceRequest(String invoiceNumber, String customerName, BigDecimal invoiceAmount, String currency) {
		this.invoiceNumber = invoiceNumber;
		this.customerName = customerName;
		this.invoiceAmount = invoiceAmount;
		this.currency = currency;
	}
	
	public InvoiceRequest(String customerName, BigDecimal invoiceAmount, String currency) {
		this.customerName = customerName;
		this.invoiceAmount = invoiceAmount;
		this.currency = currency;
	}
	
	//Getters and setters
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

}
