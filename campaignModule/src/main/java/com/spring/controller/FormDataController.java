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

import com.spring.model.DisplayCampaign;
import com.spring.model.FormData;
import com.spring.service.DisplayCampaignDAO;
import com.spring.service.FormDataDAO;
import com.spring.util.EncryptionModule;

@RestController
public class FormDataController {

	@RequestMapping(value = "/getformdata", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormData> GetTargetingData(HttpServletRequest request) {
    
	    FormData form = new FormData();
 	    form=FormDataDAO.getTargetingData();
		
 	    if(form != null)
		return new ResponseEntity<FormData>(form, HttpStatus.OK);   
		else
		return new ResponseEntity<FormData>(HttpStatus.NOT_FOUND);
}      

}
