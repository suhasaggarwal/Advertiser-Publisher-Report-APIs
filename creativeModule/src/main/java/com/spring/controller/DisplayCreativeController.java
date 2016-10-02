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

import com.spring.model.Creative;
import com.spring.model.User;
import com.spring.service.DisplayCreativeDAO;
import com.spring.util.EncryptionModule;

//Derives EmailId from cookie and fetches creatives corresponding to that Account, Query is union of respective channel creative tables i.e Facebook creative,Display Creative,Rest creative 

@RestController
public class DisplayCreativeController {


	@RequestMapping(value = "/getcreativedetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Creative>> GetUserDetails(HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String [] userinfo;
	     String emailId = null;
		 List<Creative> creative  = new ArrayList<Creative>();
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
 	    creative=DisplayCreativeDAO.DisplayCreative(emailId);
		
 	    if(creative != null)
		return new ResponseEntity<List<Creative>>(creative, HttpStatus.OK);   
		else
		return new ResponseEntity<List<Creative>>(HttpStatus.NOT_FOUND);
}      




}
