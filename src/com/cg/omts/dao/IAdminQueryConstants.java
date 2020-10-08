package com.cg.omts.dao;

public interface IAdminQueryConstants {

	
	String GET_THEATRE_DETAILS = "select * from theatre";
	
	String ADD_THEATRE = "insert into theatre valules(?,?,?,?,?)";
	
	String DELETE_THEATRE = "DELETE FROM THEATRE WHERE THEATREID=?";
}
