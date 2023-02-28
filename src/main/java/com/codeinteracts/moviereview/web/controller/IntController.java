package com.codeinteracts.moviereview.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntController {
	
	
	@GetMapping("/hello")
	public String hello(Model model) {
//		String message = (String) model.asMap().get("successMessage");
		
		return "hello";
	}
}
