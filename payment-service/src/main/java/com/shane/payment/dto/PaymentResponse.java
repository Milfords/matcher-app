package com.shane.payment.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.shane.payment.model.MatchStatus;
import com.shane.payment.model.Payment;

public class PaymentResponse {
	
	private UUID paymentId;
	private String accountNumber;
	private String routingNumber;
	private String remitterName;
	private BigDecimal paymentAmount;
	private String currency;
	private String invoiceNumber;
	private MatchStatus matchStatus;
	
	public PaymentResponse() {}
	
	public PaymentResponse(UUID paymentId, String accountNumber, String routingNumber, String remitterName, 
						   BigDecimal paymentAmount, String currency, String invoiceNumber, MatchStatus matchStatus) {
		this.setPaymentId(paymentId);
		this.setAccountNumber(accountNumber);
		this.setRoutingNumber(routingNumber);
		this.setRemitterName(remitterName);
		this.setPaymentAmount(paymentAmount);
		this.setCurrency(currency);
		this.setInvoiceNumber(invoiceNumber);
		this.setMatchStatus(matchStatus);
	}

	public UUID getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(UUID paymentId) {
		this.paymentId = paymentId;
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

	public MatchStatus getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(MatchStatus matchStatus) {
		this.matchStatus = matchStatus;
	}
	
	public static PaymentResponse from(Payment payment) {
        return new PaymentResponse(
                payment.getPaymentId(),
                payment.getAccountNumber(),
                payment.getRoutingNumber(),
                payment.getRemitterName(),
                payment.getPaymentAmount(),
                payment.getCurrency(),
                payment.getInvoiceNumber(),
                payment.getMatchStatus()
        	);
    }

}
