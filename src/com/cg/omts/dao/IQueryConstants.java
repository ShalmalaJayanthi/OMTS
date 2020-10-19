package com.cg.omts.dao;

public interface IQueryConstants {
	
	
	
	String VALIDATE = "select roleCode from user where userId=? and password=?";
	String REGISTER="insert into user values(?,?,?,?,?,?)";

	String CHECK_TRANSACTION = "select * from transaction";
	String MAX_TRANSACTION_ID = "select max(transactionid) from transaction";
	
	String ADD_MOVIE = "insert into movie values(?, ?, ?, ?, ?, ?, ?)"; 
	
	
	String DELETE_MOVIE = "delete from movie where movieId = ?";
	String DISPLAY_ALL_MOVIES_DELETE = "select movieId, movieName, movieGenre, movieDirector, language from movie";
	String GET_THEATRE_DETAILS = "select theatreId, theatreName from theatre where theatreCity = ?";
	String VALIDATE_MOVIE_ID = "select movieId, movieName from movie where movieId = ?";
	String VALIDATE_SCREEN_ID = "select screenId, screenName from screen where screenId = ?";
	String VALIDATE_THEATRE_ID = "select theatreId, theatreName from theatre where theatreId = ?";
	String CHECK_ID_IN_CITY = "select theatreId from theatre where theatreCity = ? and theatreId = ?";
	String THEATRE_MOVIE_ID_ALREADY_EXISTS = "select movieId from movietheatre where theatreId = ? and movieId = ?";
	String ADD_SCREEN = "insert into screen values(?, ?, ?, ?, ?)";
	String DELETE_SCREEN = "delete from screen where screenId = ?";
	String DISPLAY_ALL_SCREEN_DELETE= "select s.screenId, s.screenName, s.theatreId, t.theatreName, t.theatreCity from screen s, theatre t where s.theatreId = t.theatreId;";

	String ADD_MOVIE_TO_THEATRE = "insert into movietheatre values(?, ?)";
	String GET_MOVIE_NAME_ID = "select movieId, movieName from movie";
	String ADD_SCREEN_SEAT_PRICE = "insert into screenseatprice values(?, ?)";
}
