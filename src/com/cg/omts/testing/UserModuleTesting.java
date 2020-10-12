package com.cg.omts.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.Test;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Ticket;
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
			LocalDate localDate = LocalDate.of(2020, 10, 20);
			Date date = Date.valueOf(localDate);
			Movie expectedMovie = new Movie(1, "one", "comedy", "x", 2, "telugu", date);
			assertEquals(expectedMovie, actualMovie);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getTheatresByMovieTest() {
		
	}
	
	@Test
	public void getTheatreNamesTest() {
		
	}
	
	@Test
	public void generateTicketTest() throws OMTSException {
		try {
			Ticket ticket = new Ticket(1, 2, TicketStatus.BOOKED, 1, 1, 1, 1);
			int isGenerated = userService.generateTicket(1, ticket); 
			assertTrue(isGenerated > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	
}
