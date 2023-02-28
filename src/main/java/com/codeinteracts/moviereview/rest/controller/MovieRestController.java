package com.codeinteracts.moviereview.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeinteracts.moviereview.dto.MovieDto;
import com.codeinteracts.moviereview.entity.Movie;
import com.codeinteracts.moviereview.entity.MovieReview;
import com.codeinteracts.moviereview.service.MovieReviewService;
import com.codeinteracts.moviereview.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieRestController {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	MovieReviewService movieReviewService;
	
	@GetMapping("/")
//	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<Page<Movie>> list(@RequestParam Integer pageNumber,@RequestParam Integer pageSize) {
		Page<Movie> movies = movieService.list(pageNumber, pageSize);
		return new ResponseEntity<Page<Movie>>(movies, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<String> createMovie(@Validated @RequestBody MovieDto movieDTO) {
		Movie movie = movieService.create(movieDTO);
		return new ResponseEntity<String>("Successful", HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}/details")
	public ResponseEntity<Movie> getMovieDetails(@PathVariable Long id) {
		Movie movie = movieService.get(id);
		return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}/update")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> update(@PathVariable Long id, @Validated @RequestBody MovieDto movieDTO) {
		Movie movie = movieService.update(movieDTO);
		return new ResponseEntity<String>("Successful", HttpStatus.OK);
	}
	
	@GetMapping("/{id}/reviews")
	public ResponseEntity<Page<MovieReview>> getMovieDetails(@PathVariable Long id,@RequestParam(required = false) Integer pageNumber,@RequestParam(required = false) Integer pageSize) {
		Page<MovieReview> movieReviews = movieReviewService.findByMovie(id, pageNumber, pageSize);
		return new ResponseEntity<Page<MovieReview>>(movieReviews, HttpStatus.OK);
	}
	
}
