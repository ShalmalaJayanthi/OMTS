package com.cap.omts.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//mysql

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KnowledgePark","root","root");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

