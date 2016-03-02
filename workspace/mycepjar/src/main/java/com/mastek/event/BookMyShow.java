package com.mastek.event;

public class BookMyShow {
	String EventType = "BookMyShow";
	String EventCategory = "TRANSACTION";
	String customerId = "customerId";
	String smsType="BOOKMYSHOW";
	String url ="url";
	String bookingId = "bookingId";
	String movieName = "movieName";
	String movieType = "movieType"; 
	String movieDt ="movieDt"; 
	String movieTime = "movieTime";
	String theater = "theater"; 
	String location = "location";
	public BookMyShow() {
		super();
	}
	public BookMyShow(String customerId, String smsType, String url,
			String bookingId, String movieName, String movieType,
			String movieDt, String movieTime, String theater, String location) {
		super();
		this.customerId = customerId;
		this.smsType = smsType;
		this.url = url;
		this.bookingId = bookingId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieDt = movieDt;
		this.movieTime = movieTime;
		this.theater = theater;
		this.location = location;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getMovieDt() {
		return movieDt;
	}
	public void setMovieDt(String movieDt) {
		this.movieDt = movieDt;
	}
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return String
				.format("BookMyShow [customerId:%s, smsType:%s, url:%s, bookingId:%s, movieName:%s, movieType=%s, movieDt:%s, movieTime:%s, theater:%s, location:%s]",
						customerId, smsType, url, bookingId, movieName,
						movieType, movieDt, movieTime, theater, location);
	}
	

}

