package com.cg.omts.dao;

public interface IUserQueryConstants {
	
	String GET_MOVIE_DETAILS = "select * from movie where movieId = ?";
	
	String GET_THEATRES_BY_MOVIE = "select theatreId from movietheatre where movieId = ?";
	
	String GET_THEATRE_NAME_BY_ID = "select theatreName from theatre where theatreId = ?";
	
	String GET_THEATRE_BY_ID = "select * from theatre where theatreId = ?";
	
	String GENERATE_TICKET = "insert into ticket(ticketId, noOfSeats, screenId, theatreId, showId, movieId) values(?,?,?,?,?,?)";

	String ALLOCATE_SEATS = "insert into seat values(?,?,?)";
	
	String SET_TICKET_STATUS = "update ticket set ticketStatus = ? where ticketId = ?";
	
	String ASSIGN_SEATS_TO_TICKET = "insert into ticketseat values(?,?)";
	
	String ADD_TRANSACTION = "insert into transaction values(?,?,?,?)";
	
	String ADD_BOOKING = "insert into booking values(?,?,?,?)";
	
	String ADD_TICKET_TO_USER = "insert into userticket values(?,?)";
	
	String GET_TICKET_IDS = "select ticketId from userticket where userId = ?";
	
	String SET_SEAT_STATUS = "update seat set seatStatus = ? where seatId = ?";
	
	String DELETE_BOOKING_DETAILS = "delete from booking where ticketId = ?";
	
	String GET_SEATS = "select seatId from ticketseat where ticketId = ?";
	
	String DELETE_ALLOCATED_SEATS = "delete from ticketseat where ticketId = ?";
	
	String DELETE_SEATS = "delete from seat where seatId = ?";
	
	String GET_TRANSACTION_DETAILS = "select transactionId, accountNo, totalAmt from transaction where ticketId = ?";
	
	String DELETE_TRANSACTION = "delete from transaction where ticketId = ?";
	
	String DELETE_TICKET = "delete from ticket where ticketId = ?";
	
	String REFUND_AMOUNT = "update bankaccount set accountBal = ? where accountNo = ?";
	
	String GET_CURRENT_BALANCE = "select accountBal from bankaccount where accountNo = ?";
	
	String GET_SEATPRICE_BY_SEATID = "select seatPrice from seat where seatId=?";
	
	String GET_SCREEN_BY_THEATRE_ID = "select * from screen where theatreId=?";
	
	String GET_ALL_MOVIES = "select * from movie";
	
	String GET_THEATREID = "select theatreId from theatre WHERE theatreCity=?";

	String GET_SHOWS_BY_MOVIE_THEATRE = "select * from showdetails where screenId=? and theatreId=? and movieId=?";

	String GET_BOOKING_DETAILS = "select * from booking where ticketId=?";

	String GET_BOOKING_BY_ID = "select * from booking where bookingId=?";
	
	String GET_SCREENSEATPRICE_BY_SCREENID = "select seatPrice from screenseatprice where screenId=?";
	
	String VALIDATE_PAYMENT = "select cvv,password from bankaccount where accountNo=?";
	
	String SEAT_AVAILABILITY ="select seatStatus from Seat where seatId=?";
	
	String GET_SEAT = "select seatStatus from seat where seatId=?";
	
	String GET_TICKET="select noOfSeats,ticketStatus,screenId,theatreId,showId,movieId from ticket where ticketId=?";


	String GET_SCREEN_NAME = "select screenName from screen where screenId = ?";

	String GET_MOVIES_BY_THEATRE_ID = "select * from movie where theatreId=?";


	String GET_SHOW_NAME = "select showName from showdetails where showId = ?";

	String CHECK_TICKET = "select * from ticket";
	
	String CHECK_SEAT = "select * from seat";
	
	String CHECK_BOOKING = "select * from booking";
	
	String MAX_TICKET_ID = "select max(ticketId) from ticket";
	
	String MAX_SEAT_ID = "select max(seatId) from seat";
	
	String MAX_BOOKING_ID = "select max(bookingId) from booking";
	
	String GET_TRANSACTION_ID = "select transactionId from booking where bookingId = ?";
	
	String GET_TICKET_BY_ID = "select * from ticket where ticketId = ?";
	
	String GET_TICKET_ID = "select ticketId from booking where bookingId = ?";
	
	String GET_TRANSACTION_BY_TICKET = "select * from transaction where ticketId = ?";

	String GET_BOOKING_BY_TRANSACTION = "select bookingId, bookingDate from booking where transactionId = ?";
	
	String DELETE_FROM_USER= "delete from userticket where ticketId=?";
	
	String GET_SHOWNAME_BY_THEATREID= "select showName from showdetails where theatreId=?";
	
	String GET_SCREENNAME_BY_THEATREID= "select screenName from screen where theatreId=?";
	
	String GET_AVAILABLE_SEATS = "select count(*) from seat where screenId = ?";
	
	String GET_SCREEN_BY_ID = "select screenRows, columns from screen where screenId = ?";
	
	String GET_THEATRE_NAME = "select theatreName from theatre where theatreId = ?";
	
	String DEDUCT_AMOUNT = "update bankaccount set accountBal = ? where accountNo = ?";
	
}


