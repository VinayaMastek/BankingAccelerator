package com.mastek.event;

public class DividendDeposits {
	String	AccountNumber;
	String	Amount;
	String	TransactionDt;
	String	TransactionId;
	String	TransactionType; // DVD
	String	Reference;
	String	CustomerId;
	String	Location;
	
	public DividendDeposits(String accountNumber, String amount,
			String transactionDt, String transactionId, String transactionType,
			String reference, String customerId, String location) {
		super();
		AccountNumber = accountNumber;
		Amount = amount;
		TransactionDt = transactionDt;
		TransactionId = transactionId;
		TransactionType = transactionType;
		Reference = reference;
		CustomerId = customerId;
		Location = location;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
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

	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
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

	@Override
	public String toString() {
		return String
				.format("ChqDeposits [AccountNumber=%s, Amount=%s, TransactionDt=%s, TransactionId=%s, TransactionType=%s, Reference=%s, CustomerId=%s, Location=%s]",
						AccountNumber, Amount, TransactionDt, TransactionId,
						TransactionType, Reference, CustomerId, Location);
	}
	
}
