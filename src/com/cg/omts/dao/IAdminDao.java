package com.cg.omts.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Customer;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public interface IAdminDao {
	
	//movie theatre1,2,3,4
	public List<Theatre> getTheatreDetails() throws OMTSException;
	
	public  int addTheatre(Theatre theatre) throws OMTSException;

	public int deleteTheatre(int theatreId) throws OMTSException;
	
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException;
	
	public List<Show> getShowDetails() throws OMTSException;//show screen
	
	public int addShow(Show show) throws OMTSException;//show
	
	public int deleteShow(int showId) throws OMTSException;//show
	
	public List<Show> getShowByName(String showName) throws OMTSException;//show

	public String validateLogin(Customer customer) throws OMTSException;//user

	public int register(Customer customer) throws OMTSException;//user
	
	public int getMovieLength(int movieId) throws OMTSException;//movie 5
	
	public List<Integer> getScreenFromMovieAndTheatre(int theatreId, int movieId) throws OMTSException;//show
	
	public String getMovieNameById(int movieId) throws OMTSException;//movie 6
	
	public String checkShowNameandScreenId(String showName, int screenId) throws OMTSException;//show
	
	public boolean addMovie(Movie movie) throws OMTSException;//movie 7
	
	public boolean addMovieToTheatre(int movieId, int theatreId) throws OMTSException;//movie 8
	
	public ArrayList<Movie> getMovieIdName() throws OMTSException;//movie 9
	
	public  ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException;//movie 10
	
	public  int deleteMovie(Integer movieId) throws OMTSException;//movie 11
	
	public  ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException;//movie 12
	
	public boolean isMovieIdExists(int movieId) throws OMTSException;//movie 13
	
	public boolean isScreenIdExists(int screenId) throws OMTSException;//show
	
	public boolean isTheatreIdExists(int theatreId) throws OMTSException;//movie 14
	
	public boolean checkTheatreIdInCity(int theatreId, String theatreCity) throws OMTSException;//movie 15
	
	public boolean checkIdTheatreMovieAlreadyExists(int theatreId, int movieId) throws OMTSException;//movie 16
	
	public  Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException;//show
	
	public  Boolean deleteScreen(Integer screenId) throws OMTSException;//show
	
	public  ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException;//show
	
	public boolean addScreenSeatPrice(int screenId, int seatPrice) throws OMTSException;//show
}
