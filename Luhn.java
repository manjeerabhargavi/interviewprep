package com.javapractice.java8.cardpayment.util;

public final class Luhn {
   public static boolean isValid(String pan) {
	   if(pan == null || !pan.matches("\\d{13,19}"))
		   return false;
	   int sum = 0;
	   boolean alt = false;
	   for (int i=pan.length()-1;i>=0;i--) {
		    int n = pan.charAt(i)- '0';
		    if(alt) {
		    	n = n*2;
		    	if(n>9) n = n-9;
		    }
		    sum = sum + n;
		    alt = !alt;
	   }
	  return sum % 10 == 0;
   }
}
