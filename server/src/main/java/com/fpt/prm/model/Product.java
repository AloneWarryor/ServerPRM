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
public class Product {
	private int productID;
	private String productName;
	private String typeID;
	private Long price;
	private String userName;
	private String description;
	private String image;
	private boolean status;
	private String addressID;
	private int priority;
	private int numberOfDaysPriority;
	private String createUser;
	private Date createdDate;
	private String updatedUser;
	private Date updatedDate;
	private List<Image> images;
	
	public Product(int productID, String productName, String typeID, Long price, String userName, String description,
			String image, boolean status, String addressID, int priority, int numberOfDaysPriority, String createUser,
			Date createdDate, String updatedUser, Date updatedDate) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.typeID = typeID;
		this.price = price;
		this.userName = userName;
		this.description = description;
		this.image = image;
		this.status = status;
		this.addressID = addressID;
		this.priority = priority;
		this.numberOfDaysPriority = numberOfDaysPriority;
		this.createUser = createUser;
		this.createdDate = createdDate;
		this.updatedUser = updatedUser;
		this.updatedDate = updatedDate;
	}
}
