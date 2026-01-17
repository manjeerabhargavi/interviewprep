package com.javapractice.java8.cardpayment.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.javapractice.java8.cardpayment.pojo.PaymentProcessor;
import com.javapractice.java8.cardpayment.pojo.PaymentRequest;
import com.javapractice.java8.cardpayment.pojo.PaymentResponse;

public class VisaProcessor implements PaymentProcessor {
 private final Map<String,PaymentResponse>idempotency = new ConcurrentHashMap<>();

@Override
public PaymentResponse authorize(PaymentRequest req) {
	return idempotency.computeIfAbsent(null, null);
}

@Override
public PaymentResponse capture(String authorizationId, PaymentRequest req) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public PaymentResponse refund(String captureId, PaymentRequest req) {
	// TODO Auto-generated method stub
	return null;
}
}
