package com.mastek.event;

public class TPBeneficiary {
	String	CustomerId;
	String 	AccountNumber;
	String	TPAccountNumber;
	String 	TPName;
	String 	TPType;
	String 	TransactionDt;
	public TPBeneficiary(String customerId, String accountNumber,
			String tPAccountNumber, String tPName, String tPType,
			String transactionDt) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		TPAccountNumber = tPAccountNumber;
		TPName = tPName;
		TPType = tPType;
		TransactionDt = transactionDt;
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
	public String getTPType() {
		return TPType;
	}
	public void setTPType(String tPType) {
		TPType = tPType;
	}
	public String getTransactionDt() {
		return TransactionDt;
	}
	public void setTransactionDt(String transactionDt) {
		TransactionDt = transactionDt;
	}
	@Override
	public String toString() {
		return String
				.format("TPBeneficiary [CustomerId=%s, AccountNumber=%s, TPAccountNumber=%s, TPName=%s, TPType=%s, TransactionDt=%s]",
						CustomerId, AccountNumber, TPAccountNumber, TPName,
						TPType, TransactionDt);
	}

	
}
