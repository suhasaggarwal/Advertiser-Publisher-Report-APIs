package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.AmazonSTSResponse;
import com.spring.model.UserIdentification;
import com.spring.service.AmazonSTSService;
import com.spring.util.EncryptionModule;

//Implementation of Amazon Security Token Service, which provide temporary credentials corresponding to IAM user for storing creatives in s3 bucket

@RestController
public class AmazonSTSController {

	@RequestMapping(value = "/getSTSToken", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AmazonSTSResponse GetSTSToken() {

		AmazonSTSResponse response = new AmazonSTSResponse();
		
	    response = AmazonSTSService.getSTSToken();
		
	    return response;
	}





}
