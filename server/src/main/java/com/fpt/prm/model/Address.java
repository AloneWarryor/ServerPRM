package com.fpt.prm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
	private int addressID;
	private String addressName;
	private String updatedDate;
	private String createdUser;
	private String updatedUser;
	
	public Address(int addressID, String addressName, String updatedDate, String createdUser, String updatedUser) {
		super();
		this.addressID = addressID;
		this.addressName = addressName;
		this.updatedDate = updatedDate;
		this.createdUser = createdUser;
		this.updatedUser = updatedUser;
	}
	
}
