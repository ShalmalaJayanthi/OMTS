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
	
	public  Boolean addMovie(Movie movie, Integer theatreId) throws OMTSException;
	
	public  ArrayList<Movie> getMovieDetailsToDelete();
	
	public  int deleteMovie(Integer movieId);
	
	public  ArrayList<Theatre> getTheatreDetails(String theatreCity);
	
	public  Boolean addScreen(Screen screen, Integer theatreId);
	
	public  Boolean deleteScreen(Integer screenId);
	
	public abstract ArrayList<Screen> getScreenDetailsToDelete();
	
	
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


}
