package com.as.genieacs.acs.dto.device;

import java.io.Serializable;
import java.util.Date;

import com.as.genieacs.acs.entity.mongo.Device;
import com.as.genieacs.acs.entity.mongo.Device.DeviceId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto implements Serializable {

	private static final long serialVersionUID = -8624547819692992320L;

	private String id;

	private DeviceIdDto deviceIdDto;

	private Date lastInform;

	private Date registered;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DeviceIdDto {

		private String manufacturer;

		private String oui;

		private String productClass;

		private String serialNumber;

		public DeviceIdDto(DeviceId deviceId) {
			if (deviceId != null) {
				this.manufacturer = deviceId.getManufacturer();
				this.oui = deviceId.getOui();
				this.productClass = deviceId.getProductClass();
				this.serialNumber = deviceId.getSerialNumber();
			}
		}
	}

	public DeviceDto(Device device) {
		if (device != null) {
			this.id = device.getId();
			this.deviceIdDto = new DeviceIdDto(device.getDeviceId());
			this.lastInform = device.getLastInform();
			this.registered = device.getRegistered();
		}
	}

}
