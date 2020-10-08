package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.utility.DBConnection;
import com.cg.omts.utility.JdbcUtility;

public class UserDaoImpl implements IUserDao{

	static Connection connection = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	static PreparedStatement ps;
	
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
	public List<Movie> getAllMovies() throws OMTSException{
		List<Movie> movieList = new ArrayList<Movie>();
		Movie movie = null;
		try {
			connection =  JdbcUtility.getConnection();
			ps = connection.prepareStatement(IUserQueryConstants.GET_ALL_MOVIES);
			resultSet = ps.executeQuery();	
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
				System.out.println(movie);
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
	public List<Integer> getTheatresByCity() throws OMTSException {
		List<Integer> theatreIdList = new ArrayList<>();
		Theatre theatre = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter city ");
		String city = sc.next();
		try {
			connection = JdbcUtility.getConnection();
			ps = connection.prepareStatement(IUserQueryConstants.GET_THEATREID);
			ps.setString(1, city);
			resultSet = ps.executeQuery();
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
	 * public static void main(String[] args) { System.out.println(new
	 * UserDaoImpl().getMovieDetails(1)); }
	 */
}
