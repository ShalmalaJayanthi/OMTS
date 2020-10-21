package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.queryconstants.IScreenShowQueryConstants;
import com.cg.omts.utility.DBConnection;

public class ScreenShowDaoImpl implements IScreenShowDao, IScreenShowQueryConstants {
	static Connection connection = null;
	static Statement statement = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_SCREEN);
			prepareStatement.setInt(1, screen.getScreenId());
			prepareStatement.setInt(2, theatreId);
			prepareStatement.setString(3, screen.getScreenName());
			prepareStatement.setInt(4, screen.getRows());
			prepareStatement.setInt(5, screen.getColumns());
			rows = prepareStatement.executeUpdate();
			if(rows > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to add the screen\n"+e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				
				throw new OMTSException("Failed to close the database connection"+ e);
			}
		}
		return false;
	}

	@Override
	public Boolean deleteScreen(Integer screenId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(DELETE_SCREEN);
			prepareStatement.setInt(1, screenId);
			rows = prepareStatement.executeUpdate();
			if(rows > 0)
				return true;
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to delete the screen with Id: "+screenId);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				
				throw new OMTSException("Failed to get the screen details"+ e);
			}
		}
		return false;
	}

	@Override
	public ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException{
		connection = DBConnection.getConnection();
		Screen screen = null;
		ArrayList<Screen> screenList = null;
		try {
			prepareStatement = connection.prepareStatement(DISPLAY_ALL_SCREEN_DELETE);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			screenList = new ArrayList<Screen>();
			
			while(resultSet.next()) {
				screen = new Screen();
				screen.setScreenId(resultSet.getInt(1));
				screen.setScreenName(resultSet.getString(2));
				screen.setTheatreId(resultSet.getInt(3));
				screen.setTheatreName(resultSet.getString(4));
				screen.setTheatreCity(resultSet.getString(5));
				screenList.add(screen);
			}
			
			return screenList;
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to get the screen details"+ e);
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
	public boolean isScreenIdExists(int screenId) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(VALIDATE_SCREEN_ID);
			prepareStatement.setInt(1, screenId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			if(resultSet.next())
				return true;
		} catch (SQLException e) {
			throw new OMTSException("Failed to check whether the given screen ID exists or not "+e);
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
	public boolean addScreenSeatPrice(int screenId, int seatPrice) throws OMTSException {
		connection = DBConnection.getConnection();
		System.out.println("Screen id and seat Price in dao are: "+screenId + " "+seatPrice);
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_SCREEN_SEAT_PRICE);
			prepareStatement.setInt(1, screenId);
			prepareStatement.setInt(2, seatPrice);
			rows = prepareStatement.executeUpdate();
			if(rows > 0)
				return true;
		} catch (SQLException e) {
			throw new OMTSException("Failed to add the screen seat price" + e);
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
	public List<Show> getShowDetails() throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addShow(Show show) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteShow(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Show> getShowByName(String showName) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getScreenFromMovieAndTheatre(int theatreId, int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkShowNameandScreenId(String showName, int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return null;
	}

}
