package com.javapractice.java8.cardpayment.pojo;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public final class PaymentRequest {

private final String merchantId;
    private final String idempotencyKey;
    private final Money amount;
    private final CardInfo card;
    private final LocalDateTime createdAt;
    private final String description;
  
    public PaymentRequest(String merchantId, String idempotencyKey, Money amount, CardInfo card, String description) {
    	this.merchantId = Objects.requireNonNull(merchantId, "merchantId");
    	this.idempotencyKey = idempotencyKey!=null ?idempotencyKey : UUID.randomUUID().toString();
    	this.amount = Objects.requireNonNull(amount, "amount");
        this.card = Objects.requireNonNull(card, "card");
        this.createdAt = LocalDateTime.now();
        this.description = description;
    }

public String getMerchantId() { return merchantId; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public Money getAmount() { return amount; }
    public CardInfo getCard() { return card; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getDescription() { return description; }

}
