package com.fpt.prm.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ProductResponse {
	private int productID;
	private String productName;
	private int typeID;
	private Long price;
	private String userName;
	private String description;
	private String image;
	private boolean status;
	private String address;
	private int priority;
	private int numberOfDaysPriority;
	private Long createdDate;
	private Long updatedDate;
	private String createdUser;
	private String updatedUser;
	private List<Image> images;
	
	public ProductResponse(int productID, String productName, int typeID, Long price, String userName, String description,
			String image, boolean status, String address, int priority, int numberOfDaysPriority, Long createdDate,
			Long updatedDate, String createdUser, String updatedUser) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.typeID = typeID;
		this.price = price;
		this.userName = userName;
		this.description = description;
		this.image = image;
		this.status = status;
		this.address = address;
		this.priority = priority;
		this.numberOfDaysPriority = numberOfDaysPriority;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdUser = createdUser;
		this.updatedUser = updatedUser;
	}
	
	
}
