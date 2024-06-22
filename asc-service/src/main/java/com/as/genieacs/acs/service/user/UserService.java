package com.as.genieacs.acs.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.as.genieacs.acs.dao.user.UserRepository;
import com.as.genieacs.acs.dto.user.UserDto;
import com.as.genieacs.acs.entity.mysql.User;
import com.as.genieacs.asc.utils.CommonUtil;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	private static Logger LOG = LoggerFactory.getLogger(CommonUtil.class);

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserDto> getUsers() {
		LOG.info("Fetaching users...");
		List<UserDto> dtoList = new ArrayList<UserDto>();

		try {
			List<User> entityList = userRepository.findAll();
			entityList.forEach(entity -> {
				dtoList.add(new UserDto(entity));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

}
