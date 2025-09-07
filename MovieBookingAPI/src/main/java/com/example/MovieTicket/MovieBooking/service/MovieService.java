package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;

@Service
public class MovieService implements MovieServiceInterface {

	List<Movie> movieList = new ArrayList<>();
	Map<String,Movie> movieMap = new HashMap<>();
	
	@Override
	public void createMovie(Movie movie) {
		movieList.add(movie);
		movieMap.put(movie.getId(), movie);

	}
	
	@Override
	public boolean existsById(String id) {
	    return movieMap.containsKey(id);
	}

	@Override
	public Movie getMovieById(String id) {
		if(ObjectUtils.isEmpty(movieMap.get(id))) {
			throw new IdNotFound("ID not found");
		}
		return movieMap.get(id);
	}

	@Override
	public List<Movie> getAllMovie() {
		return movieList;
	}

	@Override
	public void deleteMovie(String id) {
		Movie movie = getMovieById(id);
		movieList.remove(movie);
		movieMap.remove(id);
	}

	@Override
	public void updateMovie(String id,Movie upMovie) {
//		Movie existMovie = getMovieById(upMovie.getId());
//		movieList.remove(existMovie);
//		movieList.add(upMovie);
//		movieMap.put(upMovie.getId(), upMovie);
		
		Movie existMovie = getMovieById(id);
		movieList.remove(existMovie);
		upMovie.setId(id);
		movieList.add(upMovie);
	    movieMap.put(id, upMovie);
	}

}
