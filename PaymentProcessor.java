package com.javapractice.java8.cardpayment.pojo;

public interface PaymentProcessor {
 PaymentResponse authorize(PaymentRequest req);
 PaymentResponse capture(String authorizationId,PaymentRequest req);
 PaymentResponse refund(String captureId,PaymentRequest req);
}
