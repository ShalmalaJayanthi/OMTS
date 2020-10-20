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
	
	public Movie getMovieDetails(int movieId) throws OMTSException;//movie 17
	
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException;//movie 18
	
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException;//movie 19
	
	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException;//movie 20
	
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException;//booking
	
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException;//booking
	
	public int setTicketStatus(int ticketId, String status) throws OMTSException;//booking
	
	public int addTransaction(Transaction transaction, int ticketId) throws OMTSException;//booking
	
	public int addBooking(Booking booking, int ticketId, int transactionId) throws OMTSException;//booking
	
	public List<Integer> getTheatresByCity(String city) throws OMTSException;//movie 21
	
	public List<Movie> getAllMovies() throws OMTSException;//movie 22
	
	public int setSeatStatus(int seatId, String status) throws OMTSException;//booking
	
	public int deleteBookingDetails(int ticketId) throws OMTSException;//booking
	
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException;//booking
	
	public int deleteAllocatedSeats(int ticketId) throws OMTSException;//cancel
	
	public int deleteSeatDetails(List<Integer> seatList) throws OMTSException;//cancel
	
	public Transaction getTransactionDetails(int ticketId) throws OMTSException;//cancel
	
	public int deleteTransaction(int ticketId) throws OMTSException;//cancel
	
	public int cancelTicket(int ticketId) throws OMTSException;//cancel
	
	public int getCurrentBalance(Transaction transaction) throws OMTSException;//cancel
	
	public int refundAfterCancellation(Transaction transaction, int currentBalance) throws OMTSException;//cancel
	
	public Seat getSeatPrice(int screenId) throws OMTSException;//booking
	
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException;//booking
	
	public String getScreenName(int screenId) throws OMTSException;//booking
	
	public String getShowName(int showId) throws OMTSException;//booking

	List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException;//booking

	Booking getBookingDetails(int ticketId) throws OMTSException;//booking
	
	Booking getBookingById(int bookingId) throws OMTSException;//booking
	
	int getTransactionIdByBookingId(int bookingId) throws OMTSException;//booking
	
	int getTicketIdByBookingId(int bookingId) throws OMTSException;//booking

	Ticket getTicket(int ticketId) throws OMTSException;//booking

	boolean validatePayment(int accountNo, int cvv, String password) throws OMTSException;//booking

	Seat seatAvailability(int seatId) throws OMTSException;//booking

	List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException;//movie 23
	
	List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException;//movie 24

	
	
	
	//booking
	
	public List<Ticket> getTicketByIDS(List<Integer> ticketIdList) throws OMTSException;
	
	public List<Transaction> getTransactionByTicket(List<Integer> ticketIdList) throws OMTSException;//booking
	
	public List<Booking> getBookingByUser(List<Transaction> transactionId) throws OMTSException;
	
	public int assignTicketToUser(int ticketId, int userId) throws OMTSException;

	public List<Integer> getTicketIdsByUser(int userId) throws OMTSException;

	public int deleteTicketFromUser(int ticketId) throws OMTSException;

	public List<String> getShowNamesByTheatre(List<Integer> theatreIdList) throws OMTSException;

	public List<String> getScreenNamesByTheatre(List<Integer> theatreIdList) throws OMTSException;

	public int getSeatsAvailable(int screenId) throws OMTSException;
	
	public Screen getScreen(int screenId) throws OMTSException;

	public String getTheatreNames(int theatreId) throws OMTSException;//movie 25

	public int makePayment(int accountNo, int currentBalance, int totalCost) throws OMTSException;
}
