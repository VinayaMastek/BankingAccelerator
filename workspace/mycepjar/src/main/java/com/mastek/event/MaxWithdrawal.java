package com.mastek.event;

//create schema MaxWithdrawal as (customerId string,  transactionDt string,  totAmt double,  timesecs int);

public class MaxWithdrawal {
	String	CustomerId;
	double	TotAmt;
	String	TransactionDt;
	int Timesecs;
	
	public MaxWithdrawal() {
		super();
	}

	public MaxWithdrawal(String customerId, double totAmt, String transactionDt,int timesecs) {
		super();
		CustomerId = customerId;
		TotAmt = totAmt;
		TransactionDt = transactionDt;
		Timesecs = timesecs;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getTransactionDt() {
		return TransactionDt;
	}

	public void setTransactionDt(String transactionDt) {
		TransactionDt = transactionDt;
	}

	public double getTotAmt() {
		return TotAmt;
	}

	public void setTotAmt(double totAmt) {
		TotAmt = totAmt;
	}

	
	public int getTimesecs() {
		return Timesecs;
	}

	public void setTimesecs(int timesecs) {
		Timesecs = timesecs;
	}


	@Override
	public String toString() {
		return String
				.format("MaxWithdrawal [CustomerId=%s, TotAmt=%s, Timesecs = %s,TransactionDt=%s]",
						CustomerId, TotAmt, Timesecs, TransactionDt);
	}

	
}
