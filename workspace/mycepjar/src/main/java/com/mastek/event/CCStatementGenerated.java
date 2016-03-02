package com.mastek.event;

public class CCStatementGenerated {
	String	CustomerId;
	String	CreditCardNumber;
	String	StatmentDt;
	String	DueDt;
	double	MinAmtDue;
	double	Amt;
	public CCStatementGenerated(String customerId, String creditCardNumber,
			String statmentDt, String dueDt, double minAmtDue, double amt) {
		super();
		CustomerId = customerId;
		CreditCardNumber = creditCardNumber;
		StatmentDt = statmentDt;
		DueDt = dueDt;
		MinAmtDue = minAmtDue;
		Amt = amt;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getCreditCardNumber() {
		return CreditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	public String getStatmentDt() {
		return StatmentDt;
	}
	public void setStatmentDt(String statmentDt) {
		StatmentDt = statmentDt;
	}
	public String getDueDt() {
		return DueDt;
	}
	public void setDueDt(String dueDt) {
		DueDt = dueDt;
	}
	public double getMinAmtDue() {
		return MinAmtDue;
	}
	public void setMinAmtDue(double minAmtDue) {
		MinAmtDue = minAmtDue;
	}
	public double getAmt() {
		return Amt;
	}
	public void setAmt(double amt) {
		Amt = amt;
	}
	@Override
	public String toString() {
		return String
				.format("CCStatementGenerated [CustomerId=%s, CreditCardNumber=%s, StatmentDt=%s, DueDt=%s, MinAmtDue=%s, Amt=%s]",
						CustomerId, CreditCardNumber, StatmentDt, DueDt,
						MinAmtDue, Amt);
	}

}
