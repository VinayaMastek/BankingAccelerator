package com.mastek.event;

public class RDBroken {
	String CustomerId;
	String AccountNumber;
	String BrokenDt;
	double Amount;
	String Location;
	
	public RDBroken() {
		super();
	}

	
	public RDBroken(String customerId, String accountNumber, String brokenDt,
			double amount, String location) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		BrokenDt = brokenDt;
		Amount = amount;
		Location = location;
	}


	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}


	public String getBrokenDt() {
		return BrokenDt;
	}


	public void setBrokenDt(String brokenDt) {
		BrokenDt = brokenDt;
	}


	public double getAmount() {
		return Amount;
	}


	public void setAmount(double amount) {
		Amount = amount;
	}


	@Override
	public String toString() {
		return String
				.format("RDBroken [CustomerId=%s, AccountNumber=%s, BrokenDt=%s, Amount=%s, Location=%s]",
						CustomerId, AccountNumber, BrokenDt, Amount, Location);
	}

}
