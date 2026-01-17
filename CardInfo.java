package com.javapractice.java8.cardpayment.pojo;

import java.time.LocalDate;
import java.util.Objects;

public class CardInfo {

private final String pan;          // Primary Account Number (PAN)
    private final String nameOnCard;
    private final LocalDate expiry;    // YYYY-MM
    private final String cvvOrCid;     // CVV (Visa) or CID (Amex)
    private final CardNetwork network;
    
    public CardInfo(String pan, String nameOnCard, LocalDate expiry, String cvvOrCid, CardNetwork network) {
    	this.pan = Objects.requireNonNull(pan,"pan");
    	this.nameOnCard = Objects.requireNonNull(nameOnCard,"nameOnCard");
    	this.expiry = Objects.requireNonNull(expiry,"expiry");
    	this.cvvOrCid = Objects.requireNonNull(cvvOrCid, "cvvOrCid");
    	this.network = Objects.requireNonNull(network, "network");
    }

    public String getPan() { return pan; }
       public String getNameOnCard() { return nameOnCard; }
       public LocalDate getExpiry() { return expiry; }
       public String getCvvOrCid() { return cvvOrCid; }
       public CardNetwork getNetwork() { return network; }


   
}
