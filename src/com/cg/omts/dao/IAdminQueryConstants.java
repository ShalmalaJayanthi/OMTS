package com.cg.omts.dao;

public interface IAdminQueryConstants {
	
	String GET_THEATRE_DETAILS = "SELECT * FROM THEATRE";
	
	String ADD_THEATRE = "INSERT INTO THEATRE VALUES(?,?,?,?,?)";
}