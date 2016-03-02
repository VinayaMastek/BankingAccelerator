package com.mastek.event;

public class DirectDebitInstruction {
	String CustomerId;
	String 	AccountNumber;
	String	VendorName;
	String	RegistrationDt;
	String	VendorText;
	String Location;
	public DirectDebitInstruction(String customerId, String accountNumber,
			String vendorName, String registrationDt, String vendorText,
			String location) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
		VendorName = vendorName;
		RegistrationDt = registrationDt;
		VendorText = vendorText;
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
	public String getVendorText() {
		return VendorText;
	}
	public void setVendorText(String vendorText) {
		VendorText = vendorText;
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
				.format("DirectDebitInstruction [CustomerId=%s, AccountNumber=%s, VendorName=%s, RegistrationDt=%s, VendorText=%s, Location=%s]",
						CustomerId, AccountNumber, VendorName, RegistrationDt,
						VendorText, Location);
	}


	
}
