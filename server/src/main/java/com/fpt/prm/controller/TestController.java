package com.fpt.prm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class TestController {

		
		//Fetches user by id
		@GetMapping("user/{id}")
		public ResponseEntity<Void> getArticleById(@PathVariable("id") Integer id) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		//Fetches all users 
		@GetMapping(value="users")
		public ResponseEntity<Void> getAllArticles() {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		//Creates a new user
		@PostMapping("reg")
		public ResponseEntity<Void> addArticle(@RequestBody String articleInfo, UriComponentsBuilder builder) {
	                return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		
		//Updates user
		@PutMapping("update")
		public ResponseEntity<Void> updateArticle(@RequestBody String articleInfo) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		//Disable user by id
		@DeleteMapping("disable/{id}")
		public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}	
}
