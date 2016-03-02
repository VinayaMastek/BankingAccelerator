package com.mastek.event;

public class AccountOpened {
	String CustomerId;
	String AccountNumber;
	String AccountType;
	String Branch;
	String OpeningDt;
	double Amount;
	int Period;
	float InterestRate;
	String InterestDeposited;
	String AccountHolder1Id;
	String AccountHolder2Id;
	String AccountHolder3Id;
	String AccountHolder4Id;
	double OverdraftLimit;
	String Location;
	
	public AccountOpened() {
		super();
	}
	
	public AccountOpened(String customerId, String accountNumber,
			String accountType, String branch, String openingDt, double amount,
			int period, float interestRate, String interestDeposited,
			String accountHolder1Id, String accountHolder2Id,
			String accountHolder3Id, String accountHolder4Id,double overdraftLimit, String location) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		AccountType = accountType;
		Branch = branch;
		OpeningDt = openingDt;
		Amount = amount;
		Period = period;
		InterestRate = interestRate;
		InterestDeposited = interestDeposited;
		AccountHolder1Id = accountHolder1Id;
		AccountHolder2Id = accountHolder2Id;
		AccountHolder3Id = accountHolder3Id;
		AccountHolder4Id = accountHolder4Id;
		OverdraftLimit = overdraftLimit;
		Location = location;
	}

	public double getOverdraftLimit() {
		return OverdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		OverdraftLimit = overdraftLimit;
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

	public int getPeriod() {
		return Period;
	}

	public void setPeriod(int period) {
		Period = period;
	}

	public float getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(float interestRate) {
		InterestRate = interestRate;
	}

	public String getInterestDeposited() {
		return InterestDeposited;
	}

	public void setInterestDeposited(String interestDeposited) {
		InterestDeposited = interestDeposited;
	}

	@Override
	public String toString() {
		return String
				.format("FDAccountOpened [CustomerId=%s, AccountNumber=%s, AccountType=%s, Branch=%s, OpeningDt=%s, Amount=%s, Period=%s, InterestRate=%s, InterestDeposited=%s, AccountHolder1Id=%s, AccountHolder2Id=%s, AccountHolder3Id=%s, AccountHolder4Id=%s, Location=%s]",
						CustomerId, AccountNumber, AccountType, Branch,
						OpeningDt, Amount, Period, InterestRate,
						InterestDeposited, AccountHolder1Id, AccountHolder2Id,
						AccountHolder3Id, AccountHolder4Id, Location);
	}
	

}
