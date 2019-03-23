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
	private String createUser;
	private Date createdDate;
	private String updatedUser;
	private Date updatedDate;

	public Image(int productID, String image, String createUser, Date createdDate, String updatedUser,
			Date updatedDate) {
		super();
		this.productID = productID;
		this.image = image;
		this.createUser = createUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}
}
