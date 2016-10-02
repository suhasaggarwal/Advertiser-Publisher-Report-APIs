package com.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Creative {

	
	@JsonProperty("title") 
	String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNewsFeedTitle() {
		return NewsFeedTitle;
	}

	public void setNewsFeedTitle(String newsFeedTitle) {
		NewsFeedTitle = newsFeedTitle;
	}

	public String getNewsFeedCreativeUrl() {
		return NewsFeedCreativeUrl;
	}

	public void setNewsFeedCreativeUrl(String newsFeedCreativeUrl) {
		NewsFeedCreativeUrl = newsFeedCreativeUrl;
	}

	public String getFbRHSTitle() {
		return fbRHSTitle;
	}

	public void setFbRHSTitle(String fbRHSTitle) {
		this.fbRHSTitle = fbRHSTitle;
	}

	public String getFbRHSMiniDescription() {
		return fbRHSMiniDescription;
	}

	public void setFbRHSMiniDescription(String fbRHSMiniDescription) {
		this.fbRHSMiniDescription = fbRHSMiniDescription;
	}

	public String getFbRHSDescription() {
		return fbRHSDescription;
	}

	public void setFbRHSDescription(String fbRHSDescription) {
		this.fbRHSDescription = fbRHSDescription;
	}

	public String getFbRHSCreativeUrl() {
		return fbRHSCreativeUrl;
	}

	public void setFbRHSCreativeUrl(String fbRHSCreativeUrl) {
		this.fbRHSCreativeUrl = fbRHSCreativeUrl;
	}

	public String getFbMobileAdTitle() {
		return fbMobileAdTitle;
	}

	public void setFbMobileAdTitle(String fbMobileAdTitle) {
		this.fbMobileAdTitle = fbMobileAdTitle;
	}

	public String getFbMobileAdCreativeUrl() {
		return fbMobileAdCreativeUrl;
	}

	public void setFbMobileAdCreativeUrl(String fbMobileAdCreativeUrl) {
		this.fbMobileAdCreativeUrl = fbMobileAdCreativeUrl;
	}

	public String getFbSlideShowUrls() {
		return fbSlideShowUrls;
	}

	public void setFbSlideShowUrls(String fbSlideShowUrls) {
		this.fbSlideShowUrls = fbSlideShowUrls;
	}

	public String getFbVideoUrl() {
		return fbVideoUrl;
	}

	public void setFbVideoUrl(String fbVideoUrl) {
		this.fbVideoUrl = fbVideoUrl;
	}

	public String getDispUploadCreativeUrl() {
		return DispUploadCreativeUrl;
	}

	public void setDispUploadCreativeUrl(String dispUploadCreativeUrl) {
		DispUploadCreativeUrl = dispUploadCreativeUrl;
	}

	public String getDispUploadCreativeVideoUrl() {
		return DispUploadCreativeVideoUrl;
	}

	public void setDispUploadCreativeVideoUrl(String dispUploadCreativeVideoUrl) {
		DispUploadCreativeVideoUrl = dispUploadCreativeVideoUrl;
	}

	public String getDispVastTagUrl() {
		return DispVastTagUrl;
	}

	public void setDispVastTagUrl(String dispVastTagUrl) {
		DispVastTagUrl = dispVastTagUrl;
	}

	public String getDispThirdPartyTagUrl() {
		return DispThirdPartyTagUrl;
	}

	public void setDispThirdPartyTagUrl(String dispThirdPartyTagUrl) {
		DispThirdPartyTagUrl = dispThirdPartyTagUrl;
	}

	public String getSmsText() {
		return smsText;
	}

	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}

	public String getEmailMrktImageUrl() {
		return EmailMrktImageUrl;
	}

	public void setEmailMrktImageUrl(String emailMrktImageUrl) {
		EmailMrktImageUrl = emailMrktImageUrl;
	}

	public String getEmailMrktTextHTML() {
		return EmailMrktTextHTML;
	}

	public void setEmailMrktTextHTML(String emailMrktTextHTML) {
		EmailMrktTextHTML = emailMrktTextHTML;
	}

	public String getContentMrktText() {
		return ContentMrktText;
	}

	public void setContentMrktText(String contentMrktText) {
		ContentMrktText = contentMrktText;
	}

	public String getContentMrktImageUrl() {
		return ContentMrktImageUrl;
	}

	public void setContentMrktImageUrl(String contentMrktImageUrl) {
		ContentMrktImageUrl = contentMrktImageUrl;
	}

	public String getWhatsAppAdText() {
		return WhatsAppAdText;
	}

	public void setWhatsAppAdText(String whatsAppAdText) {
		WhatsAppAdText = whatsAppAdText;
	}

	public String getWhatsAppAdImageUrl() {
		return WhatsAppAdImageUrl;
	}

	public void setWhatsAppAdImageUrl(String whatsAppAdImageUrl) {
		WhatsAppAdImageUrl = whatsAppAdImageUrl;
	}

	public String getWhatsAppAdVideoUrl() {
		return WhatsAppAdVideoUrl;
	}

	public void setWhatsAppAdVideoUrl(String whatsAppAdVideoUrl) {
		WhatsAppAdVideoUrl = whatsAppAdVideoUrl;
	}

	@JsonProperty("Description") 
	String Description;
    
	@JsonProperty("channel") 
	String channel;
     
	@JsonProperty("type") 
	String type;
    
     
    @JsonProperty("id")
	Integer id; 
	 
	
	 
	 @JsonProperty("size")
	 Integer size = 0;
     

     @JsonProperty("dateAdded")
	 String dateAdded;
     

     @JsonProperty("status")
     String status;
    
    
     @JsonProperty("facebookCreative")
     String facebookCreative;

    
     public String getFacebookCreative() {
		return facebookCreative;
	}

	public void setFacebookCreative(String facebookCreative) {
		this.facebookCreative = facebookCreative;
	}

	@JsonProperty("NewsFeedTitle")
     String NewsFeedTitle;
     

     @JsonProperty("NewsFeedCreativeUrl")
     String NewsFeedCreativeUrl;
     
     @JsonProperty("fbRHSTitle")
     String fbRHSTitle;
     
     @JsonProperty("fbRHSMiniDescription")
     String fbRHSMiniDescription;
    
     @JsonProperty("fbRHSDescription")
     String fbRHSDescription;
     
     
     @JsonProperty("fbRHSCreativeUrl")
     String fbRHSCreativeUrl;
     
     @JsonProperty("fbMobileAdTitle")
     String fbMobileAdTitle;
     
     
     @JsonProperty("fbMobileAdCreativeUrl")
     String fbMobileAdCreativeUrl;
     
     @JsonProperty("fbSlideShowUrls")
     String fbSlideShowUrls;
     
     @JsonProperty("fbVideoUrl")
     String fbVideoUrl;
     
     @JsonProperty("DispUploadCreativeUrl")
     String DispUploadCreativeUrl;
     
     @JsonProperty("DispUploadCreativeVideoUrl")
     String DispUploadCreativeVideoUrl;
     
     @JsonProperty("DispVastTagUrl")
     String DispVastTagUrl;
    
     @JsonProperty("DispThirdPartyTagUrl")
     String DispThirdPartyTagUrl;
     
     @JsonProperty("smsText")
     String smsText;
   
     @JsonProperty("EmailMrktImageUrl")
     String EmailMrktImageUrl;
    
     @JsonProperty("EmailMrktTextHTML")
     String EmailMrktTextHTML;
     
     @JsonProperty("ContentMrktText")
     String ContentMrktText;
     
     @JsonProperty("ContentMrktImageUrl")
     String ContentMrktImageUrl;
   
     @JsonProperty("WhatsAppAdText")
     String WhatsAppAdText;
     
     @JsonProperty("WhatsAppAdImageUrl")
     String WhatsAppAdImageUrl;
    
     @JsonProperty("WhatsAppAdVideoUrl")
     String WhatsAppAdVideoUrl;

     @JsonProperty("url")
     String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	} 
     
     
}
