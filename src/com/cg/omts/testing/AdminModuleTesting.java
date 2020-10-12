package com.cg.omts.testing;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;

public class AdminModuleTesting {

	IAdminService adminService = new AdminServiceImpl();
	
	@Test
	public void getTheatreDetailsTest() throws OMTSException{
		List<Theatre> theatreList = adminService.getTheatreDetails();
		boolean actualTheatreList = false;
		if(theatreList.size()>0) {
			actualTheatreList = true;
		}
		boolean expectedTheatreList = true;
		assertEquals(expectedTheatreList, actualTheatreList);
	}
	
	@Test
	public void addTheatreTest() throws OMTSException {
		Theatre theatre = new Theatre();
		theatre.setTheatreId(21239);
		theatre.setTheatreName("Glitz");
		theatre.setTheatreCity("Bangkok");
		theatre.setManagerName("Gokkun");
		theatre.setManagerContact("9033332216");
		int rowsInserted = adminService.addTheatre(theatre);
		boolean actualRowsInserted = false;
		if(rowsInserted!=0) {
			actualRowsInserted = true;
		}
		boolean expectedRowsInserted = true;
		assertEquals(expectedRowsInserted, actualRowsInserted);
	}
	
	@Test
	public void addTheatreTest2(){
		Theatre theatre = new Theatre();
		theatre.setTheatreId(21239);
		theatre.setTheatreName("Charm");
		theatre.setTheatreCity("Singapore");
		theatre.setManagerName("Zen Lee");
		theatre.setManagerContact("9444402216");
		try {
			int noRowsInserted = adminService.addTheatre(theatre);
			Assert.fail("Duplicate entry for Theatre id");
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteTheatreTest() throws OMTSException {
		int theatreId = 2777;
		int rowsDeleted = adminService.deleteTheatre(theatreId);
		boolean actualRowsDeleted = false;
		if(rowsDeleted != 0 ) {
			actualRowsDeleted = true;
		}
		boolean expectedRowsDeleted = true;
		assertEquals(expectedRowsDeleted,actualRowsDeleted);
	}
	@Test
	public void deleteTheatreTest2() throws OMTSException {
		int theatreId = 2343;
		try {
			int noRowsDeleted = adminService.deleteTheatre(theatreId);
			//Assert.fail("Cannot find the theatre to delete");
		} catch(OMTSException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getTheatreByNameTest() throws OMTSException {
		String theatreName = "Delhi";
		List<Theatre> theatreList = adminService.getTheatreByName(theatreName);
		boolean actualTheatreList = false;
		if(theatreList.size()>0) {
			actualTheatreList = true;
		}
		boolean expectedTheatreList = true;
		assertEquals(expectedTheatreList, actualTheatreList);
	}
	
	@Test
	public void getShowDetails() throws OMTSException {
		List<Show> showList = adminService.getShowDetails();
		boolean actualShowList = false;
		if(showList.size()>0) {
			actualShowList = true;
		}
		boolean expectedShowList = false;
		assertEquals(expectedShowList, actualShowList);
	}
	
	@Test
	public void addShowTest() throws OMTSException, ParseException {
		int rowsInserted = 0;
		Show show = new Show();
		show.setShowId(64434255);
		java.util.Date startTime = new SimpleDateFormat("hh:mm").parse("08:00:00"); 
		java.sql.Time showStartTime =  new java.sql.Time(startTime.getTime());
		java.util.Date endTime = new SimpleDateFormat("hh:mm").parse("10:00:00");
		//System.out.println(endTime); 
		java.sql.Time showEndTime =  new java.sql.Time(endTime.getTime());
		show.setShowStartTime(showStartTime);
		show.setShowEndTime(showEndTime);
		show.setShowName("Morning");
		show.setScreenId(42521239);
		show.setTheatreId(21239);
		show.setMovieId(34563);
		rowsInserted = adminService.addShow(show);
		boolean actualRowsInserted = false;
		if(rowsInserted > 0) {
			actualRowsInserted = true;
		}
		boolean expectedRowsInserted = false;
		assertEquals(expectedRowsInserted, actualRowsInserted);
	}
	
	@Test
	public void deleteShowTest() throws OMTSException {
		int rowsDeleted = 0;
		int showId = 75483;
		rowsDeleted = adminService.deleteShow(showId);
		boolean actualRowsDeleted = false;
		if(rowsDeleted > 0) {
			actualRowsDeleted = true;
		}
		boolean expectedRowsDeleted = true;
		assertEquals(expectedRowsDeleted, actualRowsDeleted);
	}
	
	@Test
	public void getShowByNameTest() throws OMTSException {
		String showName = "Morning";
		List<Show> showList = adminService.getShowByName(showName);
		boolean actualShowList = false;
		if(showList.size() > 0) {
			actualShowList = true;
		}
		boolean expectedShowList = true;
		assertEquals(expectedShowList, actualShowList);
	}
}
