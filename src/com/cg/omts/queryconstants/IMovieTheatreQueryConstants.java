package com.cg.omts.queryconstants;

public interface IMovieTheatreQueryConstants {
	
	String ADD_MOVIE = "insert into movie values(?, ?, ?, ?, ?, ?, ?)"; 
	
	String DELETE_MOVIE = "delete from movie where movieId = ?";
	
	String DISPLAY_ALL_MOVIES_DELETE = "select movieId, movieName, movieGenre, movieDirector, language from movie";
	
	String GET_THEATRE_DETAILS = "select theatreId, theatreName from theatre where theatreCity = ?";
	
	String VALIDATE_MOVIE_ID = "select movieId, movieName from movie where movieId = ?";
		
	String VALIDATE_THEATRE_ID = "select theatreId, theatreName from theatre where theatreId = ?";
	
	String CHECK_ID_IN_CITY = "select theatreId from theatre where theatreCity = ? and theatreId = ?";
	
	String THEATRE_MOVIE_ID_ALREADY_EXISTS = "select movieId from movietheatre where theatreId = ? and movieId = ?";
	
	String ADD_MOVIE_TO_THEATRE = "insert into movietheatre values(?, ?)";
	
	String GET_MOVIE_NAME_ID = "select movieId, movieName from movie";
	
	

}
