package com.cg.omts.dao;

import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;

public interface IUserDao {

	public Movie getMovieDetails(int movieId) throws OMTSException;
}
