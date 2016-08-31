package com.websystique.springmvc.model;



public class Reports {

	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCampaign_id() {
		return campaign_id;
	}

	public void setCampaign_id(String campaign_id) {
		this.campaign_id = campaign_id;
	}

	
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAudience_segment() {
		return audience_segment;
	}

	public void setAudience_segment(String audience_segment) {
		this.audience_segment = audience_segment;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	
	private String campaign_id;
	
	private String channel;
	
	private String audience_segment;
	
	private String city;
	
	private String os;
	
	private String age;
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	private String gender;
	
	private String cpc;
	
	public String getCpc() {
		return cpc;
	}

	public void setCpc(String cpc) {
		this.cpc = cpc;
	}

	public String getCtr() {
		return ctr;
	}

	public void setCtr(String ctr) {
		this.ctr = ctr;
	}

	public String getConvrate() {
		return convrate;
	}

	public void setConvrate(String convrate) {
		this.convrate = convrate;
	}


	private String ctr;
	
	private String convrate;
	

    }
