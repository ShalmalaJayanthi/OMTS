package com.cg.omts.service;

import java.util.ArrayList;
import java.util.List;
import com.cg.omts.dao.AdminDaoImpl;
import com.cg.omts.dao.IAdminDao;
import com.cg.omts.dto.Customer;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public class AdminServiceImpl implements IAdminService{

	IAdminDao adminDao = null;
	
	
	@Override
	public List<Theatre> getTheatreDetails() throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.getTheatreDetails();
	}

	@Override
	public int addTheatre(Theatre theatre) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.addTheatre(theatre);
	}
	
	
	@Override
	public int deleteTheatre(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.deleteTheatre(theatreId);
	}
	
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
	public ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException{
		adminDao = new AdminDaoImpl();
		ArrayList<Movie> movieList = adminDao.getMovieDetailsToDelete();
		return movieList;
	}
	
	@Override
	public ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException {
		adminDao = new AdminDaoImpl();
		ArrayList<Theatre> getTheatreDetails = adminDao.getTheatreDetails(theatreCity);
		return getTheatreDetails;
	}

	@Override
	public int deleteMovie(Integer movieId) throws OMTSException {
		adminDao = new AdminDaoImpl();
		int rowsAffected = adminDao.deleteMovie(movieId);
		return rowsAffected;
	}

	@Override
	public Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException {
		adminDao = new AdminDaoImpl();
		Boolean isAdded = adminDao.addScreen(screen, theatreId);
		return isAdded;
	}

	@Override
	public Boolean deleteScreen(Integer screenId) throws OMTSException{
		adminDao = new AdminDaoImpl();
		Boolean isAdded = adminDao.deleteScreen(screenId);
		return isAdded;
	}

	@Override
	public ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException{
		adminDao = new AdminDaoImpl();
		ArrayList<Screen> screenList = adminDao.getScreenDetailsToDelete();
		return screenList;
	}

	@Override
	public List<Show> getShowDetails() throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.getShowDetails();
	}

	
	@Override
	public int addShow(Show show) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.addShow(show);
	}
	
	@Override
	public int deleteShow(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.deleteShow(showId);
	}

	@Override
	public List<Show> getShowByName(String showName) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.getShowByName(showName);
	}

	@Override
	public String validateLogin(Customer customer) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.validateLogin(customer);
	}

	@Override
	public int register(Customer customer) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.register(customer);
	}

	@Override
	public int getMovieLength(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		adminDao = adminDao = (IAdminDao) new AdminDaoImpl();
		return adminDao.getMovieLength(movieId);
	}

}
