package com.spring.model;

public class Objective {


private String id;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getObjectiveName() {
	return objectiveName;
}

public void setObjectiveName(String objectiveName) {
	this.objectiveName = objectiveName;
}

private String objectiveName;

private String trackerType;

public String getTrackerType() {
	return trackerType;
}

public void setTrackerType(String trackerType) {
	this.trackerType = trackerType;
}

public String getCampaignType() {
	return campaignType;
}

public void setCampaignType(String campaignType) {
	this.campaignType = campaignType;
}

private String campaignType;


}
