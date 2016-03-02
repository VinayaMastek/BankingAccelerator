package com.mastek.event;

public class LoanAccountClosed {
	String CustomerId;
	String AccountNumber;
	String ClosingDt;
	String Reason;
	String Location;
	String AccountType; //LN
	String Prepaid;
	
	public LoanAccountClosed() {
		super();
	}
	

	public LoanAccountClosed(String customerId, String accountNumber,
			String closingDt, String reason, String location, String prepaid) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		ClosingDt = closingDt;
		Reason = reason;
		Location = location;
		Prepaid = prepaid;
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

	public String getPrepaid() {
		return Prepaid;
	}

	public void setPrepaid(String prepaid) {
		Prepaid = prepaid;
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
				.format("LoanAccountClosed [CustomerId=%s, AccountNumber=%s, ClosingDt=%s, Reason=%s, Location=%s, AccountType=%s, Prepaid=%s]",
						CustomerId, AccountNumber, ClosingDt, Reason, Location,
						AccountType, Prepaid);
	}

}
