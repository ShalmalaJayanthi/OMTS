package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.utility.DBConnection;

public class AdminDaoImpl implements IAdminDao {
	
	static Connection connection = null;
	static Statement statement = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public List<Theatre> getTheatreDetails() throws OMTSException {
		// TODO Auto-generated method stub
		List<Theatre> theatreList = new ArrayList<Theatre>();
		try {
			connection  = DBConnection.getConnection();
			statement = connection.createStatement();  
			resultSet = statement.executeQuery(IAdminQueryConstants.GET_THEATRE_DETAILS);  
			
			while(resultSet.next())   {
					Theatre theatre = new Theatre();
					theatre.setTheatreId(resultSet.getInt(1));
					theatre.setTheatreName(resultSet.getString(2));
					theatre.setTheatreCity(resultSet.getString(3));
					theatre.setManagerName(resultSet.getString(4));
					theatre.setManagerContact(resultSet.getString(5));
					theatreList.add(theatre); 
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while displaying Theatre Data from Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
			
		return theatreList;
		}

	@Override
	public int addTheatre(Theatre theatre) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IAdminQueryConstants.ADD_THEATRE);    
			prepareStatement.setInt(1,theatre.getTheatreId());  
			prepareStatement.setString(2,theatre.getTheatreName()); 
			prepareStatement.setString(3, theatre.getTheatreCity());
			prepareStatement.setString(4, theatre.getManagerName());
			prepareStatement.setString(5, theatre.getManagerContact());
			isInserted = prepareStatement.executeUpdate();  
			}catch(SQLException e){ 
				throw new OMTSException("problem inserting Theatre Details into Database");
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new OMTSException("problem while closing Database");
				}
			}
		return isInserted;
	}
	
	@Override
	public int deleteTheatre(int theatreId) throws OMTSException {
		int isDeleted = 0;
		try {
		// TODO Auto-generated method stub
		connection = DBConnection.getConnection();
		prepareStatement=connection.prepareStatement(IAdminQueryConstants.DELETE_THEATRE);    
		prepareStatement.setInt(1,theatreId);  
		isDeleted = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem while deleting Theatre Details from Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
	return isDeleted;
	}

	@Override
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException {
		// TODO Auto-generated method stub
		List<Theatre> theatreList = new ArrayList<Theatre>();
		try {
			connection  = DBConnection.getConnection();
			prepareStatement =connection.prepareStatement(IAdminQueryConstants.GET_THEATRE_BY_NAME); 
			prepareStatement.setString(1, theatreName);
			resultSet = prepareStatement.executeQuery();  
				while(resultSet.next())   {
					Theatre theatre = new Theatre();
					theatre.setTheatreId(resultSet.getInt(1));
					theatre.setTheatreName(resultSet.getString(2));
					theatre.setTheatreCity(resultSet.getString(3));
					theatre.setManagerName(resultSet.getString(4));
					theatre.setManagerContact(resultSet.getString(5));
					theatreList.add(theatre); 
				}
			}catch(SQLException e){ 
				throw new OMTSException("problem while displaying Theatre Data from Database");
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new OMTSException("problem while closing Database");
				}
			}
				
		return theatreList;
	}
	
	@Override
	public Boolean addMovie(Movie movie, Integer theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Show> getShowDetails() throws OMTSException {
		// TODO Auto-generated method stub
		List<Show> showList = new ArrayList<Show>();
		try {
			connection  = DBConnection.getConnection();
			statement = connection.createStatement();  
			resultSet = statement.executeQuery(IAdminQueryConstants.GET_SHOW_DETAILS);  
			
			while(resultSet.next())   {
					Show show = new Show();
					show.setShowId(resultSet.getInt(1));
					show.setShowStartTime(resultSet.getTime(2));
					show.setShowEndTime(resultSet.getTime(3));
					show.setShowName(resultSet.getString(4));
					show.setMovieName(resultSet.getString(5));
					show.setScreenId(resultSet.getInt(6));
					show.setTheatreId(resultSet.getInt(7));
					show.setMovieId(resultSet.getInt(8));
					showList.add(show); 
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while displaying Show Data from Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
			
		return showList;
		
	}

	@Override
	public int addShow(Show show) throws OMTSException {
		int isInserted = 0;
		System.out.println(show);
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IAdminQueryConstants.ADD_SHOW);    
			prepareStatement.setInt(1,show.getShowId()); 
			prepareStatement.setTime(2, show.getShowStartTime());
			prepareStatement.setTime(3, show.getShowEndTime());
			//prepareStatement.setString(4, show.getSeats());
			prepareStatement.setString(5, show.getShowName());
			prepareStatement.setString(6, show.getMovieName());
			prepareStatement.setInt(7,show.getScreenId());
			prepareStatement.setInt(8, show.getTheatreId());
			prepareStatement.setInt(9, show.getMovieId());
			isInserted = prepareStatement.executeUpdate();  
			}catch(SQLException e){ 
				throw new OMTSException("problem inserting Show Details into Database");
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new OMTSException("problem while closing Database");
				}
			}
		return isInserted;
	}

	@Override
	public int deleteShow(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Show> getShowByName() throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}
}
