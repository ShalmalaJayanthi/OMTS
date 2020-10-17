package com.cg.omts.dao;

public interface IQueryConstants {
	
	
	String ADD_MOVIE = "insert into movie values(?, ?, ?, ?, ?, ?, ?, ?)"; 
	String DELETE_MOVIE = "delete from movie where movieId = ?";
	String DISPLAY_ALL_MOVIES_DELETE = "select movieId, movieName, m.theatreId, t.theatreName, t.theatreCity from movie m, theatre t where m.theatreId = t.theatreId;";
	String GET_THEATRE_DETAILS = "select theatreId, theatreName from theatre where theatreCity = ?";
	
	String ADD_SCREEN = "insert into screen values(?, ?, ?, ?, ?)";
	String DELETE_SCREEN = "delete from screen where screenId = ?";
	String DISPLAY_ALL_SCREEN_DELETE= "select s.screenId, s.screenName, s.theatreId, t.theatreName, t.theatreCity from screen s, theatre t where s.theatreId = t.theatreId;";
	String VALIDATE = "select roleCode from userdetails where userId=? and password=?";
	String REGISTER="insert into user values(?,?,?,?,?,?)";

	String CHECK_TRANSACTION = "select * from transaction";
	String MAX_TRANSACTION_ID = "select max(transactionid) from transaction";
}
