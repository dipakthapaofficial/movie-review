package com.codeinteracts.moviereview.exception;

public class MovieNotFoundException extends Exception {

	private static final long serialVersionUID = -8794842977850169447L;
	
	private String message;

	public MovieNotFoundException(String message) {
		super();
		this.message = message;
	}

	public MovieNotFoundException() {
		super();
		this.message = "Movie not found.";
	}
}
