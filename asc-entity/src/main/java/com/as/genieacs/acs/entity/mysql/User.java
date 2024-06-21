package com.as.genieacs.acs.entity.mysql;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -2344445118920210741L;

	@Column(name = "name")
	private String name;

	@Column(name = "login_name")
	private String loginName;

	@Column(name = "account_status")
	private Integer accountStatus;

	@Column(name = "created_datetime")
	private Date createdDate;

	@Column(name = "updated_datetime")
	private Date updatedDate;
}
