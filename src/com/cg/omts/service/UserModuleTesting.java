package com.cg.omts.service;

import static org.junit.Assert.assertEquals;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.Test;
import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;

public class UserModuleTesting {

	IUserService userService = new UserServiceImpl();
	
	@Test
	public void getMovieDetailsTest() throws OMTSException {
		
		Movie actualMovie = userService.getMovieDetails(1);
		LocalDate localDate = LocalDate.of(2020, 10, 20);
		Date date = Date.valueOf(localDate);
		Movie expectedMovie = new Movie(1, "one", "comedy", "x", 2, "telugu", date);
		assertEquals(expectedMovie, actualMovie);
		
	}
	
	@Test
	public void getTheatresByMovieTest() {
		
	}
	
}
