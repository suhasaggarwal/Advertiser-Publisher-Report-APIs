package com.spring.model;

import java.util.List;

public class FormData {

private List<AudienceSegment> audienceSegmentData;
public List<AudienceSegment> getAudienceSegmentData() {
	return audienceSegmentData;
}
public void setAudienceSegmentData(List<AudienceSegment> audienceSegmentData) {
	this.audienceSegmentData = audienceSegmentData;
}
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
private List<OperatingSystem> osdata;
private List<Device> devicedata;
private List<Geography> geo;
private List<Gender> gender;
private List<Resolution> resolution;
private List<Objective> objective;

private List<Channel> channel;

private List<TrackerType> trackertype;
public List<TrackerType> getTrackertype() {
	return trackertype;
}
public void setTrackertype(List<TrackerType> trackertype) {
	this.trackertype = trackertype;
}
public List<CampaignType> getCampaigntype() {
	return campaigntype;
}
public void setCampaigntype(List<CampaignType> campaigntype) {
	this.campaigntype = campaigntype;
}
public List<Income> getInc() {
	return inc;
}
public void setInc(List<Income> inc) {
	this.inc = inc;
}
private List<CampaignType> campaigntype;
private List<Income> inc;

public List<Channel> getChannel() {
	return channel;
}
public void setChannel(List<Channel> channel) {
	this.channel = channel;
}
public List<Objective> getObjective() {
	return objective;
}
public void setObjective(List<Objective> objective) {
	this.objective = objective;
}
public List<Resolution> getResolution() {
	return resolution;
}
public void setResolution(List<Resolution> resolution) {
	this.resolution = resolution;
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
private List<AgeGroup> AgeGroup;

public List<Geography> getGeo() {
	return geo;
}
public void setGeo(List<Geography> geo) {
	this.geo = geo;
}

}
