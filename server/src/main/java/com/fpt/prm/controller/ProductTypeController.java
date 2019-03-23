package com.fpt.prm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.prm.mapper.ProductTypeMapper;
import com.fpt.prm.model.BaseResponse;
import com.fpt.prm.model.ProductType;

@RestController
@RequestMapping("api")
@CrossOrigin
public class ProductTypeController {
	
	@Autowired ProductTypeMapper productTypeMapper;
	
	// Fetches all productTypes
	@GetMapping(value = "productTypes")
	public ResponseEntity<BaseResponse> getAllproductTypes() {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			List<ProductType> data = productTypeMapper.findAllProductType();
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
}
