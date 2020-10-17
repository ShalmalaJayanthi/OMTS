package com.cg.omts.dao;

import java.sql.SQLException;
import java.util.List;


import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public interface IUserDao {
	
	public Movie getMovieDetails(int movieId) throws OMTSException;
	
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException;
	
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException;
	
	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException;
	
	public int generateTicket(Ticket ticket) throws OMTSException;
	
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException;
	
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException;
	
	public int setTicketStatus(int ticketId, String status) throws OMTSException;	
	
	public int addTransaction(Transaction transaction, int ticketId) throws OMTSException;
	
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
	
	public Seat getSeatPrice(int screenId) throws OMTSException;
	
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException;
	
	public String getScreenName(int screenId) throws OMTSException;
	
	public String getShowName(int showId) throws OMTSException;

	List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException;

	Booking getBookingDetails(int ticketId) throws OMTSException;
	
	Booking getBookingById(int bookingId) throws OMTSException;
	
	int getTransactionIdByBookingId(int bookingId) throws OMTSException;
	
	int getTicketIdByBookingId(int bookingId) throws OMTSException;

	Ticket getTicket(int ticketId) throws OMTSException;

	boolean validatePayment(int accountNo, int cvv, String password) throws OMTSException;

	Seat seatAvailability(int seatId) throws OMTSException;

	List<Movie> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException;

	public List<Ticket> getTicketByIDS(List<Integer> ticketIdList) throws OMTSException;
	
	public List<Transaction> getTransactionByTicket(List<Integer> ticketIdList) throws OMTSException;
	
	public List<Booking> getBookingByUser(List<Transaction> transactionId) throws OMTSException;
	
	public int assignTicketToUser(int ticketId, int userId) throws OMTSException;

	public List<Integer> getTicketIdsByUser(int userId) throws OMTSException;

	public int deleteTicketFromUser(int ticketId) throws OMTSException;

	public List<String> getShowNamesByTheatre(List<Integer> theatreIdList) throws OMTSException;

	public List<String> getScreenNamesByTheatre(List<Integer> theatreIdList) throws OMTSException;

	public int getSeatsAvailable(int screenId) throws OMTSException;
	
	public Screen getScreen(int screenId) throws OMTSException;
}
