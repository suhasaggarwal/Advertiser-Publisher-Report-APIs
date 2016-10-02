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

import com.spring.model.Creative;
import com.spring.service.DisplayCreativeDAO;
import com.spring.util.EncryptionModule;

@RestController
public class DisplayCreativeIdController {


	@RequestMapping(value = "/getcreativeiddetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Creative> GetUserDetails(Creative creative, HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String emailId = null;
		 Creative creative1  = new Creative();
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
 	    creative1=DisplayCreativeDAO.DisplayCreativeIddetails(creative.getId().toString(), creative.getChannel(), emailId);
		
 	    if(creative != null)
		return new ResponseEntity<Creative>(creative1, HttpStatus.OK);   
		else
		return new ResponseEntity<Creative>(HttpStatus.NOT_FOUND);
}      








}
