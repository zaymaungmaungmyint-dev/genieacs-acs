package com.as.genieacs.acs.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.genieacs.acs.dto.user.UserDto;
import com.as.genieacs.acs.service.user.UserService;

@RestController
public class WelcomeController {

	private static Logger LOG = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String welcome() {
		return "Hello World";
	}

	@GetMapping("/mysql")
	public ResponseEntity<List<UserDto>> connectMySQL() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

//	@GetMapping("/")
//	public ResponseEntity<List<UserDto>> welcome() {
//		LOG.info("Starting welcome controller");
//		return new ResponseEntity<>(new ArrayList<UserDto>(), HttpStatus.OK);
//	}

}
