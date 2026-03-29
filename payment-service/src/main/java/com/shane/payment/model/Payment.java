package com.shane.payment.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue
	@Column(name = "paymentId", unique = true, updatable = false, nullable = false)
	private UUID paymentId;
	
	@Column(name = "owner_id", nullable = false)
	private UUID ownerId;
	
	private String accountNumber;
	private String routingNumber;
	private String remitterName;
	private BigDecimal paymentAmount;
	private String currency;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "match_status")
	private MatchStatus matchStatus;
	
	//Default constructor
	public Payment() {};
	
	//Constructor to create a payment with the owner id
	public Payment(UUID ownerId, String accountNumber, String routingNumber, String remitterName, BigDecimal paymentAmount, 
				   String currency) {
		this.ownerId = ownerId;
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.remitterName = remitterName;
		this.paymentAmount = paymentAmount;
		this.currency = currency;
		
		this.matchStatus = MatchStatus.UNMATCHED;
	}
	
	public UUID getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(UUID paymentId) {
		this.paymentId = paymentId;
	}
	
	public UUID getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(UUID ownerId) {
		this.ownerId = ownerId;
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
	
	public MatchStatus getMatchStatus() {
		return matchStatus;
	}
	
	public void setMatchStatus(MatchStatus matchStatus) {
		this.matchStatus = matchStatus;
	}
	
	public void update(String remitterName, BigDecimal paymentAmount, String currency) {
		this.remitterName = remitterName;
		this.paymentAmount = paymentAmount;
		this.currency = currency;
	}
	
	public void updateStatus() {
		this.matchStatus = MatchStatus.MATCHED;
	}

}
