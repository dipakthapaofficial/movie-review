package com.codeinteracts.moviereview.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.codeinteracts.moviereview.dto.MovieReviewDto;
import com.codeinteracts.moviereview.entity.MovieReview;
import com.codeinteracts.moviereview.exception.MovieNotFoundException;
import com.codeinteracts.moviereview.exception.UserNotFoundException;

public interface MovieReviewService {
	
	List<MovieReview> list();

	MovieReview get(Long id);
	
	MovieReview update(Long id, String review);

	MovieReview create(MovieReviewDto movieReviewDto) throws MovieNotFoundException, UserNotFoundException;

	Page<MovieReview> list(Integer pageNumber, Integer pageSize);

	MovieReview update(MovieReviewDto movieReviewDto);

	MovieReview create(String review, Long movieId, Long userId) throws MovieNotFoundException, UserNotFoundException;

	Page<MovieReview> findByMovie(Long movieId, Integer pageNumber, Integer pageSize);
	
	Page<MovieReview> findByUser(Long userId, Integer pageNumber, Integer pageSize);
}
