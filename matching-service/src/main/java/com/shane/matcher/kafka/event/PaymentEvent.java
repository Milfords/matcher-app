package com.shane.matcher.kafka.event;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentEvent {

    private String eventType;
    
    private UUID paymentId;
    private UUID ownerId;
    private String invoiceNumber;
    private BigDecimal paymentAmount;
    private String currency;

    private String matchStatus;

    public PaymentEvent() {}

    public PaymentEvent(String eventType, UUID paymentId, UUID ownerId, String invoiceNumber,
                        BigDecimal paymentAmount, String currency, String matchStatus) {
        this.eventType = eventType;
        this.paymentId = paymentId;
        this.ownerId = ownerId;
        this.invoiceNumber = invoiceNumber;
        this.paymentAmount = paymentAmount;
        this.currency = currency;
        this.matchStatus = matchStatus;
    }

    public String getEventType() { 
    	return eventType; 
    	}
    
    public void setEventType(String eventType) { 
    	this.eventType = eventType; 
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

    public String getInvoiceNumber() { 
    	return invoiceNumber; 
    	}
    
    public void setInvoiceNumber(String invoiceNumber) { 
    	this.invoiceNumber = invoiceNumber; 
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

    public String getMatchStatus() { 
    	return matchStatus; 
    	}
    
    public void setMatchStatus(String matchStatus) { 
    	this.matchStatus = matchStatus; 
    	}
    
}