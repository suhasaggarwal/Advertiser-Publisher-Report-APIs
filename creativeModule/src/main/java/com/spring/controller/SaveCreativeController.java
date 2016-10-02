package com.spring.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Creative;
import com.spring.model.User;


public class SaveCreativeController {

	 @RequestMapping(value = "/addcreative", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	    
	 public void submit(@RequestBody Creative creative, HttpServletRequest request) {
	      
         String title;
         String Description;
         String channel;
         String type;
	     String size;
	     String dateAdded;
	     String status;
	     String NewsFeedTitle;
	     String NewsFeedCreativeUrl;
	     String RHSTitle;
	     String RHSMiniDescription;
	     String RHSDescription;
	     String RHSUploadCreativeUrl;
	     String MobileSizeUploadTitle;
	     String MobileSizeUploadCreativeUrl;
	     String UploadVideoSlideShowUrl;
	     String UploadVideoUrl;
	     String DispUploadCreativeUrl;
	     String DispUploadCreativeVideoUrl;
	     String DispVastTagUrl;
	     String DispThirdPartyTagUrl;
	     String smsText;
	     String EmailMrktUploadUrl;
	     String EmailMrktTextHTML;
	     String ContentMrktText;
	     String ContentMrktImageUrl;
	     String WhatsAppAdText;
	     String WhatsAppAdImageUrl;
	     String WhatsAppAdVideoUrl;
	     
	/*     
		 List<String> requestParameterNames = Collections.list((Enumeration<String>) request.getParameterNames());

		 for (String parameterName : requestParameterNames) {
		     String attributeName = parameterName;
		     String attributeValue = request.getParameter(parameterName);

		    if(attributeValue.equals("Facebook"))
		    {
		     
		    	for (String parameterName : requestParameterNames) {
				     String attributeName = parameterName;
				     
				     if(parameterName.equals("Title"))
				    	 
				    
				     if(parameterName.equals("Description"))	
				    	 
				   
				     if(parameterName.equals("Channel"))		 
				    	 
				    	 
				     if(parameterName.equals("Type"))	 	 
				    
				    	 
                     if(parameterName.equals("Size")))		 
					    	 
					    	 
					 if(parameterName.equals("DateAdded"))		 
				    	 
				    	
					 if(parameterName.equals("Status"))		 
						 
						 
						 
					     if(parameterName.equals("Title"))
					    	 
					    
					     if(parameterName.equals("Description"))	
					    	 
					   
					     if(parameterName.equals("Channel"))		 
					    	 
					    	 
					     if(parameterName.equals("Type"))	 	 
					    
					    	 
	                     if(parameterName.equals("Size")))		 
						    	 
						    	 
						 if(parameterName.equals("DateAdded"))		 
					    	 
					    	
						 if(parameterName.equals("Status"))		
						 
						 
						 
						 
						 
				     String attributeValue = request.getParameter(parameterName);
		     
		   }
	        
		    if(attributeValue.equals("Display"))
		    {
		    	for (String parameterName : requestParameterNames) {
				     String attributeName = parameterName;
				     String attributeValue = request.getParameter(parameterName);
		     
		   }
		    
		    if(attributeValue.equals("Content"))
		    {
		     
		    	for (String parameterName : requestParameterNames) {
				     String attributeName = parameterName;
				     String attributeValue = request.getParameter(parameterName);
		     
		   }
		    
		    if(attributeValue.equals("Email"))
		    {
		     
		    	for (String parameterName : requestParameterNames) {
				     String attributeName = parameterName;
				     String attributeValue = request.getParameter(parameterName);
		     
		   }
		    
		    if(attributeValue.equals("Whatsapp"))
		    {
		     
		    	for (String parameterName : requestParameterNames) {
				     String attributeName = parameterName;
				     String attributeValue = request.getParameter(parameterName);
		     
		   }
		    
		    
		    
		    
	        /*
	        model.addAttribute("fullname", user.getFullName());
	        model.addAttribute("emailname", user.getEmailName());
	        model.addAttribute("username", user.getUsername());
	        model.addAttribute("password", user.getPassword());
	        model.addAttribute("advertiser", user.getAdvertiser());
	        model.addAttribute("publisher", user.getPublisher());
	        model.addAttribute("companyname", user.getCompanyName());
	        model.addAttribute("website_url", user.getWebsiteUrl());
	        model.addAttribute("address", user.getAddress());
	        model.addAttribute("state", user.getState());
	        model.addAttribute("city", user.getCity());
	        model.addAttribute("phone", user.getPhone());
	        model.addAttribute("zipcode", user.getZipcode());
	        */
	/*        
	        String website_url = value8;
	        String address = value9;
	        String state = value10;
	        String city = value11;
	        String phone = value12;
	        String zipcode = value13;
	        
	      
	        String status;
			status=SaveCreativeDAO.saveUser(fullname,username,emailname,password,advertiser,publisher,companyname,website_url,address,state,city,phone,zipcode);
	        
	        
	        return status; */
	    }
	
	







}
