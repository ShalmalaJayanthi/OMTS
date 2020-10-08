package com.cg.omts.dao;

public interface IUserQueryConstants {
	
	String GET_MOVIE_DETAILS = "select * from movie where movieid = ?";
	
	String GET_THEATRES_BY_MOVIE = "select theatreId from theatremovie where movieId = ?";
	
	String GET_THEATRE_NAME_BY_ID = "select theatreName from theatre where theatreId = ?";
	
	String GET_ALL_MOVIES = "selct * from movie";
	
	String GET_THEATREID = "select theatreId from theatre WHERE theatreCity=?";

}
