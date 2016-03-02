package com.mastek.event;

public class DebitCardIssued {

	String	AccountNumber;
	String	CardNumber;
	String	CardAccount;
	String	IssueDt;
	String	CardType;
	String	ProductId;
	double	CardLimit;
	String	CardHolderId;
	String	ExpiryDt;
	
	public DebitCardIssued(String accountNumber, String cardNumber,
			String cardAccount, String issueDt, String cardType,
			String productId, double cardLimit, String cardHolderId,
			String expiryDt) {
		super();
		AccountNumber = accountNumber;
		CardNumber = cardNumber;
		CardAccount = cardAccount;
		IssueDt = issueDt;
		CardType = cardType;
		ProductId = productId;
		CardLimit = cardLimit;
		CardHolderId = cardHolderId;
		ExpiryDt = expiryDt;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public String getCardAccount() {
		return CardAccount;
	}

	public void setCardAccount(String cardAccount) {
		CardAccount = cardAccount;
	}

	public String getIssueDt() {
		return IssueDt;
	}

	public void setIssueDt(String issueDt) {
		IssueDt = issueDt;
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		ProductId = productId;
	}

	public double getCardLimit() {
		return CardLimit;
	}

	public void setCardLimit(double cardLimit) {
		CardLimit = cardLimit;
	}

	public String getCardHolderId() {
		return CardHolderId;
	}

	public void setCardHolderId(String cardHolderId) {
		CardHolderId = cardHolderId;
	}

	public String getExpiryDt() {
		return ExpiryDt;
	}

	public void setExpiryDt(String expiryDt) {
		ExpiryDt = expiryDt;
	}

	@Override
	public String toString() {
		return String
				.format("CardIssued [AccountNumber=%s, CardNumber=%s, CardAccount=%s, IssueDt=%s, CardType=%s, ProductId=%s, CardLimit=%s, CardHolderId=%s, ExpiryDt=%s]",
						AccountNumber, CardNumber, CardAccount, IssueDt,
						CardType, ProductId, CardLimit, CardHolderId, ExpiryDt);
	}

	
}
