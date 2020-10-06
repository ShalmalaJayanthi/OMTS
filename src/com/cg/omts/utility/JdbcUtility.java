package com.cg.omts.utility;


import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.omts.exceptions.OMTSException;

import oracle.jdbc.OracleDriver;

//oracle

//This class is used to get the connection object
public class JdbcUtility {
	
	private static Connection connection = null;

	//URL used to connect to oracle database 
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";

	//Method which returns a connection object
	public static Connection getConnection() throws OMTSException {
		
		try {
			
			//Loading and registering the Oracle database driver using DriverManager class
			DriverManager.registerDriver(new OracleDriver());
			
			//Getting the connection object by specifying URL and database credentials
			connection = DriverManager.getConnection(url, "system", "Capgemini123");
			
			
/*			Pushing this statement to log file
			System.out.println("connected");
*/			
		} catch (SQLException e) {
			
			//Handling an exception while connecting to database 
			throw new OMTSException("Error occurred in connecting to database");
		}
		
		//Returning the connection object
		return connection;
	}
}
