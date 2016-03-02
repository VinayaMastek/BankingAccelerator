package com.mastek.event;

public class LifeEvent {
	String	CustomerId;
	String	Location;
	String Reference;
	String LifeEventType;
	public LifeEvent( String customerId, String location,
			String reference, String lifeEventType) {
		super();
		CustomerId = customerId;
		Location = location;
		Reference = reference;
		LifeEventType = lifeEventType;
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
	public String getReference() {
		return Reference;
	}
	public void setReference(String reference) {
		Reference = reference;
	}
	public String getLifeEventType() {
		return LifeEventType;
	}
	public void setLifeEventType(String lifeEventType) {
		LifeEventType = lifeEventType;
	}
	@Override
	public String toString() {
		return String
				.format("LifeEventType [CustomerId=%s, Location=%s, Reference=%s,LifeEventType=%s]",
	CustomerId, Location, Reference,LifeEventType);
	}
	

}
