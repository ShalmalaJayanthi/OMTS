package com.cg.omts.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//mysql

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalMovie?ssl=true","root","jayanthi");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

