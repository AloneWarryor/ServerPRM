package com.fpt.prm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
	private int status;
	private Object data;
	
	public BaseResponse(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
}
