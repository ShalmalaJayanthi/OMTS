package com.cg.omts.dao;

import java.util.List;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public interface IUserDao {
	
	public Movie getMovieDetails(int movieId) throws OMTSException;
	
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException;
	
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException;
	
	public int generateTicket(int ticketId, Ticket ticket) throws OMTSException;
	
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException;
	
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException;
	
	public int setTicketStatus(int ticketId, String status) throws OMTSException;	
	
	public int addTransaction(Transaction transaction, int ticketId, int userId) throws OMTSException;
	
	public int addBooking(Booking booking, int ticketId, int transactionId) throws OMTSException;
	
	public List<Integer> getTheatresByCity(String city) throws OMTSException;
	
	public List<Movie> getAllMovies() throws OMTSException;
	
	public int setSeatStatus(int seatId, String status) throws OMTSException;
	
	public int deleteBookingDetails(int ticketId) throws OMTSException;
	
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException;
	
	public int deleteAllocatedSeats(int ticketId) throws OMTSException;
	
	public int deleteSeatDetails(List<Integer> seatList) throws OMTSException;
	
	public Transaction getTransactionDetails(int ticketId) throws OMTSException;
	
	public int deleteTransaction(int ticketId) throws OMTSException;
	
	public int cancelTicket(int ticketId) throws OMTSException;
	
	public int getCurrentBalance(Transaction transaction) throws OMTSException;
	
	public int refundAfterCancellation(Transaction transaction, int currentBalance) throws OMTSException;
	
	public Seat getSeatPrice(int seatId) throws OMTSException;
	
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException;

	List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException;

	Booking getBookingDetails(int ticketId) throws OMTSException;

}
