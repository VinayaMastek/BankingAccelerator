package com.mastek.event;

public class MutualFundInvstSetup {
	String	CustomerId;	
	String	AccountNumber;
	String	FundAmount;
	String	TransactionDt;
	String	ProductId;
	Integer	Period;
	String Location;
	
	public MutualFundInvstSetup(String customerId, String accountNumber,
			String fundAmount, String transactionDt, String productId,
			Integer period, String location) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		FundAmount = fundAmount;
		TransactionDt = transactionDt;
		ProductId = productId;
		Period = period;
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
	public String getFundAmount() {
		return FundAmount;
	}
	public void setFundAmount(String fundAmount) {
		FundAmount = fundAmount;
	}
	public String getTransactionDt() {
		return TransactionDt;
	}
	public void setTransactionDt(String transactionDt) {
		TransactionDt = transactionDt;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public Integer getPeriod() {
		return Period;
	}
	public void setPeriod(Integer period) {
		Period = period;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}

	
}
