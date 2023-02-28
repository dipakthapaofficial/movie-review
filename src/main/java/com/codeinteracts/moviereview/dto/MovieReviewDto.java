package com.codeinteracts.moviereview.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MovieReviewDto {

	private Long id;

	@NotNull(message = "Review field can't be empty")
	@NotBlank(message = "Review can't be blank")
	private String review;

	@NotNull(message = "Movie field can't be null")
	private Long movieId;
	
	@NotNull(message = "Reviwer field can't be null")
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
