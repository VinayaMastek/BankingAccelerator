package com.mastek.event;

public class DematAccountOpened {
	String CustomerId;
	String AccountNumber;
	String AccountType; //DM
	String Branch;
	String OpeningDt;
	double Amount;
	String AccountHolder1Id;
	String AccountHolder2Id;
	String AccountHolder3Id;
	String AccountHolder4Id;
	String Location;
	
	public DematAccountOpened() {
		super();
	}
	
	public DematAccountOpened(String customerId, String accountNumber,
			String accountType, String branch,
			String openingDt, double amount, int period, double interestRate,
			String intRedeposited, String accountHolder1Id,
			String accountHolder2Id, String accountHolder3Id,
			String accountHolder4Id, String location) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		AccountType = accountType;
		Branch = branch;
		OpeningDt = openingDt;
		Amount = amount;
		AccountHolder1Id = accountHolder1Id;
		AccountHolder2Id = accountHolder2Id;
		AccountHolder3Id = accountHolder3Id;
		AccountHolder4Id = accountHolder4Id;
		Location = location;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public void setOpeningDt(String openingDt) {
		OpeningDt = openingDt;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public void setAccountHolder1Id(String accountHolder1Id) {
		AccountHolder1Id = accountHolder1Id;
	}
	public void setAccountHolder2Id(String accountHolder2Id) {
		AccountHolder2Id = accountHolder2Id;
	}
	public void setAccountHolder3Id(String accountHolder3Id) {
		AccountHolder3Id = accountHolder3Id;
	}
	public void setAccountHolder4Id(String accountHolder4Id) {
		AccountHolder4Id = accountHolder4Id;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public String getAccountType() {
		return AccountType;
	}
	public String getBranch() {
		return Branch;
	}
	public String getOpeningDt() {
		return OpeningDt;
	}
	public double getAmount() {
		return Amount;
	}
	public String getAccountHolder1Id() {
		return AccountHolder1Id;
	}
	public String getAccountHolder2Id() {
		return AccountHolder2Id;
	}
	public String getAccountHolder3Id() {
		return AccountHolder3Id;
	}
	public String getAccountHolder4Id() {
		return AccountHolder4Id;
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
				.format("AccountOpened [CustomerId=%s, AccountNumber=%s, AccountType=%s, Branch=%s, OpeningDt=%s, Amount=%s, AccountHolder1Id=%s, AccountHolder2Id=%s, AccountHolder3Id=%s, AccountHolder4Id=%s, Location = %s]",
						CustomerId, AccountNumber, AccountType, Branch,
						OpeningDt, Amount, AccountHolder1Id,
						AccountHolder2Id, AccountHolder3Id, AccountHolder4Id,
						Location);
	}
}
