package com.cg.omts.service;

import java.util.ArrayList;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public interface IMovieTheatreService {
	
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
	
}
