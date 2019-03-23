package com.fpt.prm.model;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Account {
	private String userName;
	private String password;
	private String fullName;
	private String address;
	private String phoneNumber;
	private String email;
	private String avatar;
	private String money;
	private String role;
	private Date createdDate;
	private Date updatedDate;
	private String createUser;
	private String updatedUser;
	public Account(String userName, String password, String fullName, String address, String phoneNumber, String email,
			String avatar, String money, String role, Date createdDate, Date updatedDate, String createUser,
			String updatedUser) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.avatar = avatar;
		this.money = money;
		this.role = role;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createUser = createUser;
		this.updatedUser = updatedUser;
	}
	
	
}
