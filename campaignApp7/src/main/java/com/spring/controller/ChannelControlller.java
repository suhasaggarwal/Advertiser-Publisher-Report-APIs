package com.spring.controller;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.ChannelCampaign;
import com.spring.model.User;
import com.spring.service.AddChannelCampaignDAO;
import com.spring.util.EncryptionModule;

@RestController
public class ChannelControlller {


	@RequestMapping(value = "/addcampaignchannel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ChannelCampaign  submit(@RequestBody ChannelCampaign campaign,
			HttpServletRequest request) {

		
		 String token;	
	     String userdetails;
	     String [] userinfo;
	     String emailId = null;
	     String status = null;
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

        status = AddChannelCampaignDAO.AddChannelCampaignData(campaign,emailId);
         	
	   return campaign;
	
	}
	
	
	
	
	
	



}
