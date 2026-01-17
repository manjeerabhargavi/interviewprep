package com.javapractice.java8.cardpayment.pojo;

import java.time.LocalDateTime;
import java.util.Objects;

public final class PaymentResponse {

	 private final PaymentStatus status;
	    private final String authorizationId;
	    private final String captureId;
	    private final String networkReference;
	    private final String message;
	    private final LocalDateTime timestamp;

	    public PaymentResponse(PaymentStatus status, String authorizationId, String captureId,
	                           String networkReference, String message) {
	        this.status = Objects.requireNonNull(status);
	        this.authorizationId = authorizationId;
	        this.captureId = captureId;
	        this.networkReference = networkReference;
	        this.message = message;
	        this.timestamp = LocalDateTime.now();
	    }

		public PaymentStatus getStatus() { return status; }
	    public String getAuthorizationId() { return authorizationId; }
	    public String getCaptureId() { return captureId; }
	    public String getNetworkReference() { return networkReference; }
	    public String getMessage() { return message; }
	    public LocalDateTime getTimestamp() { return timestamp; }

	    @Override public String toString() {
	        return "PaymentResponse{" +
	                "status=" + status +
	                ", authId='" + authorizationId + '\'' +
	                ", captureId='" + captureId + '\'' +
	                ", netRef='" + networkReference + '\'' +
	                ", message='" + message + '\'' +
	                ", at=" + timestamp +
	                '}';
	    }

}
