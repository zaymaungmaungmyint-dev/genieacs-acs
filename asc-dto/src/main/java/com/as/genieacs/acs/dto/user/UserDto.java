package com.as.genieacs.acs.dto.user;

import com.as.genieacs.acs.entity.mysql.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private long id;

	private String name;

	private String loginName;

	private int accountStatus;

	public UserDto(User user) {
		if (user != null) {
			this.id = user.getId();
			this.name = user.getName();
			this.loginName = user.getLoginName();
			this.accountStatus = user.getAccountStatus();
		}
	}

}
