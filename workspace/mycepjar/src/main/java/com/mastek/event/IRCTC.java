

package com.mastek.event;

public class IRCTC {
	String EventType = "IRCTC";
	String EventCategory = "TRANSACTION";
	String customerId = "customerId";
	String smsType = "smsType";
	String pnr = "pnr";
	String ticketNo = "ticketNo";
	String bookingDetails = "bookingDetails";
	String ticketAmt = "ticketAmt";
	String source = "source";
	String destination = "destination";
	String journeyDt = "journeyDt";
	String depatureTime = "departureTime";
	public IRCTC() {
		super();
	}
	
	
	public IRCTC(String eventType, String eventCategory, String customerId,
			String smsType, String pnr, String ticketNo, String bookingDetails,
			String ticketAmt, String source, String destination,
			String journeyDt, String depatureTime) {
		super();
		EventType = eventType;
		EventCategory = eventCategory;
		this.customerId = customerId;
		this.smsType = smsType;
		this.pnr = pnr;
		this.ticketNo = ticketNo;
		this.bookingDetails = bookingDetails;
		this.ticketAmt = ticketAmt;
		this.source = source;
		this.destination = destination;
		this.journeyDt = journeyDt;
		this.depatureTime = depatureTime;
	}



	public String getEventType() {
		return EventType;
	}



	public void setEventType(String eventType) {
		EventType = eventType;
	}



	public String getEventCategory() {
		return EventCategory;
	}



	public void setEventCategory(String eventCategory) {
		EventCategory = eventCategory;
	}



	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getSmsType() {
		return smsType;
	}
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getBookingDetails() {
		return bookingDetails;
	}
	public void setBookingDetails(String bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	public String getTicketAmt() {
		return ticketAmt;
	}
	public void setTicketAmt(String ticketAmt) {
		this.ticketAmt = ticketAmt;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getJourneyDt() {
		return journeyDt;
	}
	public void setJourneyDt(String journeyDt) {
		this.journeyDt = journeyDt;
	}
	public String getDepatureTime() {
		return depatureTime;
	}
	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}
	@Override
	public String toString() {
		return String
				.format("IRCTC [customerId=%s, smsType=%s, pnr=%s, ticketNo=%s, bookingDetails=%s, ticketAmt=%s, source=%s, destination=%s, journeyDt=%s, depatureTime=%s]",
						customerId, smsType, pnr, ticketNo, bookingDetails,
						ticketAmt, source, destination, journeyDt, depatureTime);
	}
}

