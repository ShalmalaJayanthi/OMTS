package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.omts.dto.Ticket;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.utility.DBConnection;

public class BookingDaoImpl implements IBookingDao{

	static Connection connection = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public int generateTicket(Ticket ticket) throws OMTSException {
		// TODO Auto-generated method stub
		int isGenerated = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GENERATE_TICKET);    
			prepareStatement.setInt(1, ticket.getTicketId()); 
			prepareStatement.setInt(2, ticket.getNoOfSeats());
			prepareStatement.setInt(3, ticket.getScreenId());
			prepareStatement.setInt(4, ticket.getTheatreId());
			prepareStatement.setInt(5, ticket.getShowId());
			prepareStatement.setInt(6, ticket.getMovieId());
			isGenerated = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isGenerated;
	}


}
