package com.as.genieacs.acs.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.genieacs.acs.dto.device.DeviceDto;
import com.as.genieacs.acs.dto.user.UserDto;
import com.as.genieacs.acs.service.device.DeviceService;
import com.as.genieacs.acs.service.user.UserService;

@RestController
public class WelcomeController {

	private static Logger LOG = LoggerFactory.getLogger(WelcomeController.class);

	private final UserService userService;
	private final DeviceService deviceService;

	public WelcomeController(UserService userService, DeviceService deviceService) {
		this.userService = userService;
		this.deviceService = deviceService;
	}

	@GetMapping("/")
	public String welcome() {
		return "ASC API is up and running...";
	}

	@GetMapping("/mysql")
	public ResponseEntity<List<UserDto>> connectMySQLDB() {
		LOG.info("Connecting to MySQL...");
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/mongo")
	public ResponseEntity<List<DeviceDto>> connectMongoDB() {
		LOG.info("Connecting to Mongo...");
		return new ResponseEntity<>(deviceService.findAllDevices(), HttpStatus.OK);
	}

}
