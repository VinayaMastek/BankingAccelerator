package com.mastek.event;

public class BlackList {
	String	CustomerId;
	String	Location;
	long  Reference;
	String Reason;
	public BlackList( String customerId, String location,
			long  reference, String reason) {
		super();
		CustomerId = customerId;
		Location = location;
		Reference = reference;
		Reason = reason;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public long  getReference() {
		return Reference;
	}
	public void setReference(long  reference) {
		Reference = reference;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	@Override
	public String toString() {
		return String
				.format("LifeEventType [CustomerId=%s, Location=%s, Reference=%s,Reason=%s]",
	CustomerId, Location, Reference,Reason);
	}
	

}
