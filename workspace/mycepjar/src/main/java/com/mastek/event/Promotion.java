
package com.mastek.event;

public class Promotion {
	String	CustomerId;
	String	Location;
	String Reference;
	String PromotionType;
	String PromotionActivity;
	String PromotionOutletType;
	String PromotionOutletName;
	String PromotionURL;
	String Vendor;
	
	String Percent;
	
	public Promotion( ){}
	public Promotion( String customerId, String location,
			String reference, String promotionType,
			String promotionActivity, String promotionOutletType,
			String promotionOutletName, String promotionURL
) {
		super();
		CustomerId = customerId;
		Location = location;
		Reference = reference;
		PromotionType = promotionType;
		PromotionActivity = promotionActivity;
		PromotionOutletType = promotionOutletType;
		PromotionOutletName =  promotionOutletName;
		PromotionURL =  promotionURL;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getReference() {
		return Reference;
	}
	public void setReference(String reference) {
		Reference = reference;
	}
	public String getPromotionType() {
		return PromotionType;
	}
	public void setPromotionType(String promotionType) {
		PromotionType = promotionType;
	}
	public String getPromotionActivity() {
		return PromotionActivity;
	}
	public void setPromotionActivity(String promotionActivity) {
		PromotionActivity = promotionActivity;
	}
	public String getPromotionOutletType() {
		return PromotionOutletType;
	}
	public void setPromotionOutletType(String promotionOutletType) {
		PromotionOutletType = promotionOutletType;
	}
	public String getPromotionOutletName() {
		return PromotionOutletName;
	}
	public void setPromotionOutletName(String promotionOutletName) {
		PromotionOutletName = promotionOutletName;
	}
	public String getPromotionURL() {
		return PromotionURL;
	}
	public void setPromotionURL(String promotionURL) {
		PromotionURL = promotionURL;
	}
	@Override
	public String toString() {
		return String.format("Promotion [CustomerId=%s, Location=%s, Reference=%s,PromotionType=%s,PromotionActivity=%s,PromotionOutletType=%s,PromotionOutletName=%s,PromotionURL=%s]", CustomerId, Location, Reference,PromotionType ,PromotionActivity ,PromotionOutletType ,PromotionOutletName ,PromotionURL);
	
	}
	public String getVendor() {
		return Vendor;
	}
	public void setVendor(String vendor) {
		Vendor = vendor;
	}
	public String getPercent() {
		return Percent;
	}
	public void setPercent(String i) {
		Percent = i;
	}
	

}
