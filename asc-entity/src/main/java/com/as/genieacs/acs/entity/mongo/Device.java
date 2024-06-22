package com.as.genieacs.acs.entity.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "devices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device {

	@Id
	@Field(name = "_id")
	private String id;

	@Field(name = "_deviceId")
	private DeviceId deviceId;

	@Field("_lastInform")
	private Date lastInform;

	@Field("_registered")
	private Date registered;

	@Getter
	@Setter
	public static class DeviceId {

		@Field(name = "_Manufacturer")
		private String manufacturer;

		@Field(name = "_OUI")
		private String oui;

		@Field(name = "_ProductClass")
		private String productClass;

		@Field(name = "_SerialNumber")
		private String serialNumber;
	}

}
