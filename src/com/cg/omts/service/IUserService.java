package com.cg.omts.service;

import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;

public interface IUserService {

	public Movie getMovieDetails(int movieId) throws OMTSException;
	
}
