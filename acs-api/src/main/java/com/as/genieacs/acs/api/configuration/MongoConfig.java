package com.as.genieacs.acs.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.as.genieacs.acs.entity")
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;

	@Override
	protected String getDatabaseName() {
		return "genieacs";
	}

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create(mongoUri);
	}

	MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), getDatabaseName());
	}

}
