package com.mastek.event;

public class DebitCardStatusChange {

	String	CustomerId;
	String	CardNumber;
	String	ChangeDt;
	String	Reason;
	String	CardType; //DB
	String	CardHolderId;
	String	CardStatus;
	String Location;
	
	
	public DebitCardStatusChange() {
		super();
	}


	public DebitCardStatusChange(String customerId, String cardNumber,
			String changeDt, String reason, String cardType,
			String cardHolderId, String cardStatus,String location) {
		super();
		CustomerId = customerId;
		CardNumber = cardNumber;
		ChangeDt = changeDt;
		Reason = reason;
		CardType = cardType;
		CardHolderId = cardHolderId;
		CardStatus = cardStatus;
		Location = location;
	}


	public String getCustomerId() {
		return CustomerId;
	}


	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}


	public String getCardNumber() {
		return CardNumber;
	}


	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}


	public String getChangeDt() {
		return ChangeDt;
	}


	public void setChangeDt(String changeDt) {
		ChangeDt = changeDt;
	}


	public String getReason() {
		return Reason;
	}


	public void setReason(String reason) {
		Reason = reason;
	}


	public String getCardType() {
		return CardType;
	}


	public void setCardType(String cardType) {
		CardType = cardType;
	}


	public String getCardHolderId() {
		return CardHolderId;
	}


	public void setCardHolderId(String cardHolderId) {
		CardHolderId = cardHolderId;
	}


	public String getCardStatus() {
		return CardStatus;
	}


	public void setCardStatus(String cardStatus) {
		CardStatus = cardStatus;
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
				.format("DebitCardStatusChange [CustomerId=%s, CardNumber=%s, ChangeDt=%s, Reason=%s, CardType=%s, CardHolderId=%s, CardStatus=%s,Location = %s]",
						CustomerId, CardNumber, ChangeDt, Reason, CardType,
						CardHolderId, CardStatus,Location);
	}
	
}
