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
import com.spring.model.ChannelCampaign;
import com.spring.model.DisplayCampaign;
import com.spring.model.SaveCampaignResponse;
import com.spring.model.UpdateCampaignResponse;
import com.spring.model.User;
import com.spring.service.AddCampaignDAO;
import com.spring.service.AddChannelCampaignDAO;
import com.spring.util.EncryptionModule;
import com.spring.util.GenerateToken;

@RestController
public class CampaignController {

	
//Depending on channel selected, creative is stored in table corresponding to channel - Facebook, Display, Rest respectively
//Facebook DisplayCampaign table has properties of Facebook Table, similarly for other channels	
	
	@RequestMapping(value = "/addcampaign", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  UpdateCampaignResponse submit(@RequestBody Campaign campaign,
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

        status = AddCampaignDAO.AddCampaignData(campaign,emailId);
         	
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
