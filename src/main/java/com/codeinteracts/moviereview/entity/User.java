package com.codeinteracts.moviereview.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -8465435978921775452L;

	private Long id;

	private String username;

	private String email;

	private String password;

//	@ColumnDefault("true")
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
}
