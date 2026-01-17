package com.javapractice.java8.cardpayment.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class TokenService {
	private static final SecureRandom secureRandom = new SecureRandom();

	private TokenService() {

	}
	//Simple Surrogate token (Not Production-grade)
	public static String tokenize(String pan) {
		byte[] salt = new byte[16];
		Random random = new Random();
		random.nextBytes(salt);
		return "tok_"+Base64.getUrlEncoder().withoutPadding().encodeToString((pan + ":" +bytesToHex(salt)).getBytes());
	}

	  public static String bytesToHex(byte[] bytes) {
	        StringBuilder sb = new StringBuilder(bytes.length * 2);
	        for (byte b : bytes) sb.append(String.format("%02x", b));
	        return sb.toString();
	    }

}
