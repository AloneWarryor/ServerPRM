package com.fpt.prm.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Image {
	private int productID;
	private String image;
	private Date createdDate;
	private Date updatedDate;
	private String createdUser;
	private String updatedUser;
	public Image(int productID, String image, Date createdDate, Date updatedDate, String createdUser,
			String updatedUser) {
		super();
		this.productID = productID;
		this.image = image;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdUser = createdUser;
		this.updatedUser = updatedUser;
	}

}
