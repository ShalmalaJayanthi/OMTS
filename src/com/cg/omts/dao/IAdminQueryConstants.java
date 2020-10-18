package com.cg.omts.dao;

public interface IAdminQueryConstants {
	
	String GET_THEATRE_DETAILS = "select * from theatre";
	
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
	
}
