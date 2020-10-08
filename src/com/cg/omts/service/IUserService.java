package com.cg.omts.service;

import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;

public interface IUserService {

	public Movie getMovieDetails(int movieId) throws OMTSException;
	List<Movie> getAllMovies() throws OMTSException;
	List<Integer> getTheatresByCity() throws OMTSException;
	
}
