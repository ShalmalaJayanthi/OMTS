package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.utility.DBConnection;

public class UserDaoImpl implements IUserDao{

	static Connection connection = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public Movie getMovieDetails(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		Movie movie = null;
		Boolean isFound = false;
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_MOVIE_DETAILS);
			prepareStatement.setInt(1, movieId);
			resultSet = prepareStatement.executeQuery();
			
			isFound = resultSet.next();
			if(isFound == true) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setMovieLength(resultSet.getInt(5));
				movie.setLanguage(resultSet.getString(6));
				movie.setMovieReleaseDate(resultSet.getDate(7));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object");
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}

		}
		return movie;
	}
	
	@Override
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		List<Integer> theatreIdList = new ArrayList<Integer>();
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATRES_BY_MOVIE);
			prepareStatement.setInt(1, movieId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				theatreIdList.add(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		
		return theatreIdList;
	}

	@Override
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<String> theatreNamesList = new ArrayList<String>();
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATRE_NAME_BY_ID);
			
			for(Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
				resultSet = prepareStatement.executeQuery();
					while(resultSet.next()) {
						theatreNamesList.add(resultSet.getString(1));
					}
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		return theatreNamesList;
	}	
	
	@Override
	public List<Movie> getAllMovies() throws OMTSException{
		List<Movie> movieList = new ArrayList<Movie>();
		Movie movie = null;
		try {
			connection =  DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_ALL_MOVIES);
			resultSet = prepareStatement.executeQuery();	
			
			while(resultSet.next()) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setMovieLength(resultSet.getInt(5));
				movie.setLanguage(resultSet.getString(6));
				movie.setMovieReleaseDate(resultSet.getDate(7));
				movieList.add(movie);
				
			}	
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return movieList;
	}
	
	@Override
	public List<Integer> getTheatresByCity(String city) throws OMTSException {
		List<Integer> theatreIdList = new ArrayList<Integer>();

		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATREID);
			prepareStatement.setString(1, city);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				theatreIdList.add(resultSet.getInt(1));
			}
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return theatreIdList;			
	}	
	
	@Override
	public int generateTicket(int userId, Ticket ticket) throws OMTSException {
		// TODO Auto-generated method stub
		int isGenerated = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GENERATE_TICKET);   
			prepareStatement.setInt(1, userId);  
			prepareStatement.setInt(2,ticket.getTicketId()); 
			prepareStatement.setInt(3, ticket.getNoOfSeats());
			prepareStatement.setInt(4, ticket.getScreenId());
			prepareStatement.setInt(5, ticket.getTheatreId());
			prepareStatement.setInt(6, ticket.getShowId());
			prepareStatement.setInt(7, ticket.getMovieId());
			isGenerated = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
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
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		int isAllocated = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.ALLOCATE_SEATS);   
			for(Integer selectedSeat : selectedSeatsList) {
				prepareStatement.setInt(1, selectedSeat);
				prepareStatement.setString(2, "BLOCKED");
				prepareStatement.setInt(3, screenId);
				isAllocated = prepareStatement.executeUpdate();  
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isAllocated;
	}

	@Override
	public int setTicketStatus(int ticketId, String status) throws OMTSException {
		// TODO Auto-generated method stub
		int isUpdated = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.SET_TICKET_STATUS);   
			prepareStatement.setString(1, status);
			prepareStatement.setInt(2, ticketId);
			isUpdated = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isUpdated;
	}

	@Override
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException {
		// TODO Auto-generated method stub
		int isAssigned = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.ASSIGN_SEATS_TO_TICKET);   
			for(Integer seat : seatsList) {
				prepareStatement.setInt(1, ticketId);
				prepareStatement.setInt(2, seat);
				isAssigned = prepareStatement.executeUpdate();  
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isAssigned;
	}

	@Override
	public int addTransaction(Transaction transaction, int ticketId, int userId) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.ADD_TRANSACTION);   
			prepareStatement.setInt(1, transaction.getTransactionId());  
			prepareStatement.setInt(2, userId); 
			prepareStatement.setInt(3, transaction.getAccountNumber());
			prepareStatement.setInt(4, transaction.getTotalAmount());
			prepareStatement.setInt(5, ticketId);
			isInserted = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem in PS statement");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isInserted;
	}

	@Override
	public int addBooking(Booking booking, int ticketId, int transactionId) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.ADD_BOOKING);   
			prepareStatement.setInt(1, booking.getBookingId());  
			prepareStatement.setDate(2, booking.getBookingDate()); 
			prepareStatement.setInt(3, ticketId);
			prepareStatement.setInt(4, transactionId);
			isInserted = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isInserted;
	}

	@Override
	public int setSeatStatus(int seatId, String status) throws OMTSException {
		// TODO Auto-generated method stub
		int isUpdated = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.SET_SEAT_STATUS);   
			prepareStatement.setString(1, status);
			prepareStatement.setInt(2, seatId);
			isUpdated = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isUpdated;
	}
		
	@Override
	public int deleteBookingDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.DELETE_BOOKING_DETAILS);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}

	@Override
	public  List<Integer> getSeatsByTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		List<Integer> seatList = new ArrayList<>();

		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_SEATS);
			prepareStatement.setInt(1, ticketId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				seatList.add(resultSet.getInt(1));
			}
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return seatList;	
	}

	@Override
	public int deleteAllocatedSeats(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.DELETE_ALLOCATED_SEATS);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}

	@Override
	public int deleteSeatDetails(List<Integer> seatList) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.DELETE_SEATS);   
			for(Integer seat : seatList) {
				prepareStatement.setInt(1, seat);
				isDeleted = prepareStatement.executeUpdate();  
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}

	@Override
	public Transaction getTransactionDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Boolean isFound = false;
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_TRANSACTION_DETAILS);
			prepareStatement.setInt(1, ticketId);
			resultSet = prepareStatement.executeQuery();
			
			isFound = resultSet.next();
			if(isFound == true) {
				transaction = new Transaction();
				transaction.setTransactionId(resultSet.getInt(1));
				transaction.setAccountNumber(resultSet.getInt(2));
				transaction.setTotalAmount(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object" + e.getMessage());
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}

		}
		return transaction;
	}

	@Override
	public int deletetransaction(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.DELETE_TRANSACTION);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}

	@Override
	public int cancelTicket(int ticketId) throws OMTSException {
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.DELETE_TICKET);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}
	
	@Override
	public int getCurrentBalance(Transaction transaction) throws OMTSException {
		// TODO Auto-generated method stub
		int currentBalance = 0;
		Boolean isFound = false;
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_CURRENT_BALANCE);
			prepareStatement.setInt(1, transaction.getAccountNumber());
			resultSet = prepareStatement.executeQuery();
			
			isFound = resultSet.next();
			if(isFound == true) {
				currentBalance = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object");
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}

		}
		return currentBalance;
	}
	
	@Override
	public int refundAfterCancellation(Transaction transaction, int currentBalance) throws OMTSException {
		// TODO Auto-generated method stub
		int isUpdated = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.REFUND_AMOUNT);   
			prepareStatement.setInt(1, transaction.getTotalAmount()+currentBalance);
			prepareStatement.setInt(2, transaction.getAccountNumber());
			isUpdated = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isUpdated;
	}
	

	public static void main(String[] args) throws OMTSException { 
		/*
		 * Ticket ticket = new Ticket(); ticket.setTicketId(1); ticket.setNoOfSeats(1);
		 * ticket.setScreenId(1); ticket.setMovieId(1); ticket.setShowId(1);
		 * ticket.setTheatreId(1);
		 */
		
		/*
		 * List<Integer> selectedSeatsList = new ArrayList<Integer>();
		 * selectedSeatsList.add(1); selectedSeatsList.add(2); selectedSeatsList.add(3);
		 * selectedSeatsList.add(4);
		 */
		
		
		/*
		 * Transaction transaction = new Transaction();
		 * transaction.setAccountNumber(789794578); transaction.setTotalAmount(900);
		 * transaction.setTransactionId(2);
		 * System.out.println(addTransaction(transaction, 1, 1));
		 */
		
		/*
		 * LocalDate localDate = LocalDate.of(2020, 10, 10); Date date =
		 * Date.valueOf(localDate);
		 * 
		 * Booking booking = new Booking(); booking.setBookingId(1);
		 * booking.setBookingDate(date); System.out.println(addBooking(booking, 1, 1));
		 * System.out.println(setTicketStatus(1, "BOOKED"));
		 */
		
//		System.out.println("Deleting booking details in booking table : "+ deleteBookingDetails(1));
//		List<Integer> seatList = getSeatsByTicket(1);
//		System.out.println("Deleting allocated seats in ticketseats table : "+deleteAllocatedSeats(1));
//		System.out.println("Deleting seats in seat table : "+deleteSeatDetails(seatList));
		
//		Transaction transaction = getTransactionDetails(1);
//		System.out.println("Deleting transaction in transaction table : "+deletetransaction(1));
//		
//		Transaction transaction = new Transaction();
//		transaction.setAccountNumber(123456);
//		transaction.setTotalAmount(12300);
//		int currentBal = getCurrentBalance(transaction);
//		System.out.println("Current Balance in account : " + currentBal);
//		System.out.println("Cancelling ticket : " + cancelTicket(1));
//		System.out.println("Refunding amount : "+ refundAfterCancellation(transaction, currentBal));
//		
	}
	
}
