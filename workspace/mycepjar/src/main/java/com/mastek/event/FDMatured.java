package com.mastek.event;

public class FDMatured {
	String CustomerId;
	String AccountNumber;
	String MaturityDt;
	double MaturityAmount;
	String Location;
	
	public FDMatured() {
		super();
	}
	
	public FDMatured(String customerId, String accountNumber,
			String maturityDt, double maturityAmount, String location) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		MaturityDt = maturityDt;
		MaturityAmount = maturityAmount;
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

	public String getMaturityDt() {
		return MaturityDt;
	}

	public void setMaturityDt(String maturityDt) {
		MaturityDt = maturityDt;
	}

	public double getMaturityAmount() {
		return MaturityAmount;
	}

	public void setMaturityAmount(double maturityAmount) {
		MaturityAmount = maturityAmount;
	}

	@Override
	public String toString() {
		return String
				.format("RDMatured [CustomerId=%s, AccountNumber=%s, MaturityDt=%s, MaturityAmount=%s, Location=%s]",
						CustomerId, AccountNumber, MaturityDt, MaturityAmount,
						Location);
	}

}
