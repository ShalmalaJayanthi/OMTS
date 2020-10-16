package com.cg.omts.controller;

import java.sql.SQLException;

import com.cg.omts.dao.IUserDao;
import com.cg.omts.dao.UserDaoImpl;
import com.cg.omts.exceptions.OMTSException;

public class GenerateTicketID {
	public static int startTicketID = 1000;
	public static int startSeatId = 1;
	static public int getTicketId() {
		try {
			boolean isTicketNull = UserDaoImpl.checkTicket();
			if(isTicketNull == false) {
				startTicketID = 1000;
			} else {
				startTicketID = UserDaoImpl.getMaxTicketId()+1;
			}
			System.out.println("isFound"+isTicketNull);
			
		}catch(SQLException | OMTSException e) {
			e.printStackTrace();
		}
		System.out.println("In Generate ticket id"+startTicketID );
		return startTicketID;
	}
	static public int getSeatId() {
		try {
			boolean isSeatNull = UserDaoImpl.checkSeat();
			if(isSeatNull == false) {
				startSeatId = 1000;
			} else {
				startSeatId = UserDaoImpl.getMaxSeatId()+1;
			}
			System.out.println("isFound"+isSeatNull);
			
		}catch(SQLException | OMTSException e) {
			e.printStackTrace();
		}
		System.out.println("In GENERATE SEAT ID"+startSeatId);
		return startSeatId;
	}
	
}
