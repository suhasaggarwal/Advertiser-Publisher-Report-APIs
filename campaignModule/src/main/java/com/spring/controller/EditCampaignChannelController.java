package com.spring.controller;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Campaign;
import com.spring.model.UpdateCampaignResponse;
import com.spring.service.UpdateCampaignStatusDAO;
import com.spring.util.EncryptionModule;


@RestController
public class EditCampaignChannelController {

	@RequestMapping(value = "/updatecampaignstatuschannel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UpdateCampaignResponse updateCampaignChannel(@RequestBody Campaign campaign,HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String status = null;
	     String emailId = null;
	     String id = null;
	     String title = null;
	     String description = null;
	     String channelid = null;
	    
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
	        
 	       if(campaign != null)
 	       {
 	        status = campaign.getStatus();
	        id = campaign.getId();
 	        channelid = campaign.getChannelid();
 	       }   
 	      
 	        status= UpdateCampaignStatusDAO.UpdateCampaignChannelStatus(status,id, channelid);
		
 	       UpdateCampaignResponse response1 = new UpdateCampaignResponse();
 	        
 	        if(status.equals("true")){
 	        	response1.setType("success");
 	            response1.setDescription("Details Updated");
 	  			return response1;
 	  		
 	        }
 	        else{
 	        	
 	        	response1.setType("error");
 	        	response1.setDescription("Error Saving Details");
 	            return response1;
 	        }
 	        	
 	        


	}






}
