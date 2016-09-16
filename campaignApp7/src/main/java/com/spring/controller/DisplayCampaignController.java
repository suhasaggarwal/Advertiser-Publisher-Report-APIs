package com.spring.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.DisplayCampaign;
import com.spring.model.User;
import com.spring.service.DisplayCampaignDAO;
import com.spring.util.EncryptionModule;

//Derives EmailId from cookie and fetches creatives corresponding to that Account, Query is union of respective channel creative tables i.e Facebook creative,Display DisplayCampaign,Rest creative 

@RestController
public class DisplayCampaignController {


	@RequestMapping(value = "/getcampaigndetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DisplayCampaign>> GetCampaignDetails(HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String emailId = null;
		 List<DisplayCampaign> campaign  = new ArrayList<DisplayCampaign>();
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
 	    campaign=DisplayCampaignDAO.DisplayCampaign(emailId);
		
 	    if(campaign != null)
		return new ResponseEntity<List<DisplayCampaign>>(campaign, HttpStatus.OK);   
		else
		return new ResponseEntity<List<DisplayCampaign>>(HttpStatus.NOT_FOUND);
}      




}
