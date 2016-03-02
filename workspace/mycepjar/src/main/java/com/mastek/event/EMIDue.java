package com.mastek.event;

public class EMIDue {
	String	CustomerId;
	String	DueDt;
	double	Amt;
	String Location;
	public EMIDue(String customerId, String dueDt, double amt, String location) {
		super();
		CustomerId = customerId;
		DueDt = dueDt;
		Amt = amt;
		Location = location;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getDueDt() {
		return DueDt;
	}
	public void setDueDt(String dueDt) {
		DueDt = dueDt;
	}
	public double getAmt() {
		return Amt;
	}
	public void setAmt(double amt) {
		Amt = amt;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	@Override
	public String toString() {
		return String.format(
				"EMIDue [CustomerId=%s, DueDt=%s, Amt=%s, Location=%s]",
				CustomerId, DueDt, Amt, Location);
	}
	

}
