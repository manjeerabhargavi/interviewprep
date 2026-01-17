package com.javapractice.java8.multithreadingandconcurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Token vault with ReadWrite Lock
 * Why ReadWriteLock  We expect far more reads (detokenize)than writes (tokenize)
 *ReadWrite Lock allows multiple concurrent reads while ensuring exclusive writes
 */
public class TokenVaultEx {
 static class TokenValult{
	 private final Map<String,String>panToToken = new HashMap<>();
	 private final Map<String,String>tokenToPan = new HashMap<>();
	 
	 private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	 //Tokenize PAN  -> returns token ; write lock protects mutations
	 String tokenize(String pan) {
		 lock.writeLock().lock();
		 try {
			return panToToken.computeIfAbsent(pan,p->{
				String token = "tok_"+UUID.randomUUID();
				tokenToPan.put(token, pan);
				return token;
				
			}) ;
		 }
		 finally {
			  lock.writeLock().unlock();
		 }
	 }
 }
}
