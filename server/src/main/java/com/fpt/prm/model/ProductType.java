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
	private int typeID;
	private String typeName;
	private String typeImage;
	private Date createdDate;
	private Date updatedDate;
	private String createdUser;
	private String updatedUser;
	
	public ProductType(int typeID, String typeName, String typeImage, Date createdDate, Date updatedDate,
			String createdUser, String updatedUser) {
		super();
		this.typeID = typeID;
		this.typeName = typeName;
		this.typeImage = typeImage;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdUser = createdUser;
		this.updatedUser = updatedUser;
	}
	
}
