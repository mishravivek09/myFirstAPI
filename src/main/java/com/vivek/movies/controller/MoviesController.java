package com.vivek.movies.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.movies.exception.ResourceNotFound;
import com.vivek.movies.model.Movies;
import com.vivek.movies.repository.MoviesRepository;

@RestController
@RequestMapping("/api/v1")
public class MoviesController {
	@Autowired
	private MoviesRepository moviesRepository;
	
	@GetMapping("/movies")
	public List<Movies> getAllMovies(){
		return moviesRepository.findAll();
	}
	
	@PostMapping("/add/movies")
	public Movies addMovies(@Validated @RequestBody Movies movie) {
		return moviesRepository.save(movie);
	}
	@GetMapping("movies/{id}")
	public ResponseEntity<Movies> getMoviesById(@PathVariable (value="id")long id) throws ResourceNotFound{
		Movies movie= moviesRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Movie not found :: "+id));
		return ResponseEntity.ok().body(movie);
	}
	@PutMapping("movies/{id}")
	public ResponseEntity<Movies> updateMovies(@PathVariable (value="id")long id,@RequestBody Movies movieDetails) throws ResourceNotFound{
		Movies movie= moviesRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Movie not found :: "+id));
		movie.setMovieName(movieDetails.getMovieName());
		movie.setMovieImage(movieDetails.getMovieImage());
		movie.setMovieUrl(movieDetails.getMovieUrl());
		movie.setMovieYear(movieDetails.getMovieYear());
		moviesRepository.save(movie);
		return ResponseEntity.ok().body(movie);
	}
	@DeleteMapping("movies/{id}")
	public ResponseEntity<Object> deleteMovie(@PathVariable(value="id")long id) throws ResourceNotFound {
		moviesRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Movie not found :: "+id));
		moviesRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
