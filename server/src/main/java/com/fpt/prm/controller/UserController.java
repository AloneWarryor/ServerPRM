package com.fpt.prm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.prm.mapper.AccountMapper;
import com.fpt.prm.model.Account;
import com.fpt.prm.model.BaseResponse;
import com.fpt.prm.model.RegMappingEntity;

@RestController
@RequestMapping("api")
@CrossOrigin
public class UserController {

		@Autowired AccountMapper accountMapper;
		//Fetches user by user name
		@GetMapping("public/user/{username}")
		public ResponseEntity<BaseResponse> getArticleById(@PathVariable("username") String username) {
			BaseResponse baseResponse = new BaseResponse(0, null);
			try {
				Account data = accountMapper.findByUsername(username);
				baseResponse.setStatus(1);
				baseResponse.setData(data);
			} catch (Exception e) {
				baseResponse.setStatus(0);
				e.printStackTrace();
			}
			return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
		}
		
		//Fetches all users 
		@GetMapping(value="users")
		public ResponseEntity<BaseResponse> getAllArticles() {
			BaseResponse baseResponse = new BaseResponse(0, null);
			try {
				List<Account> data = accountMapper.findAllUsers();
				baseResponse.setStatus(1);
				baseResponse.setData(data);
			} catch (Exception e) {
				baseResponse.setStatus(0);
				e.printStackTrace();
			}
			return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
		}
		
		//Creates a new user
		@PostMapping(path = "public/reg", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<BaseResponse> addArticle(@RequestBody RegMappingEntity UserInfo) {
			BaseResponse baseResponse = new BaseResponse(0, null);
			try {
				int status = accountMapper.regUser(new Account(UserInfo.getUsername(), UserInfo.getPassword(), UserInfo.getFullName(), UserInfo.getAddress(), UserInfo.getPhoneNumber(), UserInfo.getEmail(), null, "0", "user", UserInfo.getUsername(), new Date(), UserInfo.getUsername(), new Date()));
				baseResponse.setStatus(status);
				if (status == 1) {
					baseResponse.setData(accountMapper.findByUsername(UserInfo.getUsername()));
				}
			} catch (Exception e) {
				baseResponse.setStatus(0);
				e.printStackTrace();
				return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
			}
			
	        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.CREATED);
		}
		
		//Updates user
		@PutMapping(path = "user/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> updateArticle(@RequestBody String articleInfo) {
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		//Disable user by id
		@DeleteMapping("/user/disable/{id}")
		public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}	
}
