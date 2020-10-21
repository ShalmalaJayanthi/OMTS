package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.queryconstants.IMovieTheatreQueryConstants;
import com.cg.omts.utility.DBConnection;

public class MovieTheatreDaoImpl implements IMovieTheatreDao, IMovieTheatreQueryConstants {

	static Connection connection = null;
	static Statement statement = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;

	
	@Override
	public boolean addMovie(Movie movie) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_MOVIE);
			prepareStatement.setInt(1, movie.getMovieId());
			prepareStatement.setString(2, movie.getMovieName());
			prepareStatement.setString(3, movie.getMovieGenre());
			prepareStatement.setString(4, movie.getMovieDirector());
			prepareStatement.setInt(5, movie.getMovieLength());
			prepareStatement.setString(6, movie.getLanguage());
			prepareStatement.setDate(7, movie.getMovieReleaseDate());
			//statement.setBlob(8, inputStream); 
			
			rows = prepareStatement.executeUpdate();
			
			if(rows > 0) 
				return true;
			
		} catch(SQLException e){
			throw new OMTSException("Failed to add movie details!! "+e);
			
		}
		finally{
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" +e);
			}
		}
		return false;
	}
	
	@Override
	public boolean addMovieToTheatre(int movieId, int theatreId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rowsInserted = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_MOVIE_TO_THEATRE);
			prepareStatement.setInt(1, movieId);
			prepareStatement.setInt(2, theatreId);
			rowsInserted = prepareStatement.executeUpdate();
			if(rowsInserted > 0)
				return true;
		} catch (SQLException e) {
			throw new OMTSException("Failed to add movie details!! "+e);
		} finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" +e);
			}
		}
		return false;
		
	}

	@Override
	public int deleteMovie(Integer movieId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(DELETE_MOVIE);
			prepareStatement.setInt(1, movieId);
			rows = prepareStatement.executeUpdate();
			return rows;
		} catch (SQLException e) {

			throw new OMTSException("Failed to delete the movie with Id: "+movieId);
			
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
					throw new OMTSException("Failed to close the database connection" +e);
			}
		}
	}
	
	@Override
	public ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException{
		connection = DBConnection.getConnection();
		Movie movie = null;
		ArrayList<Movie> movieList = null;
		try {
			prepareStatement = connection.prepareStatement(DISPLAY_ALL_MOVIES_DELETE);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			movieList = new ArrayList<Movie>();
			
			while(resultSet.next()) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setLanguage(resultSet.getString(5));
				movieList.add(movie);
			}
			
			return movieList;
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to get the movie details"+ e);
			
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				
				throw new OMTSException("Failed to close the database connection" +e);
				
			}
		}
		
	}
	
	@Override
	public ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException{
		connection = DBConnection.getConnection();
		
		ArrayList<Theatre> theatreDetails = null;
		Theatre theatre = null;
		try {
			prepareStatement = connection.prepareStatement(GET_THEATRE_DETAILS);
			prepareStatement.setString(1, theatreCity);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			
			theatreDetails = new ArrayList<Theatre>();
			
			while(resultSet.next()){
				theatre = new Theatre();
				theatre.setTheatreId(resultSet.getInt(1));
				theatre.setTheatreName(resultSet.getString(2));
				theatreDetails.add(theatre);
			}
			
			return theatreDetails;
			
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to get the theatre details");
			
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" +e);
			}				
		}
	}
	
	@Override
	public ArrayList<Movie> getMovieIdName() throws OMTSException {
		connection = DBConnection.getConnection();
		ArrayList<Movie> movieList = null;
		
		try {
			prepareStatement = connection.prepareStatement(GET_MOVIE_NAME_ID);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			Movie movie = null;
			movieList = new ArrayList<Movie>();
			while(resultSet.next()) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movieList.add(movie);
			}
		} catch (SQLException e) {
			throw new OMTSException("Failed to get the movie ID and Name "+e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" +e);
			}				
		}
		return movieList;
	}

	@Override
	public boolean isMovieIdExists(int movieId) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(VALIDATE_MOVIE_ID);
			prepareStatement.setInt(1, movieId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new OMTSException("Failed to check whether the given movie ID exists or not "+e);
		} finally{
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" +e);
			}
		}
		return false;
	}
	
	@Override
	public boolean isTheatreIdExists(int theatreId) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(VALIDATE_THEATRE_ID);
			prepareStatement.setInt(1, theatreId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			if(resultSet.next())
				return true;
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to check whether the given theatre ID exists or not "+e);
		} finally{
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" +e);
			}
		}
		
		return false;
	}

	@Override
	public boolean checkTheatreIdInCity(int theatreId, String theatreCity) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(CHECK_ID_IN_CITY);
			prepareStatement.setString(1, theatreCity);
			prepareStatement.setInt(2, theatreId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			if(resultSet.next()) {
				if(resultSet.getInt(1) == theatreId)
					return true;
			}
		} catch (SQLException e) {
			throw new OMTSException("Failed to check whether the given theatre ID is present in the given city "+e);
		} finally{
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" +e);
			}
		}
		return false;
	}

	@Override
	public boolean checkIdTheatreMovieAlreadyExists(int theatreId, int movieId) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(THEATRE_MOVIE_ID_ALREADY_EXISTS);
			prepareStatement.setInt(1, theatreId);
			prepareStatement.setInt(2, movieId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			
			if(resultSet.next()) {
				if(resultSet.getInt(1) == movieId)
					return true;
			}
		} catch (SQLException e) {
			throw new OMTSException("Failed to check whether given Theatre ID and movie ID exists "+e);
		} finally{
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" +e);
			}
		}
		return false;
	}

	@Override
	public int getMovieLength(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMovieNameById(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMovieDetails(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getAllMovies() throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTheatreNames(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getTheatresByCity(String city) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Theatre> getTheatreDetails() throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTheatre(Theatre theatre) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTheatre(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

}
