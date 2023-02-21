package com.codeinteracts.moviereview.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LoginDTO {
	
	@NotNull(message = "Username can't be null")
	@NotEmpty(message = "Username can't be empty")
	private String username;
	
	@NotNull(message = "Password can't be null")
	@NotEmpty(message = "Password can't be empty")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
