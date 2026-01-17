package com.javapractice.java8.cardpayment.util;

import java.time.LocalDate;

import com.javapractice.java8.cardpayment.pojo.CardNetwork;

/**
 * Network detection, masking, CVV/CID rules
 */
public final  class CardUtils {

	// Basic network detection (interview-grade):
	    // Visa: IIN starts with 4, length 13–19
	    // Amex: IIN starts with 34 or 37, length 15
        public static CardNetwork detectNetwork(String pan) {
        	if(pan == null)
        		return CardNetwork.UNKNOWN;
        	if(pan.startsWith("4") && pan.length()>= 13 && pan.length()<=19) 
        		return CardNetwork.VISA;
        	
        	if((pan.startsWith("34") || pan.startsWith("37")) && pan.length()>=15)
        		return CardNetwork.AMEX;
			return CardNetwork.UNKNOWN;
        }
        public static boolean isExpired(LocalDate expiry) {
        	LocalDate endOfMonth = expiry.withDayOfMonth(expiry.lengthOfMonth());
        	return LocalDate.now().isAfter(endOfMonth);
        }
        public static boolean cvvOrCidValid(CardNetwork network,String code) {
        	if(code == null || !code.matches("\\d+")) return false;
        	switch(network) {
        	case VISA: return code.length() == 3;
        	case AMEX : return code.length() == 4; // Amex CID is 4 digits
        	default: return false;
        	}
        }
        public static String maskPan(String pan) {
        	if(pan == null || pan.length() < 10 ) return "*******";
        	int keepStart = 6;
        	int keepEnd = 4;
        	String start = pan.substring(0,Math.min(0, Math.min(keepStart, pan.length())));
        	String end = pan.substring(pan.length() - Math.min(keepEnd, pan.length()));
        	String masked = new String(new char[Math.max(0,pan.length() - start.length()- end.length())]).replace("\0", "*");
        	return start+masked+end;
        }
}
