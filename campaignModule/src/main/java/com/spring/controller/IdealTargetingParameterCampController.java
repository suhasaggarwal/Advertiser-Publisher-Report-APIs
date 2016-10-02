package com.spring.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.ChannelCampaign;
import com.spring.util.EncryptionModule;
import com.spring.util.HttpUtil;


@RestController
public class IdealTargetingParameterCampController {

		@RequestMapping(value = "/getidealparamcampdetails/{campId}/{campType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> GetCampaignDetailsChannel(@PathVariable("campId") String campId, @PathVariable("campType") String campType,HttpServletRequest request) {
	    
		     String token;	
		     String userdetails;
		     String [] userinfo;
		     String emailId = null;
		     ChannelCampaign campaign1  = new ChannelCampaign();
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
	 	    
	 	            
	 	    String campaigndetails = null;        
	 	    String url = null;       
	 	    String content = null;
	 	    
	 	    
	 	    if(emailId != null){
	 	    
	 	    	        if(campType.equals("ctr"))
	 	    			url = "http://54.84.60.73:8080/b5/report/14/"+campId;
	 	    				
	 	    		    if(campType.equals("cpc"))
	 	    			url = "http://54.84.60.73:8080/b5/report/15/"+campId;
	 	    					
	 	    		    if(campType.equals("conversionRate"))
	 	    			url = "http://54.84.60.73:8080/b5/report/14/"+campId;
	 	    					
	 	    		 	  
	 	    			try {
	 	    				content = HttpUtil.executeRequest(url);
	 	    			} catch (IOException e) {
	 	    				// TODO Auto-generated catch block
	 	    				e.printStackTrace();
	 	    			}
	 	    		 	
	 	    }
	 	      
	 	      
	 	    if(content != null)
			return new ResponseEntity<String>(content, HttpStatus.OK);   
			else
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}      



		






}
