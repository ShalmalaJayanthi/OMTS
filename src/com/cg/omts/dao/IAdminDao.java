package com.cg.omts.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;


public interface IAdminDao {
	
	public List<Theatre> getTheatreDetails() throws OMTSException;
	
	public  int addTheatre(Theatre theatre) throws OMTSException;

	public int deleteTheatre(int theatreId) throws OMTSException;
	
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException;
	
	public List<Show> getShowDetails() throws OMTSException;
	
	public int addShow(Show show) throws OMTSException;
	
	public int deleteShow(int showId) throws OMTSException;
	
	public List<Show> getShowByName() throws OMTSException;
	
	public Boolean addMovie(Movie movie, Integer theatreId) throws OMTSException;
	
	public  ArrayList<Movie> getMovieDetailsToDelete();
	
	public  int deleteMovie(Integer movieId);
	
	public  ArrayList<Theatre> getTheatreDetails(String theatreCity);
	
	public  Boolean addScreen(Screen screen, Integer theatreId);
	
	public  Boolean deleteScreen(Integer screenId);
	
	public  ArrayList<Screen> getScreenDetailsToDelete();
}
