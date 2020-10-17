package com.cg.omts.testing;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IUserService;
import com.cg.omts.service.UserServiceImpl;
import static com.cg.omts.dto.Ticket.TicketStatus;

public class UserModuleTesting {

	IUserService userService = new UserServiceImpl();
	
	@Test
	public void getMovieDetailsTest() throws OMTSException {
		try {
			Movie actualMovie = userService.getMovieDetails(1);
			assertNotNull(actualMovie);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void generateTicketTest() throws OMTSException {
		try {
			Ticket ticket = new Ticket(1, 2, TicketStatus.BOOKED, 1, 1, 1, 1);
			int isGenerated = userService.generateTicket(ticket); 
			assertTrue(isGenerated > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void allocateSeatTest() throws OMTSException {
		try {
			int screenId = 1;
			List<Integer> selectedSeatsList = new ArrayList<Integer>();
			selectedSeatsList.add(1);
			selectedSeatsList.add(2);
			selectedSeatsList.add(3);
			selectedSeatsList.add(4);
			
			int isAllocated = userService.allocateSeat(selectedSeatsList, screenId);
			assertTrue(isAllocated > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void assignSeatsToTicketsTest() throws OMTSException {
		try {
			int ticketId = 1;
			List<Integer> seatsList = new ArrayList<Integer>();
			seatsList.add(1);
			seatsList.add(2);
			seatsList.add(3);
			seatsList.add(4);
			
			int isAssigned = userService.assignSeatsToTickets(ticketId, seatsList);
			assertTrue(isAssigned > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	

	
	@Test
	public void  getSeatsByTicketTest() throws OMTSException {
		try {
			int ticketId = 1;
			List<Integer> expectedSeatsList = new ArrayList<Integer>();
			expectedSeatsList.add(1);
			expectedSeatsList.add(2);
			expectedSeatsList.add(3);
			expectedSeatsList.add(4);
			
			List<Integer> actualSeatsList = userService.getSeatsByTicket(ticketId);
			assertEquals(expectedSeatsList, actualSeatsList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	
	
	@Test
	public void getTransactionDetailsTest() throws OMTSException {
		try {
			int ticketId = 1;
			//Transaction actualTransaction = new Transaction(1, 123456, 900);
			
			Transaction expectedTransaction = userService.getTransactionDetails(ticketId);
			assertNotNull(expectedTransaction);
			
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteBookingDetailsTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isDeleted = userService.deleteBookingDetails(ticketId);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}	
	
	@Test
	public void deleteTransactionTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isDeleted = userService.deleteTransaction(ticketId);
			System.out.println(isDeleted);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteAllocatedSeatsTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isDeleted = userService.deleteAllocatedSeats(ticketId);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteSeatDetailsTest() throws OMTSException {
		try {
			List<Integer> seatsList = new ArrayList<Integer>();
			seatsList.add(1);
			seatsList.add(2);
			seatsList.add(3);
			seatsList.add(4);
			
			int isDeleted = userService.deleteSeatDetails(seatsList);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void cancelTicketTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isCancelled = userService.cancelTicket(ticketId);
			assertTrue(isCancelled > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getCurrentBalanceTest() throws OMTSException {
		try {
			Transaction transaction = new Transaction(1, 123456, 900);
						
			int currentBalance = userService.getCurrentBalance(transaction);
			assertTrue(currentBalance > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void refundAfterCancellationTest() throws OMTSException {
		try {
			Transaction transaction = new Transaction(1, 123456, 900);
			int currentBalance = 24600;
			int isCancelled = userService.refundAfterCancellation(transaction, currentBalance);
			assertTrue(isCancelled > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getTheatresByMovieTest() throws OMTSException {
		int movieId=1;
		try {
		List<Integer> expectedTheatreList = new ArrayList<Integer>();
		expectedTheatreList.add(1);
		List<Integer> actualTheatreList = userService.getTheatresByMovie(movieId);
		assertEquals(expectedTheatreList,actualTheatreList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getTheatreNamesTest() throws OMTSException {
		try {
		List<Integer> theatreIdList = new ArrayList<Integer>();
		theatreIdList.add(1);
		List<String> expectedTheatreIdList = new ArrayList<String>();
		expectedTheatreIdList.add("vimal");
		List<String> actualTheatreIdList = userService.getTheatreNames(theatreIdList);
		assertEquals(expectedTheatreIdList,actualTheatreIdList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
		
	}
	
	@Test
	public void setTicketStatusTest() throws OMTSException{
		try {
			int ticketId=1;
			String status="BOOKED";
			int expected = 1;
			int actual = userService.setTicketStatus(ticketId, status);
			assertEquals(expected, actual);
			
			
		}catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void addTransactionTest() throws OMTSException {
		try {
			Transaction transaction = new Transaction(3,934784,1890);
			int ticketId = 3;
			int userId=3;
			int actual = userService.addTransaction(transaction, ticketId);
			assertTrue(actual > 0);
		}catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void addBookingTest() throws OMTSException {
		try {
			int ticketId=3;
			int transactionId=3;
			LocalDate localDate = LocalDate.of(2004, 10, 12);
			Date date = Date.valueOf(localDate);
			Booking booking = new Booking(3,date);
			int addBooking = userService.addBooking(booking, ticketId, transactionId);
			assertTrue(addBooking>0);
			
		}catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void setSeatStatusTest() throws OMTSException {
		try {
		int seatId=1;
		String status="BOOKED";
		int actual = userService.setSeatStatus(seatId, status);
		assertTrue(actual > 0);
		} catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	
	@Test
	public void validatePaymentTest() throws OMTSException{
		boolean validate=true;
		try {
			boolean result =userService.validatePayment(123456, 662, "Ashu");
			assertEquals(validate,result);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void seatAvailabiltyTest() throws OMTSException {
		try {
			int seatId = 1;

			Seat actual = userService.seatAvailability(seatId);

			assertNotNull(actual);

		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	@Test
	public void getTicketTest() throws OMTSException{
		try {
			int ticketId=1;
			Ticket actual = userService.getTicket(ticketId);
			assertNotNull(actual);
		}catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	
}
