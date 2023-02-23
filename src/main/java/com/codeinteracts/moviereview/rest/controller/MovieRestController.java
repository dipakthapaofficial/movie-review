package com.codeinteracts.moviereview.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeinteracts.moviereview.dto.MovieDto;
import com.codeinteracts.moviereview.entity.Movie;
import com.codeinteracts.moviereview.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieRestController {
	
	@Autowired
	MovieService movieService;
	
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

}
