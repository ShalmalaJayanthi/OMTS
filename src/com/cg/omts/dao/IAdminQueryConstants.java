package com.cg.omts.dao;

public interface IAdminQueryConstants {
	
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
	
	String GET_THEATRE_DETAILS_DISPLAY = "select * from theatre";
	
	String ADD_THEATRE = "insert into theatre values(?,?,?,?,?)";
	
	String DELETE_THEATRE = "delete from theatre where theatreId = ?";
	
	String GET_THEATRE_BY_NAME = "select * from theatre where theatreName = ?";
	
	String GET_SHOW_DETAILS = "select * from showdetails";
	
	String ADD_SHOW = "insert into showdetails values(?,?,?,?,?,?,?,?)";
	
	String DELETE_SHOW = "delete from showdetails where showId = ?";
	
	String GET_SHOW_BY_NAME = "select * from showdetails where showName = ?";
	
	String GET_MOVIELENGTH = "select movieLength from movie where movieId = ?";
	
	String GET_MOVIENAME_FROM_MOVIE = "select movieName from movie where movieId = ?";
	
	String GET_SCREEN_FROM_MOVIE_AND_THEATRE = "select screenId, theatreId from screen where theatreId =(select theatreId from movietheatre where movieId = ? and theatreId = ?)";
	
	String GET_MOVIENAME_BY_FROM_MOVIE = "select movieName from movie where movieId = ?";
	
	String CHECK_SHOWNAME_AND_SCREENID = "select showName,screenId from showdetails where showName=? and screenId=?";
	
	
	
	
	
	
	/*      *********************************************************************************
	Add all the queries above this 
	
	Should remove the below Queries
	
	
			**********************************************************************************
			*/
	
//	
	
}
