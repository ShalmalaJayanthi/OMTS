package com.cg.omts.service;

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

}
