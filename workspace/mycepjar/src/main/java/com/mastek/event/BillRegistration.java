package com.mastek.event;

public class BillRegistration {
	String	CustomerId;
	String 	AccountNumber;
	String	VendorName;
	String	RegistrationDt;
	String	MonthlyDueDt;
	String Location;
	public BillRegistration(String customerId, String accountNumber,
			String vendorName, String registrationDt, String monthlyDueDt,
			String location) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		VendorName = vendorName;
		RegistrationDt = registrationDt;
		MonthlyDueDt = monthlyDueDt;
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
	public String getVendorName() {
		return VendorName;
	}
	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}
	public String getRegistrationDt() {
		return RegistrationDt;
	}
	public void setRegistrationDt(String registrationDt) {
		RegistrationDt = registrationDt;
	}
	public String getMonthlyDueDt() {
		return MonthlyDueDt;
	}
	public void setMonthlyDueDt(String monthlyDueDt) {
		MonthlyDueDt = monthlyDueDt;
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
				.format("BillRegistration [CustomerId=%s, AccountNumber=%s, VendorName=%s, RegistrationDt=%s, MonthlyDueDt=%s, Location=%s]",
						CustomerId, AccountNumber, VendorName, RegistrationDt,
						MonthlyDueDt, Location);
	}
	
}
