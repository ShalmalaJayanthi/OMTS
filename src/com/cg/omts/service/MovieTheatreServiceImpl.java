package com.cg.omts.service;

import java.util.ArrayList;

import com.cg.omts.dao.IMovieTheatreDao;
import com.cg.omts.dao.MovieTheatreDaoImpl;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public class MovieTheatreServiceImpl implements IMovieTheatreService {
	IMovieTheatreDao movieTheatreDao = null;

	@Override
	public boolean addMovie(Movie movie) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		Boolean isAdded = movieTheatreDao.addMovie(movie);
		return isAdded;
	}

	@Override
	public ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		ArrayList<Movie> movieList = movieTheatreDao.getMovieDetailsToDelete();
		return movieList;
	}
	
	@Override
	public ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		ArrayList<Theatre> getTheatreDetails = movieTheatreDao.getTheatreDetails(theatreCity);
		return getTheatreDetails;
	}

	@Override
	public int deleteMovie(Integer movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		int rowsAffected = movieTheatreDao.deleteMovie(movieId);
		return rowsAffected;
	}

	@Override
	public boolean addMovieToTheatre(int movieId, int theatreId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isAdded = movieTheatreDao.addMovieToTheatre(movieId, theatreId);
		return isAdded;
	}

	@Override
	public ArrayList<Movie> getMovieIdName() throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		ArrayList<Movie> movieList = movieTheatreDao.getMovieIdName();
		return movieList;
	}

	@Override
	public boolean isMovieIdExists(int movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isExists = movieTheatreDao.isMovieIdExists(movieId);
		return isExists;
	}

	@Override
	public boolean isTheatreIdExists(int theatreId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isExists = movieTheatreDao.isTheatreIdExists(theatreId);
		return isExists;
	}

	@Override
	public boolean checkTheatreIdInCity(int theatreId, String theatreCity) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isCorrect = movieTheatreDao.checkTheatreIdInCity(theatreId, theatreCity);
		return isCorrect;
	}

	@Override
	public boolean checkIdTheatreMovieAlreadyExists(int theatreId, int movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isExists = movieTheatreDao.checkIdTheatreMovieAlreadyExists(theatreId, movieId);
		return isExists;
	}

}
