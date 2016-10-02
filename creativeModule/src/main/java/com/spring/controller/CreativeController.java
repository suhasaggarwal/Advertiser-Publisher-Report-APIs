package com.spring.controller;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Creative;
import com.spring.model.SaveCreativeResponse;
import com.spring.model.User;
import com.spring.service.SaveCreativeDAO;
import com.spring.util.EncryptionModule;
import com.spring.util.GenerateToken;

@RestController
public class CreativeController {

	
//Depending on channel selected, creative is stored in table corresponding to channel - Facebook, Display, Rest respectively
//Facebook Creative table has properties of Facebook Table, similarly for other channels	
	
	@RequestMapping(value = "/addcreative", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SaveCreativeResponse submit(@RequestBody Creative creative,
			HttpServletRequest request) {

		
		 String token;	
	     String userdetails;
	     String [] userinfo;
	     String emailId = null;
		 User user = new User();
	     Cookie[] cookies = request.getCookies();
	            if(cookies != null){
	     for(int i = 0; i < cookies.length ; i++){
	            if(cookies[i].getName().equals("AUTHTOKEN")){
            //Fetch User details and return in json format
	              token = cookies[i].getValue();
	              userdetails=EncryptionModule.decrypt(null, null,URLDecoder.decode(token));
	              userinfo = userdetails.split(":");
                 emailId = userinfo[0];
	            }
	        }
	      }
	            
		
		
		
		String status = "false";

		if (creative.getChannel().equals("Facebook")) {

			status = SaveCreativeDAO.saveFacebookCreative(creative.getTitle(),
					creative.getDescription(), creative.getChannel(),emailId,
					creative.getType(), creative.getSize(),
					creative.getDateAdded(), creative.getStatus(),
					creative.getNewsFeedTitle(),
					creative.getNewsFeedCreativeUrl(), creative.getFbRHSTitle(),
					creative.getFbRHSMiniDescription(),
					creative.getFbRHSDescription(),
					creative.getFbRHSCreativeUrl(),
					creative.getFbMobileAdTitle(),
					creative.getFbMobileAdCreativeUrl(),
					creative.getFbSlideShowUrls(),
					creative.getFbVideoUrl(),creative.getFacebookCreative());
                 
			// Call Facebook Creative DAO
		}

		if (creative.getChannel().equals("DBM")) {

			status = SaveCreativeDAO.saveDisplayCreative(creative.getTitle(),
					creative.getDescription(), creative.getChannel(),emailId,
					creative.getType(), creative.getSize(),
					creative.getDateAdded(), creative.getStatus(),
					creative.getDispUploadCreativeUrl(),
					creative.getDispUploadCreativeVideoUrl(),
					creative.getDispVastTagUrl());

			// Call DBM Creative DAO
		}

		if (creative.getChannel().equals("Adwords")) {

			status = SaveCreativeDAO.saveDisplayCreative(creative.getTitle(),
					creative.getDescription(), creative.getChannel(),emailId,
					creative.getType(), creative.getSize(),
					creative.getDateAdded(), creative.getStatus(),
					creative.getDispUploadCreativeUrl(),
					creative.getDispUploadCreativeVideoUrl(),
					creative.getDispVastTagUrl());

			// Call Adwords creative DAO
		}

		if (creative.getChannel().equals("WhatsApp"))

		{

			status = SaveCreativeDAO.saveWhatsappCreative(creative.getTitle(),
					creative.getDescription(), creative.getChannel(),emailId,
					creative.getType(), creative.getSize(),
					creative.getDateAdded(), creative.getStatus(),
					creative.getWhatsAppAdText(),
					creative.getWhatsAppAdImageUrl(),
					creative.getWhatsAppAdVideoUrl());

		}

		if (creative.getChannel().equals("Email"))

		{

			status = SaveCreativeDAO.saveEmailCreative(creative.getTitle(),
					creative.getDescription(), creative.getChannel(),emailId,
					creative.getType(), creative.getSize(),
					creative.getDateAdded(), creative.getStatus(),
					creative.getEmailMrktTextHTML(),
					creative.getEmailMrktImageUrl());

		}

		if (creative.getChannel().equals("Content"))

		{

			status = SaveCreativeDAO.saveContentCreative(creative.getTitle(),
					creative.getDescription(), creative.getChannel(),emailId,
					creative.getType(), creative.getSize(),
					creative.getDateAdded(), creative.getStatus(),
					creative.getContentMrktText(),
					creative.getContentMrktImageUrl());

		}
		
		
		if (creative.getChannel().equals("SMS"))

		{

			status = SaveCreativeDAO.saveSMSCreative(creative.getTitle(),
					creative.getDescription(), creative.getChannel(),emailId,
					creative.getType(), creative.getSize(),
					creative.getDateAdded(), creative.getStatus(),
					creative.getSmsText());

		}
		
		

		SaveCreativeResponse response = new SaveCreativeResponse();

		if (status.equals("true")) {

			response.setType("success");
			response.setDescription("Creative ");

		}

		else {

			response.setType("error");
			response.setDescription("Error in saving User Data");

		}

		return response;

	}



	










}
