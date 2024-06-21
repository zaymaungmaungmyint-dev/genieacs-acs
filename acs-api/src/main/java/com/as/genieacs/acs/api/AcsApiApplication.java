package com.as.genieacs.acs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.as.genieacs.acs.api", "com.as.genieacs.acs.service", "com.as.genieacs.acs.dao",
		"com.as.genieacs.acs.entity" })
public class AcsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcsApiApplication.class, args);
	}

}
