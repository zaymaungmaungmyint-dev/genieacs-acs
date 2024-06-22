package com.as.genieacs.acs.dao.device;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.as.genieacs.acs.entity.mongo.Device;

@Repository
public class DeviceRepository {

	private final MongoTemplate mongoTemplate;

	public DeviceRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<Device> findAll() {
		return mongoTemplate.findAll(Device.class);
	}

	public Optional<Device> findById(String id) {
		Device device = mongoTemplate.findById(id, Device.class);
		return Optional.ofNullable(device);
	}

	public Device save(Device device) {
		mongoTemplate.save(device);
		return device;
	}

	public void delete(Device device) {
		mongoTemplate.remove(device);
	}
}
