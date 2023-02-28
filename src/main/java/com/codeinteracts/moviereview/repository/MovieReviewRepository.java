package com.codeinteracts.moviereview.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codeinteracts.moviereview.entity.Movie;
import com.codeinteracts.moviereview.entity.MovieReview;
import com.codeinteracts.moviereview.entity.User;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {
	
	Page<MovieReview> findByMovie(Movie movie, Pageable pageInfo);
	
	Page<MovieReview> findByReviewer(User user, Pageable pageInfo);
	
}
