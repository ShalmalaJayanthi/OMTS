package com.cg.omts.dao;

import java.sql.Connection; 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Seat.SeatStatus;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Ticket.TicketStatus;
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
			throw new OMTSException("problem while creating PS object"+e.getMessage());
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
			throw new OMTSException("problem occured while creating PS object"+e.getMessage());
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
	public List<Movie> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		List<Movie> movieListBasedonCity = new ArrayList<>();
		Movie movie = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_MOVIES_BY_THEATRE_ID);
			for(Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
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
						movieListBasedonCity.add(movie);
					}
			}
		} catch(SQLException e) {
			throw new OMTSException("Problem occured while creating PS objetc");
		}
		finally {
			try {
				connection.close();
			} catch(SQLException e) {
				throw new OMTSException("Problem occured while closing connection");
			}
		}
		
		return movieListBasedonCity;
	}
	
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
			throw new OMTSException("problem while creating PS object"+e.getMessage());
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
	public int addTransaction(Transaction transaction, int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.ADD_TRANSACTION);   
			prepareStatement.setInt(1, transaction.getTransactionId());   
			prepareStatement.setInt(2, transaction.getAccountNumber());
			prepareStatement.setInt(3, transaction.getTotalAmount());
			prepareStatement.setInt(4, ticketId);
			isInserted = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem in PS statement"+e.getMessage());
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
			throw new OMTSException("problem while creating PS object"+e.getMessage());
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
	public int deleteTransaction(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.DELETE_TRANSACTION);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object"+e.getMessage());
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
			throw new OMTSException("problem while creating PS object"+e.getMessage());
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
	@Override
	public Seat getSeatPrice(int screenId) throws OMTSException{
		Seat seat = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_SCREENSEATPRICE_BY_SCREENID);
			prepareStatement.setInt(1, screenId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				seat = new Seat();
				seat.setSeatPrice(resultSet.getDouble(1));
			}
			
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object"+e.getMessage());
		}
		finally {
			try {
				
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		
		return seat;
		
	}
	@Override
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException {
		List<Screen> screenList = new ArrayList<>();
		Screen screen = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_SCREEN_BY_THEATRE_ID);
			prepareStatement.setInt(1, theatreId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				screen = new Screen();
				screen.setScreenId(resultSet.getInt(1));
				screen.setTheatreId(resultSet.getInt(2));
				screen.setScreenName(resultSet.getString(3));
				screen.setRows(resultSet.getInt(4));
				screen.setColumns(resultSet.getInt(5));
				screenList.add(screen);
			}
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally{
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing the connection");
			}
		}
		return screenList;	
	}
	@Override
	public List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException {
	List<Show> showList = new ArrayList<Show>();
	Show show = null;
	try {
		connection = DBConnection.getConnection();
		prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_SHOWS_BY_MOVIE_THEATRE);
		prepareStatement.setInt(1, screenId);
		prepareStatement.setInt(2, theatreId);
		prepareStatement.setInt(3, movieId);
		resultSet = prepareStatement.executeQuery();
		while(resultSet.next()) {
			show = new Show();
			show.setShowId(resultSet.getInt(1));
			show.setShowStartTime(resultSet.getTime(2));
			show.setShowEndTime(resultSet.getTime(3));
			show.setShowName(resultSet.getString(4));
			show.setMovieName(resultSet.getString(5));
			showList.add(show);
		}
	} catch(SQLException e) {
		throw new OMTSException("problem occured while creating PS object"+e.getMessage());
	}
	finally{
		try {
			connection.close();
		}catch(SQLException e) {
			throw new OMTSException("problem occured while closing the connection");
		}
	}
	return showList;	
	}
	@Override
	public Booking getBookingDetails(int ticketId) throws OMTSException {
		Booking booking = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_BOOKING_DETAILS);
			prepareStatement.setInt(1, ticketId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				booking = new Booking();
				booking.setBookingId(resultSet.getInt(1));
				booking.setBookingDate(resultSet.getDate(2));
			}
		} catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally{
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing the connection");
			}
		}
		return booking;	
	}
	@Override
	
	public boolean validatePayment(int accountNo,int cvv,String password) throws OMTSException {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
		connection = DBConnection.getConnection();
		prepareStatement = connection.prepareStatement(IUserQueryConstants.VALIDATE_PAYMENT);
		prepareStatement.setInt(1, accountNo);
		resultSet = prepareStatement.executeQuery();
		while(resultSet.next()) {
		
			int CVV=resultSet.getInt(1);
			String PASS=resultSet.getString(2);
			if(cvv==CVV && password.equals(PASS))
				flag=true;
			else
				flag=false;
			
		}
		}
		catch(SQLException e)
		{
			throw new OMTSException(e.getMessage());
		}
		return flag;
	}

	
	@Override
	public Seat seatAvailability(int seatId) throws OMTSException {
		
		Seat seat = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.SEAT_AVAILABILITY);
			prepareStatement.setInt(1, seatId);
			resultSet = prepareStatement.executeQuery();
			String seatStatus;
			if(resultSet.next()) {
				seat = new Seat();
				seat.setSeatId(seatId);
				//seat.setSeatPrice(resultSet.getDouble(1));
				seatStatus = resultSet.getString(1);
				seat.setBookingState(SeatStatus.valueOf(seatStatus));
				
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
		
		return seat;
		
	}

	@Override
	public Ticket getTicket(int ticketId) throws OMTSException {
		Ticket ticket = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_TICKET);
			prepareStatement.setInt(1, ticketId);
			resultSet = prepareStatement.executeQuery();
			String status="";
			TicketStatus ticketStatus;
			while(resultSet.next()) {
				ticket = new Ticket();
				int noOfSeats=resultSet.getInt(1);
				status = resultSet.getString(2);
				ticketStatus= TicketStatus.valueOf(status); 
				int screenId =resultSet.getInt(3);
				int theatreId = resultSet.getInt(4);
				int showId = resultSet.getInt(5);
				int movieId = resultSet.getInt(6);
				ticket.setTicketId(ticketId);
				ticket.setNoOfSeats(noOfSeats);
				ticket.setTicketStatus(ticketStatus);
				ticket.setScreenId(screenId);
				ticket.setTheatreId(theatreId);
				ticket.setShowId(showId);
				ticket.setMovieId(movieId);
				
				
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
		
		return ticket;
		
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

	@Override
	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<Theatre> theatresList = new ArrayList<Theatre>();
		Theatre theatre = null;
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATRE_BY_ID);
			
			for(Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
				resultSet = prepareStatement.executeQuery();
					while(resultSet.next()) {
						theatre = new Theatre();
						theatre.setTheatreId(resultSet.getInt(1));
						theatre.setTheatreName(resultSet.getString(2));
						theatre.setTheatreCity(resultSet.getString(3));
						theatre.setManagerName(resultSet.getString(4));
						theatre.setManagerContact(resultSet.getString(5));
						theatresList.add(theatre);
					}
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		return theatresList;
	}

	@Override
	public String getScreenName(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		String screenName = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_SCREEN_NAME);
			prepareStatement.setInt(1, screenId);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				screenName = resultSet.getString(1);
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
		
		return screenName;
	}

	@Override
	public String getShowName(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		String showName = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_SHOW_NAME);
			prepareStatement.setInt(1, showId);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				showName = resultSet.getString(1);
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
		return showName;
	}


	public static boolean checkTicket() throws SQLException, OMTSException {
		// TODO Auto-generated method stub
		boolean isFound = false;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.CHECK_TICKET);
		
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				isFound = true;
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
		return isFound;
	}

	
	public static int getMaxTicketId() throws SQLException, OMTSException {
		// TODO Auto-generated method stub
		int maxTicId = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.MAX_TICKET_ID);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				maxTicId = resultSet.getInt(1);
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
		return maxTicId;
	}

	public static boolean checkSeat() throws SQLException, OMTSException {
		// TODO Auto-generated method stub
		boolean isFound = false;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.CHECK_SEAT);
		
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				isFound = true;
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
		return isFound;
	}
	public static boolean checkBooking() throws SQLException, OMTSException {
		// TODO Auto-generated method stub
		boolean isFound = false;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.CHECK_BOOKING);
		
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				isFound = true;
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
		return isFound;
	}
	public static int getMaxSeatId() throws OMTSException {
		// TODO Auto-generated method stub
		int maxSeatId = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.MAX_SEAT_ID);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				maxSeatId = resultSet.getInt(1);
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
		return maxSeatId;
	}
	public static int getMaxBookingId() throws OMTSException {
		// TODO Auto-generated method stub
		int maxBookingId = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.MAX_BOOKING_ID);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				maxBookingId = resultSet.getInt(1);
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
		return maxBookingId;
	}

	@Override
	public Booking getBookingById(int bookingId) throws OMTSException {
		// TODO Auto-generated method stub
		
		Booking booking = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_BOOKING_BY_ID);
			prepareStatement.setInt(1, bookingId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				booking = new Booking();
				booking.setBookingId(resultSet.getInt(1));
				booking.setBookingDate(resultSet.getDate(2));
				
			}
		} catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally{
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing the connection");
			}
		}
		return booking;	
	}

	@Override
	public int getTransactionIdByBookingId(int bookingId) throws OMTSException {
		// TODO Auto-generated method stub
		int transactionId = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_TRANSACTION_ID);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				transactionId = resultSet.getInt(1);
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
		return transactionId;
	}

	@Override
	public int getTicketIdByBookingId(int bookingId) throws OMTSException {
		// TODO Auto-generated method stub
		int ticketId = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_TICKET_ID);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				ticketId = resultSet.getInt(1);
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
		return ticketId;
	}

	@Override
	public List<Ticket> getTicketByIDS(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<Ticket> ticketList = new ArrayList<Ticket>();
		
		Ticket ticket = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_TICKET_BY_ID);
						
				for(Integer ticketId : ticketIdList) {
					prepareStatement.setInt(1, ticketId);
					resultSet = prepareStatement.executeQuery();
					String status="";
					TicketStatus ticketStatus;
						while(resultSet.next()) {
							ticket = new Ticket();
							ticket.setTicketId(resultSet.getInt(1));
							ticket.setNoOfSeats(resultSet.getInt(2));
							status = resultSet.getString(3);
							System.out.println(status);
							ticketStatus= TicketStatus.valueOf(status); 
							int screenId =resultSet.getInt(4);
							ticket.setTicketStatus(ticketStatus);
							ticket.setScreenId(screenId);
							ticket.setTheatreId(resultSet.getInt(5));
							ticket.setShowId(resultSet.getInt(6));
							ticket.setMovieId(resultSet.getInt(7));
							ticketList.add(ticket);
						}
				}
		} catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object"+e.getMessage());
		}
		finally{
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing the connection");
			}
		}
		
		return ticketList;
		
	}

	@Override
	public List<Transaction> getTransactionByTicket(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<Transaction> transactionList = new ArrayList<Transaction>();
		
		Transaction transaction = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_TRANSACTION_BY_TICKET);
			for(Integer ticketId : ticketIdList) {
				prepareStatement.setInt(1, ticketId);
				resultSet = prepareStatement.executeQuery();
			
		
				while(resultSet.next()) {
					transaction = new Transaction();
					transaction.setTransactionId(resultSet.getInt(1));
					transaction.setAccountNumber(resultSet.getInt(2));
					transaction.setTotalAmount(resultSet.getInt(3));
				
					transactionList.add(transaction);
				}
			}
		} catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object"+e.getMessage());
		}
		finally{
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing the connection");
			}
		}
		return transactionList;
	}

	@Override
	public List<Booking> getBookingByUser(List<Transaction> transactionIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<Booking> bookingList = new ArrayList<Booking>();
		Booking booking = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_BOOKING_BY_TRANSACTION);   
			for(Transaction transaction : transactionIdList) {
				prepareStatement.setInt(1, transaction.getTransactionId());
				resultSet = prepareStatement.executeQuery();
				while(resultSet.next()) {
					booking = new Booking();
					booking.setBookingId(resultSet.getInt(1));
					booking.setBookingDate(resultSet.getDate(2));
					bookingList.add(booking);
					
				}
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
		return bookingList;

	}

	@Override
	public int assignTicketToUser(int ticketId, int userId) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.ADD_TICKET_TO_USER);   
			
			prepareStatement.setInt(1, userId);  
			prepareStatement.setInt(2, ticketId); 
			
			isInserted = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object"+e.getMessage());
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
	public List<Integer> getTicketIdsByUser(int userId) throws OMTSException {
		// TODO Auto-generated method stub
		List<Integer> ticketIdList = new ArrayList<Integer>();
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_TICKET_IDS);
			prepareStatement.setInt(1, userId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				ticketIdList.add(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		
		return ticketIdList;
	}

	@Override
	public int deleteTicketFromUser(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.DELETE_FROM_USER);   
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
	public List<String> getShowNamesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<String> showNameList = new ArrayList<String>();
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_SHOWNAME_BY_THEATREID);
			
			
			for(Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
				resultSet = prepareStatement.executeQuery();
				while(resultSet.next()) {
					showNameList.add(resultSet.getString(1));
				}
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object" + e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return showNameList;
	}

	@Override
	public List<String> getScreenNamesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<String> screenNameList = new ArrayList<String>();
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_SCREENNAME_BY_THEATREID);
			
			
			for(Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
				resultSet = prepareStatement.executeQuery();
				while(resultSet.next()) {
					screenNameList.add(resultSet.getString(1));
				}
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
		return screenNameList;
	}

	@Override
	public int getSeatsAvailable(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		int noOfSeats = 0;
		
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_AVAILABLE_SEATS);
			
			prepareStatement.setInt(1, screenId);  
			resultSet =  prepareStatement.executeQuery();  
			if(resultSet.next()) {
				noOfSeats = resultSet.getInt(1);
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return noOfSeats;

	}

	@Override
	public Screen getScreen(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		Screen screen = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_SCREEN_BY_ID);
			prepareStatement.setInt(1, screenId);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				screen = new Screen();
				screen.setRows(resultSet.getInt(1));
				screen.setColumns(resultSet.getInt(2));
			
			}
		} catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally{
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing the connection");
			}
		}
		return screen;	
	}

	@Override
	public String getTheatreNames(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		String theatreName = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATRE_NAME);
			prepareStatement.setInt(1, theatreId);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				theatreName = resultSet.getString(1);
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
		
		return theatreName;
	}

	@Override
	public int makePayment(int accountNo, int currentBalance, int totalCost) throws OMTSException {
		// TODO Auto-generated method stub
		int isUpdated = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.DEDUCT_AMOUNT); 
			prepareStatement.setInt(1, currentBalance-totalCost);
			prepareStatement.setInt(2, accountNo);
			isUpdated = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isUpdated;
	}
}
