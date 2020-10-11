package com.cg.omts.dao;

import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.dto.Ticket;
import com.cg.omts.exceptions.OMTSException;

public interface IUserDao {

	
	
	public Movie getMovieDetails(int movieId) throws OMTSException;
	
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException;
	
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException;
	
	public int generateTicket(int ticketId, Ticket ticket) throws OMTSException;
	
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException;
	
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException;
	
	public int setTicketStatus(int ticketId, String status) throws OMTSException;	
	

	
	public List<Integer> getTheatresByCity(String city) throws OMTSException;
	
	public List<Movie> getAllMovies() throws OMTSException;

}
