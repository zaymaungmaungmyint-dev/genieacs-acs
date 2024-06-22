package com.as.genieacs.acs.service.device;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.as.genieacs.acs.dao.device.DeviceRepository;
import com.as.genieacs.acs.dto.device.DeviceDto;
import com.as.genieacs.acs.entity.mongo.Device;

@Service
public class DeviceService {

	private final DeviceRepository deviceRepository;

	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	public List<DeviceDto> findAllDevices() {
		List<DeviceDto> dtoList = new ArrayList<DeviceDto>();
		List<Device> entityList = deviceRepository.findAll();

		entityList.forEach(entity -> {
			dtoList.add(new DeviceDto(entity));
		});

		return dtoList;
	}

}
