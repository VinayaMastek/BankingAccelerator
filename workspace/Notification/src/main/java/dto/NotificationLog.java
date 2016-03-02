package dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="log")
public class NotificationLog {

	@Id
	private String id;
	//private String accountNumber;
	private String customerId;
	private Preference pref;
	private String notification;
	private String communicationId;
	private String date;
	
/*	
 	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
*/
 	public String getCustomerId() {
		return customerId;
	}
 	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public Preference getPref() {
		return pref;
	}
	public void setPref(Preference pref) {
		this.pref = pref;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getCommunicationId() {
		return communicationId;
	}
	public void setCommunicationId(String communicationId) {
		this.communicationId = communicationId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String
				.format("NotificationLog [id=%s, customerId=%s, pref=%s, notification=%s, communicationId=%s, date=%s]",
						id, customerId, pref, notification, communicationId,date);
	}
	
	
}
