package com.cg.omts.dao;

import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;

public interface IUserDao {

	public Movie getMovieDetails(int movieId) throws OMTSException;
	public List<Movie> getAllMovies() throws OMTSException;
	public List<Integer> getTheatresByCity() throws OMTSException;
}
