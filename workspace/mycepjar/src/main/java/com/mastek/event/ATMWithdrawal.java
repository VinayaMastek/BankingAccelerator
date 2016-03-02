package com.mastek.event;

public class ATMWithdrawal {
	String	AccountNumber;
	double	Amount;
	String	TransactionDt;
	String	TransactionId;
	String	TransactionType; // ATM
	double	BalAmount;
	String	CustomerId;
	String	Location;
	String Reference;
	public ATMWithdrawal(String accountNumber, double amount,
			String transactionDt, String transactionId, String transactionType,
			double balAmount, String customerId, String location,
			String reference) {
		super();
		AccountNumber = accountNumber;
		Amount = amount;
		TransactionDt = transactionDt;
		TransactionId = transactionId;
		TransactionType = transactionType;
		BalAmount = balAmount;
		CustomerId = customerId;
		Location = location;
		Reference = reference;
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
	public double getBalAmount() {
		return BalAmount;
	}
	public void setBalAmount(double balAmount) {
		BalAmount = balAmount;
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
	@Override
	public String toString() {
		return String
				.format("ATMWithdrawal [AccountNumber=%s, Amount=%s, TransactionDt=%s, TransactionId=%s, TransactionType=%s, BalAmount=%s, CustomerId=%s, Location=%s, Reference=%s]",
						AccountNumber, Amount, TransactionDt, TransactionId,
						TransactionType, BalAmount, CustomerId, Location,
						Reference);
	}
	
}
