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

import com.fpt.prm.mapper.AddressMapper;
import com.fpt.prm.model.Address;
import com.fpt.prm.model.BaseResponse;


@RestController
@RequestMapping("api")
@CrossOrigin
public class AddressController {
	@Autowired AddressMapper addressMapper;
	
	@GetMapping(value = "public/address/{id}")
	public ResponseEntity<BaseResponse> getAddressByID(@PathVariable("id") int addressID) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			Address data = addressMapper.findAddAddressByID(addressID);
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "public/address")
	public ResponseEntity<BaseResponse> getAddressAll() {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			List<Address> data = addressMapper.findAddAddress();
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
}
