package com.javapractice.java8.cardpayment.util;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import com.javapractice.java8.cardpayment.pojo.CardInfo;
import com.javapractice.java8.cardpayment.pojo.CardNetwork;

public class Validators {
   private Validators() {}
   
   public static CompletableFuture<Void> luhn(CardInfo cardInfo){
	   return CompletableFuture.supplyAsync(()->Luhn.isValid(cardInfo.getPan()))
			                   .thenAccept(valid ->{
			                	   	if(!valid) {
			                	   		throw new IllegalArgumentException("Invalid PAN (Luhn)");
			                	   	}
			                   });
	   }
   public static CompletableFuture<Void> expiry(CardInfo card){
	   return CompletableFuture.supplyAsync(()->{
		   LocalDate endOfMonth = card.getExpiry().withDayOfMonth(card.getExpiry().lengthOfMonth());
		   return LocalDate.now().isBefore(endOfMonth)||LocalDate.now().isEqual(endOfMonth);
	   }).thenAccept(ok->{
		   if(!ok) throw new IllegalArgumentException("Card Expired");
	   });
   }
   public static CompletableFuture<Void> cvv(CardInfo card){
	   return CompletableFuture.supplyAsync(()->{
		 String cvv = card.getCvvOrCid();
		 if(cvv==null || !cvv.matches("\\d+")) return false;
		 if(card.getNetwork() == CardNetwork.VISA) return cvv.length()==3;
		 if(card.getNetwork() == CardNetwork.AMEX) return cvv.length()==4;
		 return false;
	   }).thenAccept(ok->{
		   throw new IllegalArgumentException("Invalid CVV/CID Length");
	   });
   }
}
