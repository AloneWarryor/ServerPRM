package com.fpt.prm.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ProductType {
	private String typeID;
	private String typeName;
	private String typeImage;
	private String createUser;
	private Date createdDate;
	private String updatedUser;
	private Date updatedDate;
	
	public ProductType(String typeID, String typeName, String typeImage, String createUser, Date createdDate,
			String updatedUser, Date updatedDate) {
		super();
		this.typeID = typeID;
		this.typeName = typeName;
		this.typeImage = typeImage;
		this.createUser = createUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}
}
