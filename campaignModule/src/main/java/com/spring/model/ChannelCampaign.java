package com.spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChannelCampaign {




public List<Device> getDeviceid() {
	return deviceid;
}


public void setDeviceid(List<Device> deviceid) {
	this.deviceid = deviceid;
}


public List<OperatingSystem> getOperatingsystemid() {
	return operatingsystemid;
}


public void setOperatingsystemid(List<OperatingSystem> operatingsystemid) {
	this.operatingsystemid = operatingsystemid;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getComments() {
	return comments;
}


public void setComments(String comments) {
	this.comments = comments;
}


public String getBudgetpercentage() {
	return budgetpercentage;
}


public void setBudgetpercentage(String budgetpercentage) {
	this.budgetpercentage = budgetpercentage;
}





public String getMonthlycap() {
	return monthlycap;
}


public void setMonthlycap(String monthlycap) {
	this.monthlycap = monthlycap;
}


public String getDailycap() {
	return dailycap;
}


public void setDailycap(String dailycap) {
	this.dailycap = dailycap;
}


public String getCampaigntype() {
	return campaigntype;
}


public void setCampaigntype(String campaigntype) {
	this.campaigntype = campaigntype;
}


public String getTrackertype() {
	return trackertype;
}


public void setTrackertype(String trackertype) {
	this.trackertype = trackertype;
}


public String getMaxbid() {
	return maxbid;
}


public void setMaxbid(String maxbid) {
	this.maxbid = maxbid;
}


public String getExpectedbid() {
	return expectedbid;
}


public void setExpectedbid(String expectedbid) {
	this.expectedbid = expectedbid;
}


public String getClicktracker() {
	return clicktracker;
}


public void setClicktracker(String clicktracker) {
	this.clicktracker = clicktracker;
}


public List<Resolution> getResolutionid() {
	return resolutionid;
}


public void setResolutionid(List<Resolution> resolutionid) {
	this.resolutionid = resolutionid;
}


public String getTargettype() {
	return targettype;
}


public void setTargettype(String targettype) {
	this.targettype = targettype;
}


public String getLookalike() {
	return lookalike;
}


public void setLookalike(String lookalike) {
	this.lookalike = lookalike;
}


public List<AudienceSegment> getInterestsegmentid() {
	return interestsegmentid;
}


public void setInterestsegmentid(List<AudienceSegment> interestsegmentid) {
	this.interestsegmentid = interestsegmentid;
}


public List<Geography> getGeographyid() {
	return geographyid;
}


public void setGeographyid(List<Geography> geographyid) {
	this.geographyid = geographyid;
}


public List<AgeGroup> getAgerange() {
	return agerange;
}


public void setAgerange(List<AgeGroup> agerange) {
	this.agerange = agerange;
}


public List<Gender> getGender() {
	return gender;
}


public void setGender(List<Gender> gender) {
	this.gender = gender;
}


public List<Income> getIncomelevel() {
	return incomelevel;
}


public void setIncomelevel(List<Income> incomelevel) {
	this.incomelevel = incomelevel;
}


public String getStartdate() {
	return startdate;
}


public void setStartdate(String startdate) {
	this.startdate = startdate;
}


public String getEnddate() {
	return enddate;
}


public void setEnddate(String enddate) {
	this.enddate = enddate;
}


public String getApproval() {
	return approval;
}


public void setApproval(String approval) {
	this.approval = approval;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getChannelid() {
	return channelid;
}


public void setChannelid(String channelid) {
	this.channelid = channelid;
}


public List<Campaign> getCampaign() {
	return campaign;
}


public void setCampaign(List<Campaign> campaign) {
	this.campaign = campaign;
}


@JsonProperty("deviceid")
List<Device> deviceid;

@JsonProperty("operatingsystemid")
List<OperatingSystem> operatingsystemid;

@JsonProperty("id")
String	id;

@JsonProperty("comments")
String	comments;

@JsonProperty("budgetpercentage")
String	budgetpercentage;

@JsonProperty("channelbudget")
String channelbudget;

public String getChannelbudget() {
	return channelbudget;
}


public void setChannelbudget(String channelbudget) {
	this.channelbudget = channelbudget;
}








@JsonProperty("monthlycap")
String	monthlycap; 

@JsonProperty("dailycap")
String	dailycap;

@JsonProperty("campaigntype")
String	campaigntype; 

@JsonProperty("trackertype")
String  trackertype;

@JsonProperty("maxbid")
String  maxbid; 

@JsonProperty("expectedbid")
String	expectedbid; 

@JsonProperty("clicktracker")
String	clicktracker;

@JsonProperty("resolutionid")
List<Resolution> resolutionid;

@JsonProperty("targettype")
String	targettype;

@JsonProperty("lookalike")
String	lookalike;

@JsonProperty("interestsegmentid")
List<AudienceSegment> interestsegmentid;

@JsonProperty("geographyid")
List<Geography>  geographyid;


@JsonProperty("agerange")
List<AgeGroup> agerange;

@JsonProperty("gender")
List<Gender> gender;

@JsonProperty("incomelevel")
List<Income> incomelevel;

@JsonProperty("startdate")
String startdate;


@JsonProperty("enddate")
String enddate;

@JsonProperty("approval")
String approval;

@JsonProperty("status")
String status;

@JsonProperty("email")
String email;


@JsonProperty("channelid")
String channelid;


@JsonProperty("campaign")
List<Campaign> campaign;

@JsonProperty("creativeid")
List<Creative> creative;

public List<Creative> getCreative() {
	return creative;
}


public void setCreative(List<Creative> creative) {
	this.creative = creative;
}

@JsonProperty("idealTargeting")
String idealTargeting;

public String getIdealTargeting() {
	return idealTargeting;
}


public void setIdealTargeting(String idealTargeting) {
	this.idealTargeting = idealTargeting;
}

@JsonProperty("campId")
String campId;

public String getCampId() {
	return campId;
}


public void setCampId(String campId) {
	this.campId = campId;
}


public String getOptimumParameter() {
	return optimumParameter;
}


public void setOptimumParameter(String optimumParameter) {
	this.optimumParameter = optimumParameter;
}


@JsonProperty("optimumParameter")
String optimumParameter;


}









