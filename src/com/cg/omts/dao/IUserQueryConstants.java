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
	
	String ADD_TRANSACTION = "insert into transaction values(?,?,?,?,?)";
	
	String ADD_BOOKING = "insert into booking values(?,?,?,?)";
	
	String SET_SEAT_STATUS = "update seat set seatStatus = ? where seatId = ?";
	
	String DELETE_BOOKING_DETAILS = "delete from booking where bookingId = ?";
	
	String GET_SEATS = "select seatId from ticketseat where ticketId = ?";
	
	String DELETE_ALLOCATED_SEATS = "delete from ticketseat where ticketId = ?";
	
	String DELETE_SEATS = "delete from seat where seatId = ?";
	
	String GET_TRANSACTION_DETAILS = "select transactionId, accountNo, totalAmt from transaction where ticketId = ?";
	
	String DELETE_TRANSACTION = "delete from transaction where ticketId = ?";
	
	String DELETE_TICKET = "delete from ticket where ticketId = ?";
	
	String REFUND_AMOUNT = "update bankaccount set accountBal = ? where accountNo = ?";
	
	String GET_CURRENT_BALANCE = "select accountBal from bankaccount where accountNo = ?";
}


