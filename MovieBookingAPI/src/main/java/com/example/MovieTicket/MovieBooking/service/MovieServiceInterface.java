package com.example.MovieTicket.MovieBooking.service;

import java.util.List;

import com.example.MovieTicket.MovieBooking.Model.Movie;

public interface MovieServiceInterface {

	public void createMovie(Movie movie);
	
	public boolean existsById(String id);
	
	public Movie getMovieById(String id);
	public List<Movie> getAllMovie();
	public void deleteMovie(String id);
	public void updateMovie(String id, Movie movie);
}
