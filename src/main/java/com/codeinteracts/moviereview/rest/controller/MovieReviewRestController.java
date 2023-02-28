package com.codeinteracts.moviereview.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeinteracts.moviereview.dto.MovieReviewDto;
import com.codeinteracts.moviereview.entity.MovieReview;
import com.codeinteracts.moviereview.exception.MovieNotFoundException;
import com.codeinteracts.moviereview.exception.UserNotFoundException;
import com.codeinteracts.moviereview.service.MovieReviewService;

@RestController
@RequestMapping("/review")
public class MovieReviewRestController {
	
	@Autowired
	MovieReviewService movieReviewService;
	
	@GetMapping("/")
	public ResponseEntity<Page<MovieReview>> list(@RequestParam(required = false) Integer pageNumber,@RequestParam(required = false) Integer pageSize) {
		Page<MovieReview> movieReviews = movieReviewService.list(pageNumber, pageSize);
		return new ResponseEntity<Page<MovieReview>>(movieReviews, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<String> createReview(@Validated @RequestBody MovieReviewDto movieReviewDto) throws MovieNotFoundException, UserNotFoundException {
		MovieReview movieReview = movieReviewService.create(movieReviewDto);
		return new ResponseEntity<String>("Successful", HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}/details")
	public ResponseEntity<MovieReview> getReviewDetails(@PathVariable Long id) {
		MovieReview movieReview =  movieReviewService.get(id);
		return new ResponseEntity<MovieReview>(movieReview, HttpStatus.CREATED);
	}

}
