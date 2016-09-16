package com.spring.controller;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.DisplayCampaign;
import com.spring.model.UpdateCampaignResponse;
import com.spring.service.EditCampaignDAO;
import com.spring.util.EncryptionModule;

//Api to update creative properties

@RestController
public class EditCampaignController {


	@RequestMapping(value = "/updatecampaignstatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UpdateCampaignResponse updateCampaignDetails(@RequestBody DisplayCampaign campaign,HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String status = null;
	     String emailId = null;
	     String id = null;
	     String title = null;
	     String description = null;
	     String channel = null;
	    
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
 	      }   
 	      
 	        status= EditCampaignDAO.updateCampaign(id, status, emailId);
		
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


/*	
	@RequestMapping(value = "/deletecreative", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UpdateCreativeResponse delete(@RequestBody DisplayCampaign creative,HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String status = null;
	     String emailId = null;
	     Integer id = null;
	     String title = null;
	     String description = null;
	     String channel = null;
	    
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
	        
 	       if(creative != null)
 	       {
 	       
	        
 	
 	 	    id = creative.getId();
 	 	    
 	 	    channel = creative.getChannel();
	       
 	       
 	       
 	       }   
 	      
 	        status= EditCampaignDAO.deleteCreative(id, channel, emailId);
		
 	       UpdateCreativeResponse response1 = new UpdateCreativeResponse();
 	        
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
*/	
	
	
	@RequestMapping(value = "/updatecampaignstatuschannel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UpdateCampaignResponse updateCampaignChannel(@RequestBody DisplayCampaign campaign,HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String status = null;
	     String emailId = null;
	     String id = null;
	     String title = null;
	     String description = null;
	     String channel = null;
	    
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
 	        channel = campaign.getChannel();
 	       }   
 	      
 	        status= EditCampaignDAO.updateCampaignChannel(id, channel, emailId, status);
		
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
