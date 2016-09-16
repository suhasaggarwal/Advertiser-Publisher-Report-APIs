package com.spring.model;

import java.util.List;


public class DisplayEditCampaignChannelData {

	private List<OperatingSystem> osdata;
	public List<OperatingSystem> getOsdata() {
		return osdata;
	}
	public void setOsdata(List<OperatingSystem> osdata) {
		this.osdata = osdata;
	}
	public List<Device> getDevicedata() {
		return devicedata;
	}
	public void setDevicedata(List<Device> devicedata) {
		this.devicedata = devicedata;
	}
	public List<Geography> getGeo() {
		return geo;
	}
	public void setGeo(List<Geography> geo) {
		this.geo = geo;
	}
	public List<Gender> getGender() {
		return gender;
	}
	public void setGender(List<Gender> gender) {
		this.gender = gender;
	}
	public List<AgeGroup> getAgeGroup() {
		return AgeGroup;
	}
	public void setAgeGroup(List<AgeGroup> ageGroup) {
		AgeGroup = ageGroup;
	}
	public List<AudienceSegment> getAudienceSegmentData() {
		return audienceSegmentData;
	}
	public void setAudienceSegmentData(List<AudienceSegment> audienceSegmentData) {
		this.audienceSegmentData = audienceSegmentData;
	}
	private List<Device> devicedata;
	private List<Geography> geo;
	private List<Gender> gender;
	private List<AgeGroup> AgeGroup;
	private List<AudienceSegment> audienceSegmentData;
    private List<Resolution> res;

	public List<Resolution> getRes() {
		return res;
	}
	public void setRes(List<Resolution> res) {
		this.res = res;
	}
	String	budgetpercentage;

	public String getBudgetpercentage() {
		return budgetpercentage;
	}
	public void setBudgetpercentage(String budgetpercentage) {
		this.budgetpercentage = budgetpercentage;
	}
	public String getChannelbudget() {
		return channelbudget;
	}
	public void setChannelbudget(String channelbudget) {
		this.channelbudget = channelbudget;
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
	String	channelbudget;

	
	String	monthlycap; 

	
	String	dailycap;

	
	String	campaigntype; 

	
	String  trackertype;

	
	String  maxbid; 

	
	String	expectedbid; 

	
	String	clicktracker;









}
