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
public class ProductParam {
	private int productID;
	private String productName;
	private int typeID;
	private Long price;
	private String userName;
	private String description;
	private List<String> image;
	private boolean status;
	private int addressID;
	private int priority;
	private int numberOfDaysPriority;
	private Date createdDate;
	private Date updatedDate;
	private String createUser;
	private String updatedUser;
	private List<Image> images;
	
	public ProductParam(int productID, String productName, int typeID, Long price, String userName, String description,
			List<String> image, boolean status, int addressID, int priority, int numberOfDaysPriority, Date createdDate,
			Date updatedDate, String createUser, String updatedUser) {
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
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createUser = createUser;
		this.updatedUser = updatedUser;
	}
	
	
}
