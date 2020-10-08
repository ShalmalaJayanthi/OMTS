package com.cg.omts.service;

import java.util.List;

import com.cg.omts.dao.IUserDao;
import com.cg.omts.dao.UserDaoImpl;
import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;

public class UserServiceImpl implements IUserService{
	
	IUserDao userDao = new UserDaoImpl();
	@Override
	public Movie getMovieDetails(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getMovieDetails(movieId);
	}
	@Override
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTheatresByMovie(movieId);
	}
	@Override
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTheatreNames(theatreIdList);
	}
	@Override
	public List<Integer> getTheatresByCity(String city) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTheatresByCity(city);
	}
	@Override
	public List<Movie> getAllMovies() throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getAllMovies();

	}

}
