package com.fpt.prm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.prm.mapper.AccountMapper;
import com.fpt.prm.mapper.ProductMapper;
import com.fpt.prm.mapper.ProductTypeMapper;
import com.fpt.prm.model.Account;
import com.fpt.prm.model.BaseResponse;
import com.fpt.prm.model.Product;
import com.fpt.prm.model.ProductType;

@RestController
@RequestMapping("api")
@CrossOrigin
public class ProductController {

	@Autowired ProductMapper productMapper;
	
	// Fetches all products
	@GetMapping(value = "products")
	public ResponseEntity<BaseResponse> getAllproducts() {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			List<Product> data = productMapper.getAllProductActive();
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "products/{typeId}")
	public ResponseEntity<BaseResponse> getAllproductsByTypeId(@PathVariable("typeId") String typeId) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			List<Product> data = productMapper.getAllProductActiveByTypeId(typeId);
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "products/{productId}")
	public ResponseEntity<BaseResponse> getProductByID(@PathVariable("productId") String productId) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			Product data = productMapper.getProductByID(productId);
			data.setImages(productMapper.getProductPicByID(productId));
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
}
