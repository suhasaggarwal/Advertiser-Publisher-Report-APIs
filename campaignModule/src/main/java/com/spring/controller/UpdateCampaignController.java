package com.spring.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Campaign;
import com.spring.model.DisplayCampaign;
import com.spring.model.UpdateCampaignResponse;
import com.spring.service.DisplayCampaignDAO;
import com.spring.service.UpdateCampDAO;
import com.spring.util.EncryptionModule;


@RestController
public class UpdateCampaignController {

	@RequestMapping(value = "/updatecampaigndetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UpdateCampaignResponse updateCampaignDetails(@RequestBody Campaign campaign,HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String emailId = null;
	     String status = null;
//		 List<DisplayCampaign> campaign  = new ArrayList<DisplayCampaign>();
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
 	    status=UpdateCampDAO.updateCampaign(campaign);
		
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
