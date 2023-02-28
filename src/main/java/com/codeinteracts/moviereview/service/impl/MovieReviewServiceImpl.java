package com.codeinteracts.moviereview.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codeinteracts.moviereview.dto.MovieReviewDto;
import com.codeinteracts.moviereview.entity.Movie;
import com.codeinteracts.moviereview.entity.MovieReview;
import com.codeinteracts.moviereview.entity.User;
import com.codeinteracts.moviereview.exception.MovieNotFoundException;
import com.codeinteracts.moviereview.exception.UserNotFoundException;
import com.codeinteracts.moviereview.repository.MovieReviewRepository;
import com.codeinteracts.moviereview.service.MovieReviewService;
import com.codeinteracts.moviereview.service.MovieService;
import com.codeinteracts.moviereview.service.UserService;

@Service
public class MovieReviewServiceImpl implements MovieReviewService {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieReviewServiceImpl.class);
	
	@Autowired
	private MovieReviewRepository movieReviewRepository;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public MovieReview create(String review, Long movieId, Long userId) throws MovieNotFoundException, UserNotFoundException {
		logger.info("movieId::"+movieId);
		MovieReview movieReview = new MovieReview();
		movieReview.setActive(Boolean.TRUE);
		movieReview.setCreateDate(LocalDateTime.now());
		movieReview.setReview(review);
		Movie movie = movieService.get(movieId);
		if (movie == null) {
			throw new MovieNotFoundException("Movie is not valid");
		}
		movieReview.setMovie(movie);
		
		User user = userService.get(userId);
		if (user == null) {
			throw new UserNotFoundException("User is not valid");
		}
		movieReview.setReviewer(user);
		movieReviewRepository.save(movieReview);
		return movieReview;
	}

	@Override
	public List<MovieReview> list() {
		return movieReviewRepository.findAll();
	}

	@Override
	public MovieReview get(Long id) {
		return movieReviewRepository.findById(id).get();
	}

	@Override
	public MovieReview update(Long id, String review) {
		MovieReview movieReview = get(id);
		movieReview.setReview(review);
		movieReviewRepository.save(movieReview);
		return movieReview;
	}

	@Override
	public MovieReview create(MovieReviewDto movieReviewDto) throws MovieNotFoundException, UserNotFoundException {
		MovieReview movieReview = create(movieReviewDto.getReview(), movieReviewDto.getMovieId(), movieReviewDto.getUserId());
		movieReviewRepository.save(movieReview);
		return movieReview;
	}

	@Override
	public Page<MovieReview> list(Integer pageNumber, Integer pageSize) {
		pageNumber = pageNumber == null ? 0 : pageNumber;
		pageSize = pageSize == null ? 10 : pageSize;
		
		Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
		Page<MovieReview> movieReviews = movieReviewRepository.findAll(page);

		return movieReviews;
	}

	@Override
	public MovieReview update(MovieReviewDto movieReviewDto) {
		return update(movieReviewDto.getId(), movieReviewDto.getReview());
	}

	@Override
	public Page<MovieReview> findByMovie(Long movieId, Integer pageNumber, Integer pageSize) {
		pageNumber = pageNumber == null ? 0 : pageNumber;
		pageSize = pageSize == null ? 10 : pageSize;
		Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
		Movie movie = movieService.get(movieId);
		return movieReviewRepository.findByMovie(movie, page);
	}

	@Override
	public Page<MovieReview> findByUser(Long userId, Integer pageNumber, Integer pageSize) {
		pageNumber = pageNumber == null ? 0 : pageNumber;
		pageSize = pageSize == null ? 10 : pageSize;
		Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
		User user = userService.get(userId);
		return movieReviewRepository.findByReviewer(user, page);
	}

}
