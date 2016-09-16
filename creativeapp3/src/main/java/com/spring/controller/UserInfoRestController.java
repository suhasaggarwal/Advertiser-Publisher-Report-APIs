package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.UserRole;
import com.spring.service.UserDao;


@RestController
public class UserInfoRestController {

	
	

		//-------------------User Details API--------------------------------------------------------
		
		@RequestMapping(value = "/login/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<UserRole> GetUserInfo(@PathVariable("username") String username) {

			String roleId;
			roleId=UserDao.GetUserRole(username);
		    UserRole role = new UserRole();
		    role.setEmailId(username);
		    role.setRoleId(roleId);
		    return new ResponseEntity<UserRole>(role, HttpStatus.OK);
		
		}
		


}
