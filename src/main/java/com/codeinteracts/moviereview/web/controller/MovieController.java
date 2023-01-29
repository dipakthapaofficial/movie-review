package com.codeinteracts.moviereview.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeinteracts.moviereview.entity.Movie;
import com.codeinteracts.moviereview.service.MovieService;

@Controller
@RequestMapping("/web/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/")
	public String list(Model model) {
		List<Movie> movies = movieService.list();
		model.addAttribute("movies", movies);
		return "movie/movie";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		return "movie/movie-create";
		
	}
	
	@PostMapping("/create")
	public String createMovie(Model model, @RequestParam String name, @RequestParam String description, @RequestParam(required = false) BigDecimal budget) {
		Movie movie = movieService.create(name, description, budget);
		return "redirect:/web/movie/";
		
	}
	
	@GetMapping("/{id}/details")
	public String getMovieDetails(Model model, @PathVariable Long id) {
		Movie movie = movieService.get(id);
		model.addAttribute("movie", movie);
		return "movie/movie-detail";
		
	}
	
	@GetMapping("/{id}/update")
	public String update(Model model, @PathVariable Long id) {
		Movie movie = movieService.get(id);
		model.addAttribute("movie", movie);
		return "redirect:/web/movie/update";
		
	}
	
	@PostMapping("/{id}/update")
	public String update(Model model, @PathVariable Long id, @RequestParam String name, @RequestParam String description, @RequestParam BigDecimal budget) {
		Movie movie = movieService.update(id, name, description, budget);
		model.addAttribute("movie", movie);
		return "redirect:/web/movie/";
		
	}
	

}
