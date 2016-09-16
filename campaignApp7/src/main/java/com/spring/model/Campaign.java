package com.spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Campaign {

@JsonProperty("name")	
String name;


@JsonProperty("objective")
String objective;

@JsonProperty("id")
String	id;

@JsonProperty("totalbudget")
String	totalbudget;


public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getObjective() {
	return objective;
}



public void setObjective(String objective) {
	this.objective = objective;
}



public String getId() {
	return id;
}



public void setId(String id) {
	this.id = id;
}



public String getTotalbudget() {
	return totalbudget;
}



public void setTotalbudget(String totalbudget) {
	this.totalbudget = totalbudget;
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



public String getStatus() {
	return status;
}



public void setStatus(String status) {
	this.status = status;
}



public String getCampaigntype() {
	return campaigntype;
}



public void setCampaigntype(String campaigntype) {
	this.campaigntype = campaigntype;
}



public String getApproval() {
	return approval;
}



public void setApproval(String approval) {
	this.approval = approval;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getTargetType() {
	return TargetType;
}



public void setTargetType(String targetType) {
	TargetType = targetType;
}



public String getTrackertype() {
	return trackertype;
}



public void setTrackertype(String trackertype) {
	this.trackertype = trackertype;
}



@JsonProperty("monthlycap")
String	monthlycap; 

@JsonProperty("dailycap")
String	dailycap;


@JsonProperty("maxbid")
String  maxbid;  

@JsonProperty("expectedbid")
String	expectedbid; 

@JsonProperty("clicktracker")
String	clicktracker;

@JsonProperty("startdate")
String startdate;

@JsonProperty("enddate")
String enddate;

@JsonProperty("status")
String status;

@JsonProperty("campaigntype")
String	campaigntype; 




@JsonProperty("approval")
String approval;

@JsonProperty("email")
String email;

@JsonProperty("TargetType")
String TargetType;



@JsonProperty("trackertype")
String trackertype;







}









