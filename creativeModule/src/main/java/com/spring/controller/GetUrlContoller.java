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
import com.spring.model.Url;
import com.spring.service.DisplayCreativeDAO;
import com.spring.service.GetUrlDAO;
import com.spring.util.EncryptionModule;

@RestController
public class GetUrlContoller {

	@RequestMapping(value = "/geturldetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Url> GetUrlDetails(Creative creative1,HttpServletRequest request) {
    
	     String token;	
	     String userdetails;
	     String url = null;
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
 	    url=GetUrlDAO.GetUrlCreative(creative1.getId().toString(), creative1.getChannel());
 
 	    Url url1 = new Url();
 	    url1.setUrl(url);
 	    
 	    if(creative != null)
		return new ResponseEntity<Url>(url1, HttpStatus.OK);   
		else
		return new ResponseEntity<Url>(HttpStatus.NOT_FOUND);
}      

}
