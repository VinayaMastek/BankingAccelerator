package com.mastek.event;

public class DepositsMade {
	String	CustomerId;
	String	AccountNumber;
	double	Amount;
	double	BalAmount;
	String	TransactionDt;
	String	TransactionId;
	String	TransactionType;
	String Location;
	String	Reference;
	
	public DepositsMade() {
		super();
	}

	public DepositsMade(String customerId, String accountNumber, double amount,double balAmount,
			String transactionDt, String transactionId, String transactionType,String location,String reference) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		Amount = amount;
		BalAmount = balAmount;
		TransactionDt = transactionDt;
		TransactionId = transactionId;
		TransactionType = transactionType;
		Location = location;
		Reference = reference;
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

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public double getBalAmount() {
		return BalAmount;
	}

	public void setBalAmount(double balAmount) {
		BalAmount = balAmount;
	}

	public String getTransactionDt() {
		return TransactionDt;
	}

	public void setTransactionDt(String transactionDt) {
		TransactionDt = transactionDt;
	}

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
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

	@Override
	public String toString() {
		return String
				.format("DepositsMade [CustomerId=%s, AccountNumber=%s, Amount=%s, BalAmount = %s,TransactionDt=%s, TransactionID=%s, TransactionType=%s, Location=%s,Reference=%s]",
						CustomerId, AccountNumber, Amount, BalAmount, TransactionDt,
						TransactionId, TransactionType, Location,Reference);
	}

	
}
