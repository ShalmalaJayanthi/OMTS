package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.utility.DBConnection;

public class AdminDaoImpl  implements IAdminDao {
	
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
}
