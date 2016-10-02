package com.spring.model;

import java.util.ArrayList;
import java.util.List;

public class DisplayCampaign {

	String Id;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	String campaignName;
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getImpression() {
		return Impression;
	}
	public void setImpression(String impression) {
		Impression = impression;
	}
	public String getClick() {
		return click;
	}
	public void setClick(String click) {
		this.click = click;
	}
	public Double getCtr() {
		return ctr;
	}
	public void setCtr(Double ctr) {
		this.ctr = ctr;
	}
	public String getConversion() {
		return conversion;
	}
	public void setConversion(String conversion) {
		this.conversion = conversion;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public List<DisplayCampaign> getChannelwiseData() {
		return channelwiseData;
	}
	public void setChannelwiseData(List<DisplayCampaign> channelwiseData) {
		this.channelwiseData = channelwiseData;
	}
	String startDate;
	String endDate;
    String Impression;
	String click;
	Double ctr;
	String conversion;
	String cost;
	String channel;
	String status;
	String channelId;
	
	
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	List<DisplayCampaign> channelwiseData = new ArrayList<DisplayCampaign>();
	
	 
	
}
