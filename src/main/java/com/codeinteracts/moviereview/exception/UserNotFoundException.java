package com.codeinteracts.moviereview.exception;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = -5167475403690088006L;

	private String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

	public UserNotFoundException() {
		super();
		this.message = "Movie not found.";
	}
}
