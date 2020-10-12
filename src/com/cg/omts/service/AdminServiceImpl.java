package com.cg.omts.service;

import java.util.ArrayList;
import java.util.List;
import com.cg.omts.dao.AdminDaoImpl;
import com.cg.omts.dao.IAdminDao;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public class AdminServiceImpl implements IAdminService{

	IAdminDao adminDao = null;
	
	
	/***********
	 @Description : This methods returns all Theatres available
	 @author :  supraja
	 @return : List of Theatre type
	***********/
	@Override
	public List<Theatre> getTheatreDetails() throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.getTheatreDetails();
	}

	/**********
	@Description: To add the newly registered Theatre
	@author : supraja
	@param1  : Theatre object
	@return : Number of theatres added
	*******/
	@Override
	public int addTheatre(Theatre theatre) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.addTheatre(theatre);
	}
	
	/*******
	 @Description: To delete specified Theatre
	 @author : supraja
	 @param : Theatre Id
	 @return : No of theatres deleted
	********/
	@Override
	public int deleteTheatre(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.deleteTheatre(theatreId);
	}
	
	/*********
	 @Description : To get the list of theatres by specified theatre name 
	 @author : supraja
	 @param : theatre name
	 @return : List of theatre of specified name 
	*********/
	@Override
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.getTheatreByName(theatreName);
	}

	@Override
	public Boolean addMovie(Movie movie, Integer theatreId) throws OMTSException {
		adminDao = new AdminDaoImpl();
		Boolean isAdded = adminDao.addMovie(movie, theatreId);
		return isAdded;
	}

	@Override
	public ArrayList<Movie> getMovieDetailsToDelete() {
		adminDao = new AdminDaoImpl();
		ArrayList<Movie> movieList = adminDao.getMovieDetailsToDelete();
		return movieList;
	}
	
	@Override
	public ArrayList<Theatre> getTheatreDetails(String theatreCity) {
		adminDao = new AdminDaoImpl();
		ArrayList<Theatre> getTheatreDetails = adminDao.getTheatreDetails(theatreCity);
		return getTheatreDetails;
	}

	@Override
	public int deleteMovie(Integer movieId) {
		adminDao = new AdminDaoImpl();
		int rowsAffected = adminDao.deleteMovie(movieId);
		return rowsAffected;
	}

	@Override
	public Boolean addScreen(Screen screen, Integer theatreId) {
		adminDao = new AdminDaoImpl();
		Boolean isAdded = adminDao.addScreen(screen, theatreId);
		return isAdded;
	}

	@Override
	public Boolean deleteScreen(Integer screenId) {
		adminDao = new AdminDaoImpl();
		Boolean isAdded = adminDao.deleteScreen(screenId);
		return isAdded;
	}

	@Override
	public ArrayList<Screen> getScreenDetailsToDelete() {
		adminDao = new AdminDaoImpl();
		ArrayList<Screen> screenList = adminDao.getScreenDetailsToDelete();
		return screenList;
	}

	/*********
	 @Description : To get details of all the shows
	 @author : supraja
	 @return : List of shows
	**********/
	@Override
	public List<Show> getShowDetails() throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.getShowDetails();
	}

	/*********
	 @Description : To add the registered show
	 @author : supraja
	 @param  : show object
	 @return : Number of shows inserted 
	********/
	@Override
	public int addShow(Show show) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.addShow(show);
	}
	
	/******
	 @Description : To deleted requested show
	 @author : supraja
	 @param : show Id
	 @return : number of shows deleted 
	********/
	@Override
	public int deleteShow(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.deleteShow(showId);
	}

	/*******
	 @Description : To get the list of shows of specific show name
	 @author  : supraja
	 @param : show name
	 @return : List of shows of specified name
	********/
	@Override
	public List<Show> getShowByName(String showName) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.getShowByName(showName);
	}

}
