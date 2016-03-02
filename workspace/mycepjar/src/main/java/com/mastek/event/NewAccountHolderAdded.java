package com.mastek.event;

public class NewAccountHolderAdded {
	String CustomerId;
	String AccountNumber;
	String AccountType;
	String Branch;
	String JoiningDt;
	String IsMinor;
	String Location;
	String NewAccountHolderId;
	
	public NewAccountHolderAdded() {
		super();
	}
	
	public NewAccountHolderAdded(String customerId, String accountNumber,
			String accountType, String branch, String joiningDt,
			String isMinor, String location, String newAccountHolderId) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		AccountType = accountType;
		Branch = branch;
		JoiningDt = joiningDt;
		IsMinor = isMinor;
		Location = location;
		NewAccountHolderId = newAccountHolderId;
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
		JoiningDt = openingDt;
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
		return JoiningDt;
	}
	
	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getJoiningDt() {
		return JoiningDt;
	}

	public void setJoiningDt(String joiningDt) {
		JoiningDt = joiningDt;
	}

	public String getIsMinor() {
		return IsMinor;
	}

	public void setIsMinor(String isMinor) {
		IsMinor = isMinor;
	}

	public String getNewAccountHolderId() {
		return NewAccountHolderId;
	}

	public void setNewAccountHolderId(String newAccountHolderId) {
		NewAccountHolderId = newAccountHolderId;
	}

	@Override
	public String toString() {
		return String
				.format("NewAccountHolderAdded [CustomerId=%s, AccountNumber=%s, AccountType=%s, Branch=%s, JoiningDt=%s, IsMinor=%s, Location=%s, NewAccountHolderId=%s]",
						CustomerId, AccountNumber, AccountType, Branch,
						JoiningDt, IsMinor, Location, NewAccountHolderId);
	}
	
}
