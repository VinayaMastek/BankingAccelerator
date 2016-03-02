package com.mastek.event;

public class SavingAccountClosed {

	String	CustomerId;
	String	AccountNumber;
	String	ClosingDt;
	String	Reason;
	String 	Location;
	String AccountType;
		
	public SavingAccountClosed(String customerId, String accountNumber,
			String closingDt, String reason, String location, String accountType) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		ClosingDt = closingDt;
		Reason = reason;
		Location = location;
		AccountType = accountType;
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
	public String getClosingDt() {
		return ClosingDt;
	}
	public void setClosingDt(String closingDt) {
		ClosingDt = closingDt;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	@Override
	public String toString() {
		return String
				.format("SavingAccountClosed [CustomerId=%s, AccountNumber=%s, ClosingDt=%s, Reason=%s, Location=%s, AccountType=%s]",
						CustomerId, AccountNumber, ClosingDt, Reason, Location,
						AccountType);
	}

}
