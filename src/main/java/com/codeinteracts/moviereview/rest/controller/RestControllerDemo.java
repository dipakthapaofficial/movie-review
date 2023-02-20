package com.codeinteracts.moviereview.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeinteracts.moviereview.entity.User;
import com.codeinteracts.moviereview.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

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
//	@RequestMapping(name="/user", produces = "application/json")
	public List<User> list() {
		List<User> users = userService.list();
		return users;
	}
	
	@PostMapping("/save")
	public String getData(@RequestParam("username") String username, @RequestParam("password") String password) {
		logger.info(username);
		logger.info(password);
		
		return "Successfull";
		
	}
	
	@PostMapping("/data")
	public String getData1(@RequestBody String username) {
		logger.info("Inside getDAta method");
		
		return "Successfull";
		
	}
	
	
}
