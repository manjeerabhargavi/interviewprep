package com.javapractice.java8.cardpayment.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import com.javapractice.java8.cardpayment.pojo.PaymentResponse;

public class IdempotencyStore {
   private final Map<String,PaymentResponse>store = new ConcurrentHashMap<>();
   public PaymentResponse remember(String key,Supplier<PaymentResponse>supplier) {
	   return store.computeIfAbsent(key,k->supplier.get());
   }
}
