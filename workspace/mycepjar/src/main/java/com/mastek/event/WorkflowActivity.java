package com.mastek.event;

public class WorkflowActivity {
	String CustomerId;
	String Location;
	String Reference;
	String CaseNumber;
	String CaseDescription;
	String ActivityType;
	String Activity;
	String Action1;
	String Action2;
	String Action3;
	String Action1URL;
	String Action2URL;
	String Action3URL;

	
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public void setReference(String reference) {
		Reference = reference;
	}

	public void setCaseNumber(String caseNumber) {
		CaseNumber = caseNumber;
	}

	public void setCaseDescription(String caseDescription) {
		CaseDescription = caseDescription;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public String getLocation() {
		return Location;
	}

	public String getReference() {
		return Reference;
	}

	public String getCaseNumber() {
		return CaseNumber;
	}

	public String getCaseDescription() {
		return CaseDescription;
	}

	public String getActivityType() {
		return ActivityType;
	}

	public String getActivity() {
		return Activity;
	}

	public String getAction1() {
		return Action1;
	}

	public String getAction2() {
		return Action2;
	}

	public String getAction3() {
		return Action3;
	}

	public String getAction1URL() {
		return Action1URL;
	}

	public String getAction2URL() {
		return Action2URL;
	}

	public String getAction3URL() {
		return Action3URL;
	}

	public void setActivityType(String activityType) {
		ActivityType = activityType;
	}

	public void setActivity(String activity) {
		Activity = activity;
	}

	public void setAction1(String action1) {
		Action1 = action1;
	}

	public void setAction2(String action2) {
		Action2 = action2;
	}

	public void setAction3(String action3) {
		Action3 = action3;
	}

	public void setAction1URL(String action1url) {
		Action1URL = action1url;
	}

	public void setAction2URL(String action2url) {
		Action2URL = action2url;
	}

	public void setAction3URL(String action3url) {
		Action3URL = action3url;
	}


	public WorkflowActivity(String customerId, String location, String reference, String caseNumber,
			String caseDescription, String activityType, String activity, String action1, String action2,
			String action3, String action1URL, String action2URL, String action3URL

	) {
		super();
		CustomerId = customerId;
		Location = location;
		Reference = reference;
		CaseNumber = caseNumber;
		CaseDescription = caseDescription;
		ActivityType = activityType;
		Activity = activity;
		Action1 = action1;
		Action2 = action2;
		Action3 = action3;
		Action1URL = action1URL;
		Action2URL = action2URL;
		Action3URL = action3URL;
	}

	@Override
	public String toString() {
		return String.format(
				"WorkFlowActivity [CustomerId=%s, Location=%s, Reference=%s, CaseNumber=%s, CaseDescription=%s, ActivityType=%s, Activity=%s, Action1=%s, Action2 = %s, Action3 = %s,Action1URL = %s,Action3URL = %s,Action3URL = %s]",
				CustomerId, Location, Reference, CaseNumber, CaseDescription, ActivityType, Activity, Action1,Action2,Action3,Action1URL,Action2URL,Action3URL);
	}

}

