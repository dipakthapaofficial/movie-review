package com.codeinteracts.moviereview.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeinteracts.moviereview.dto.LoginDTO;
import com.codeinteracts.moviereview.entity.User;
import com.codeinteracts.moviereview.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest")
public class RestControllerDemo {
	
	public static final Logger logger = LoggerFactory.getLogger(RestControllerDemo.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/hello")
	String sayHello() {
		return  "Hello";
	}
	
	@GetMapping("/user")
//	@RequestMapping(name="/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> list() {
		List<User> users = userService.list();
		return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
	}
	
	@PostMapping("/save")
	public String getData(@Valid @RequestBody LoginDTO loginDto) throws Exception {
		logger.info(loginDto.getUsername());
		logger.info(loginDto.getPassword());
		
		if (loginDto.getPassword().equals("password")) {
			throw new Exception("Weak password");
			
		}
		
		return "Successfull";
		
	}
	
	@PostMapping("/data")
	public ResponseEntity<String> getData1(@RequestBody String username) {
		logger.info("Inside getDAta method");
		
//		return ResponseEntity.ok("Successful");
		return new ResponseEntity<String>("Successful", HttpStatus.CREATED);
	}
	
	
}
