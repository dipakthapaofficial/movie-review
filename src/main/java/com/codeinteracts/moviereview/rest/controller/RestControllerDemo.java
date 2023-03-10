package com.codeinteracts.moviereview.rest.controller;

import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.codeinteracts.moviereview.dto.LoginDTO;
import com.codeinteracts.moviereview.entity.User;
import com.codeinteracts.moviereview.rest.dto.UserDtoResponse;
import com.codeinteracts.moviereview.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest")
public class RestControllerDemo {
	
	public static final Logger logger = LoggerFactory.getLogger(RestControllerDemo.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
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
	
	
	@GetMapping("/something")
	public ResponseEntity<UserDtoResponse> data() {
		logger.info("Inside getDAta method");
		
//		return ResponseEntity.ok("Successful");
		
		//Consume REST API
//		String url = "https://www.fishwatch.gov/api/species/red-snapper";
		String url = "http://localhost:8092/user1";
//		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", "Basic YXBwbGU6YXBwbGU=");	
		
		
		//Get credentials from properties file
		String userPass = "apple:apple";
		
		String authParameter = Base64.getEncoder().encodeToString(userPass.getBytes());
		logger.info(authParameter);
		
		headers.add("Authorization", "Basic "+authParameter);	
		
		ResponseEntity<UserDtoResponse> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), UserDtoResponse.class);
		
		
		
		//Feign client
		
		//Service Discovery
		
		//JWT token, Oauth2 token
		
		
//		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		logger.info("Status Code:: "+response.getStatusCode());
		logger.info(response.getBody().toString());
		
		
		
		return new ResponseEntity<UserDtoResponse>(response.getBody(), HttpStatus.CREATED);
	}
	
	
}
