package com.cg.omts.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Customer;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public interface IAdminService {

	/***********
	 @Description : This methods returns all Theatres available
	 @author :  supraja
	 @return : List of Theatre type
	 @Exception: throws OMTSException
	***********/
	public List<Theatre> getTheatreDetails() throws OMTSException;
	
	/**********
	@Description: To add the newly registered Theatre
	@author : supraja
	@param1  : Theatre object
	@return : Number of theatres added
	@Exception : throws OMTSException
	*******/
	
	public  int addTheatre(Theatre theatre) throws OMTSException;

	/*******
	 @Description: To delete specified Theatre
	 @author : supraja
	 @param : Theatre Id
	 @return : No of theatres deleted
	 @Exception : throws OMTSException
	********/
	public int deleteTheatre(int id) throws OMTSException;

	/*********
	 @Description : To get the list of theatres by specified theatre name 
	 @author : supraja
	 @param : theatre name
	 @return : List of theatre of specified name 
	  @Exception : throws OMTSException
	*********/
	
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException;
	

	/*********
	 @Description : To get details of all the shows
	 @author : supraja
	 @return : List of shows
	 @Exception : throws OMTSException
	**********/
	public List<Show> getShowDetails() throws OMTSException;
	
	/*********
	 @Description : To add the registered show
	 @author : supraja
	 @param  : show object
	 @return : Number of shows inserted
	 @Exception : throws OMTSException
	  
	********/
	public int addShow(Show show) throws OMTSException;
	
	/******
	 @Description : To deleted requested show
	 @author : supraja
	 @param : show Id
	 @return : number of shows deleted 
	 @Exception : throws OMTSException
	********/
	public int deleteShow(int showId) throws OMTSException;
	
	/*******
	 @Description : To get the list of shows of specific show name
	 @author  : supraja
	 @param : show name
	 @return : List of shows of specified name
	 @Exception : throws OMTSException
	********/
	
	public List<Show> getShowByName(String showName) throws OMTSException;
	
	/*******
	 @Description : To validate login
	 @author  : Ashutosh
	 @param : customer object
	 @return : roleCode
	 @Exception : throws OMTSException
	********/
	public String validateLogin(Customer customer) throws OMTSException;
	
	/*******
	 @Description : To register a new user
	 @author  : Ashutosh
	 @param : customer object
	 @return : number of users added
	 @Exception : throws OMTSException
	********/
	public int register(Customer customer) throws OMTSException;
	
	/**@Description : To get the movie length of requested movie
	 * @author  : supraja
	 * @param movieId
	 * @return
	 * @throws OMTSException
	 */
	public int getMovieLength(int movieId) throws OMTSException;
	/***
	 * @Description : To get the screen Id from movie and theatre
	 * @author  : supraja
	 * @param theatreId
	 * @param movieId
	 * @return
	 * @throws OMTSException
	 */
	public List<Integer> getScreenFromMovieAndTheatre(int theatreId, int movieId) throws OMTSException;
	
	/***
	 * @Description : To get movie name from movie 
	 * @author  : supraja
	 * @param movieId
	 * @return
	 * @throws OMTSException
	 */
	public String getMovieNameById(int movieId) throws OMTSException;
	
	/*******
	 * @Description : To check if there exists a  showname in screenId
	 * @author  : supraja
	 * @param showName
	 * @param screenId
	 * @return
	 * @throws OMTSException
	 */
	public String checkShowNameandScreenId(String showName, int screenId) throws OMTSException;
	
	/****
	 * @description Method to add the movie details to the given theatreID
	 * @author Jayanthi Shalmala
	 * 
	 * @param movie 
	 * @param theatreId
	 * @return boolean value
	 * @throws OMTSException
	 */
	
	public  boolean addMovie(Movie movie) throws OMTSException;
	
	/*****
	 * @description Method to get the movie details
	 * @author Jayanthi Shalmala
	 * 
	 * @return ArrayList<Movie>
	 * @throws OMTSException
	 */
	
	public  ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException;
	
	
	/*****
	 * @description Method to delete the movie with the given movieId
	 * @author Jayanthi Shalmala
	 * 
	 * @param movieId
	 * @return int
	 * @throws OMTSException
	 */
	public  int deleteMovie(Integer movieId) throws OMTSException;
	
	
	/*****
	 * @description Method to get the theatre details that belong to the given city
	 * @author Jayanthi Shalmala
	 * 
	 * @param theatreCity
	 * @return ArrayList<Theatre>
	 * @throws OMTSException
	 */
	public  ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException;
	
	
	/*****
	 * @description Method to add the screen to the given theatreId
	 * @author Jayanthi Shalmala
	 * 
	 * @param screen
	 * @param theatreId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public  Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException;
	
	
	/*****
	 * @description Method to delete the screen with given screenId
	 * @author Jayanthi Shalmala
	 *  
	 * @param screenId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public  Boolean deleteScreen(Integer screenId) throws OMTSException;
	
	
	/*****
	 * @description Method to get the screen details
	 * @author Jayanthi Shalmala
	 * 
	 * @return ArrayList<Screen> 
	 * @throws OMTSException
	 */
	public abstract ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException;
	
	/*****
	 * @description Method to add movie to the theatre
	 * @author Jayanthi Shalmala
	 * @param movieId
	 * @param theatreId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean addMovieToTheatre(int movieId, int theatreId) throws OMTSException;
	
	/*****
	 * @description Method to get the movie ID and movie Name
	 * @author Jayanthi Shalmala
	 * @return ArrayList<Movie>
	 * @throws OMTSException
	 */
	public ArrayList<Movie> getMovieIdName() throws OMTSException;
	
	/*****
	 * @description Method to check whether the movie with given ID exists or not
	 * @author Jayanthi Shalmala
	 * @param movieId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean isMovieIdExists(int movieId) throws OMTSException;
	
	/*****
	 * @description Method to check whether the screen with given ID exists or not
	 * @author Jayanthi Shalmala
	 * @param screenId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean isScreenIdExists(int screenId) throws OMTSException;
	
	/*****
	 * @description Method to check whether the theatre with given ID exists or not
	 * @author Jayanthi Shalmala
	 * @param theatreId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean isTheatreIdExists(int theatreId) throws OMTSException;
	
	/*****
	 * @description Method to check whether the given theatre ID is in the given city or not
	 * @author Jayanthi Shalmala
	 * @param theatreId
	 * @param theatreCity
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean checkTheatreIdInCity(int theatreId, String theatreCity) throws OMTSException;
	
	/*****
	 * @description Method to check whether the given movie ID and theatre ID already exists or not
	 * @author Jayanthi Shalmala
	 * @param theatreId
	 * @param movieId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean checkIdTheatreMovieAlreadyExists(int theatreId, int movieId) throws OMTSException;
	
	/*****
	 * @description Method to add screen seat price
	 * @author Jayanthi Shalmala
	 * @param screenId
	 * @param seatPrice
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean addScreenSeatPrice(int screenId, int seatPrice) throws OMTSException;
}
