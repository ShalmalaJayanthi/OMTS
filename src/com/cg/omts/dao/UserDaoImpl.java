package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.utility.DBConnection;

import sun.security.pkcs11.Secmod.DbMode;

public class UserDaoImpl implements IUserDao{

	static Connection connection = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public Movie getMovieDetails(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		Movie movie = null;
		Boolean isFound = false;
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_MOVIE_DETAILS);
			prepareStatement.setInt(1, movieId);
			resultSet = prepareStatement.executeQuery();
			
			isFound = resultSet.next();
			if(isFound == true) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setMovieLength(resultSet.getInt(5));
				movie.setLanguage(resultSet.getString(6));
				movie.setMovieReleaseDate(resultSet.getDate(7));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object");
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}

		}
		return movie;
	}
	
	@Override
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		List<Integer> theatreIdList = new ArrayList<Integer>();
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATRES_BY_MOVIE);
			prepareStatement.setInt(1, movieId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				theatreIdList.add(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		
		return theatreIdList;
	}

	@Override
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<String> theatreNamesList = new ArrayList<String>();
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATRE_NAME_BY_ID);
			
			for(Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
				resultSet = prepareStatement.executeQuery();
					while(resultSet.next()) {
						theatreNamesList.add(resultSet.getString(1));
					}
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		return theatreNamesList;
	}	
	
	@Override
	public List<Movie> getAllMovies() throws OMTSException{
		List<Movie> movieList = new ArrayList<Movie>();
		Movie movie = null;
		try {
			connection =  DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_ALL_MOVIES);
			resultSet = prepareStatement.executeQuery();	
			while(resultSet.next()) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setMovieLength(resultSet.getInt(5));
				movie.setLanguage(resultSet.getString(6));
				movie.setMovieReleaseDate(resultSet.getDate(7));
				movieList.add(movie);
				
			}	
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object"+e.getMessage());
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return movieList;
	}
	
	@Override
	public List<Integer> getTheatresByCity(String city) throws OMTSException {
		List<Integer> theatreIdList = new ArrayList<>();
		Theatre theatre = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATREID);
			prepareStatement.setString(1, city);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				theatre = new Theatre();
				theatreIdList.add(resultSet.getInt(1));
			}
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return theatreIdList;			
	}	
	/*
	 * public static void main(String[] args) throws OMTSException { List<String>
	 * theatreNamesList =
	 * UserDaoImpl.getTheatreNames(UserDaoImpl.getTheatresByMovie(2)); for(String s
	 * : theatreNamesList) System.out.println(s); }
	 */
}
