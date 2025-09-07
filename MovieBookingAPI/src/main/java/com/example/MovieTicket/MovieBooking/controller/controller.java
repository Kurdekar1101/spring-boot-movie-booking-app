package com.example.MovieTicket.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class controller {
	
	@Autowired
	MovieServiceInterface movieServiceInterface;
	
	@PostMapping("/movie")
	public void createMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Validation failed for Movie fields.");
		}
		if (movieServiceInterface.existsById(movie.getId())) {
	        throw new IdAlreadyExist("Movie with ID " + movie.getId() + " already exists!");
	    }
		movieServiceInterface.createMovie(movie);
	}
	
	@GetMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable String id) {
		
		return movieServiceInterface.getMovieById(id);
	}
	
	@GetMapping("/movies")
	public List<Movie> getAllHotels(){
		return movieServiceInterface.getAllMovie();
	}
	
	@DeleteMapping("/movie/{id}")
	public void deleteMovie(@PathVariable String id) {
		movieServiceInterface.deleteMovie(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateMovie(@PathVariable String id,@RequestBody Movie movie) {
		movieServiceInterface.updateMovie(id, movie);
	}
}
