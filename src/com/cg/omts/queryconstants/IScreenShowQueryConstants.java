package com.cg.omts.queryconstants;

public interface IScreenShowQueryConstants {
	
	String VALIDATE_SCREEN_ID = "select screenId, screenName from screen where screenId = ?";
	
	String ADD_SCREEN = "insert into screen values(?, ?, ?, ?, ?)";
	
	String DELETE_SCREEN = "delete from screen where screenId = ?";
	
	String DISPLAY_ALL_SCREEN_DELETE= "select s.screenId, s.screenName, s.theatreId, t.theatreName, t.theatreCity from screen s, theatre t where s.theatreId = t.theatreId;";
	
	String ADD_SCREEN_SEAT_PRICE = "insert into screenseatprice values(?, ?)";
}
