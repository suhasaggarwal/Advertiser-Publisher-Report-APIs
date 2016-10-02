package com.spring.controller;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Campaign;
import com.spring.model.ChannelCampaign;
import com.spring.service.DisplayEditCampDAO;
import com.spring.service.DisplayEditCampaignIdDAO;
import com.spring.util.EncryptionModule;



@RestController
public class DisplayEditCampaignIdController {



	@RequestMapping(value = "/getcampaignIddetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Campaign> GetCampaignDetailsChannel(Campaign campaign,HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String emailId = null;
	     Campaign campaign1  = new Campaign();
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
 	      campaign1=DisplayEditCampaignIdDAO.getCampaignIddata(campaign.getId());
 	    //  campaign1=DisplayEditCampDAO.getCampaignChanneldata("1","2");	
		
 	    if(campaign != null)
		return new ResponseEntity<Campaign>(campaign1, HttpStatus.OK);   
		else
		return new ResponseEntity<Campaign>(HttpStatus.NOT_FOUND);
}      











}
