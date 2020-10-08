package com.cg.omts.dao;

public interface IAdminQueryConstants {
	public static String GET_THEATRE_DETAILS= "SELECT * FROM THEATRE"; 
	public static String ADD_THEATRE="INSERT INTO THEATRE VALUES(?,?,?,?,?)";
	public static String DELETE_THEATRE = "DELETE FROM THEATRE WHERE THEATREID=?";
}
