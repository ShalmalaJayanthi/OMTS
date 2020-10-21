package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.utility.DBConnection;

public class BookingDaoImpl implements IBookingDao{

	static Connection connection = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public int generateTicket(Ticket ticket) throws OMTSException {
		// TODO Auto-generated method stub
		int isGenerated = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GENERATE_TICKET);    
			prepareStatement.setInt(1, ticket.getTicketId()); 
			prepareStatement.setInt(2, ticket.getNoOfSeats());
			prepareStatement.setInt(3, ticket.getScreenId());
			prepareStatement.setInt(4, ticket.getTheatreId());
			prepareStatement.setInt(5, ticket.getShowId());
			prepareStatement.setInt(6, ticket.getMovieId());
			isGenerated = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isGenerated;
	}

	@Override
	public List<Ticket> getTicketByIDS(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getTransactionByTicket(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingByUser(List<Transaction> transactionId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int assignTicketToUser(int ticketId, int userId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getTicketIdsByUser(int userId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteTicketFromUser(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getShowNamesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getScreenNamesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSeatsAvailable(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Screen getScreen(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int makePayment(int accountNo, int currentBalance, int totalCost) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Seat getSeatPrice(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getScreenName(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShowName(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking getBookingDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking getBookingById(int bookingId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTransactionIdByBookingId(int bookingId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTicketIdByBookingId(int bookingId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ticket getTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validatePayment(int accountNo, int cvv, String password) throws OMTSException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Seat seatAvailability(int seatId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setSeatStatus(int seatId, String status) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBookingDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setTicketStatus(int ticketId, String status) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addTransaction(Transaction transaction, int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addBooking(Booking booking, int ticketId, int transactionId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}


}
