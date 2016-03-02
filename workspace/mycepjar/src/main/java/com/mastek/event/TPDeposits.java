package com.mastek.event;

public class TPDeposits {
	String	CustomerId;
	String 	AccountNumber;
	String	TPAccountNumber;
	String 	TPName;
	String	TransactionDt;
	double	Amount;
	String	TPType; //NEFT RTGS
	String Location;
	
	public TPDeposits(String customerId, String accountNumber,
			String tPAccountNumber, String tPName, String transactionDt,
			double amount, String tPType, String location) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		TPAccountNumber = tPAccountNumber;
		TPName = tPName;
		TransactionDt = transactionDt;
		Amount = amount;
		TPType = tPType;
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

	public String getTPAccountNumber() {
		return TPAccountNumber;
	}

	public void setTPAccountNumber(String tPAccountNumber) {
		TPAccountNumber = tPAccountNumber;
	}

	public String getTPName() {
		return TPName;
	}

	public void setTPName(String tPName) {
		TPName = tPName;
	}

	public String getTransactionDt() {
		return TransactionDt;
	}

	public void setTransactionDt(String transactionDt) {
		TransactionDt = transactionDt;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getTPType() {
		return TPType;
	}

	public void setTPType(String tPType) {
		TPType = tPType;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	@Override
	public String toString() {
		return String
				.format("TPDeposits [CustomerId=%s, AccountNumber=%s, TPAccountNumber=%s, TPName=%s, TransactionDt=%s, Amount=%s, TPType=%s, Location=%s]",
						CustomerId, AccountNumber, TPAccountNumber, TPName,
						TransactionDt, Amount, TPType, Location);
	}
	
}
