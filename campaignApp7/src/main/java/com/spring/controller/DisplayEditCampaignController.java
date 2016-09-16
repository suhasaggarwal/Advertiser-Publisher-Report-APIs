package com.spring.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.ChannelCampaign;
import com.spring.model.DisplayCampaign;
import com.spring.model.DisplayEditCampaignChannelData;
import com.spring.service.DisplayCampaignDAO;
import com.spring.service.DisplayEditCampDAO;
import com.spring.util.EncryptionModule;

@RestController
public class DisplayEditCampaignController {




	@RequestMapping(value = "/getcampaignchanneldetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DisplayEditCampaignChannelData> GetCampaignDetailsChannel(ChannelCampaign campaign,HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String emailId = null;
	     DisplayEditCampaignChannelData campaign1  = new DisplayEditCampaignChannelData();
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
 	            
 	    if(emailId != null)
 	    campaign1=DisplayEditCampDAO.getCampaignChanneldata("1","2");
		
 	    if(campaign != null)
		return new ResponseEntity<DisplayEditCampaignChannelData>(campaign1, HttpStatus.OK);   
		else
		return new ResponseEntity<DisplayEditCampaignChannelData>(HttpStatus.NOT_FOUND);
}      















}
