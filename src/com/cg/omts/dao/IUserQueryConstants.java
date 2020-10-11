package com.cg.omts.dao;

public interface IUserQueryConstants {
	
	String GET_MOVIE_DETAILS = "select * from movie where movieid = ?";
	
	String GET_THEATRES_BY_MOVIE = "select theatreId from theatremovie where movieId = ?";
	
	String GET_THEATRE_NAME_BY_ID = "select theatreName from theatre where theatreId = ?";
	
	String GET_ALL_MOVIES = "selct * from movie";
	
	String GET_THEATREID = "select theatreId from theatre WHERE theatreCity=?";
	
	String GENERATE_TICKET = "insert into ticket(userId, ticketId, noOfSeats, screenId, theatreId, showId, movieId) values(?,?,?,?,?,?,?)";

	String ALLOCATE_SEATS = "insert into seat values(?,?,?)";
	
	String SET_TICKET_STATUS = "update ticket set ticketStatus = ? where ticketId = ?";
	
	String ASSIGN_SEATS_TO_TICKET = "insert into ticketseat values(?,?)";
}
