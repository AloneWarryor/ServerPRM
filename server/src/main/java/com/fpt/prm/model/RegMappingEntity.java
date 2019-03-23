package com.fpt.prm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegMappingEntity {
	String username;
	String password;
	String email;
	String phoneNumber;
	String address;
	
	public RegMappingEntity(String username, String password, String email, String phoneNumber, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
}
