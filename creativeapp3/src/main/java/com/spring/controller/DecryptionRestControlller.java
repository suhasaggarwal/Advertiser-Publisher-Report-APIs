package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.UserIdentification;
import com.spring.util.EncryptionModule;


@RestController
public class DecryptionRestControlller {

	//-------------------User Details API--------------------------------------------------------
	
			@RequestMapping(value = "/decrypt/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<UserIdentification> GetUserInfo(@PathVariable("token") String username) {

				UserIdentification userId = new UserIdentification();
				username=EncryptionModule.decrypt(null, null,username);
			    
				userId.setEmailId(username);
				
			    return new ResponseEntity<UserIdentification>(userId, HttpStatus.OK);
			
			}

}
