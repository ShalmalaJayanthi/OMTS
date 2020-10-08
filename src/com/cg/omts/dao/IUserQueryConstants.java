package com.cg.omts.dao;

public interface IUserQueryConstants {
	String GET_MOVIE_DETAILS = "select * from movie where movieid = ?";
	String GET_ALL_MOVIES = "SELECT * from movie";
	String GET_THEATREID = "SELECT theatreId from theatre WHERE theatreCity=?";
}
