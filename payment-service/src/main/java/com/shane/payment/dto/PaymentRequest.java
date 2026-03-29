package com.shane.payment.dto;

import java.math.BigDecimal;

public class PaymentRequest {
	
	private String accountNumber;
	private String routingNumber;
	private String remitterName;
	private BigDecimal paymentAmount;
	private String currency;
	private String invoiceNumber;
	
	public PaymentRequest() {};
	
	public PaymentRequest(String accountNumber, String routingNumber, String remitterName, BigDecimal paymentAmount, String currency, String invoiceNumber) {
		this.setAccountNumber(accountNumber);
		this.setRoutingNumber(routingNumber);
		this.setRemitterName(remitterName);
		this.setPaymentAmount(paymentAmount);
		this.setCurrency(currency);
		this.setInvoiceNumber(invoiceNumber);
	}
	
	public PaymentRequest(String accountNumber, String routingNumber, String remitterName, BigDecimal paymentAmount, String currency) {
		this.setAccountNumber(accountNumber);
		this.setRoutingNumber(routingNumber);
		this.setRemitterName(remitterName);
		this.setPaymentAmount(paymentAmount);
		this.setCurrency(currency);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getRemitterName() {
		return remitterName;
	}

	public void setRemitterName(String remitterName) {
		this.remitterName = remitterName;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

}
