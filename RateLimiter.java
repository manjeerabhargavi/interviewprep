package com.javapractice.java8.cardpayment.core;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class RateLimiter {
 private final Semaphore permits;
 public RateLimiter(int tps) {
	 this.permits = new Semaphore(tps); //simplistic : tps per second window see scheduler below
 }
 public<T> T withPermit(long maxWaitMs, Supplier<T> supplier) {
	 boolean acquired = false;
	 try {
		 acquired = permits.tryAcquire(maxWaitMs,TimeUnit.MILLISECONDS);
		 if(!acquired) throw new RuntimeException("Rate limit exceed");
		 return supplier.get();
	 }
	 catch(InterruptedException e) {
		 
	 }
	return null;
 }
}
