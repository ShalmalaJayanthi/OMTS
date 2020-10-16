package com.cg.omts.controller;

import java.sql.SQLException;

import com.cg.omts.dao.AdminDaoImpl;
import com.cg.omts.exceptions.OMTSException;

public class GenerateTransactionID {
	public static int startTransaction = 1000;
	
	static public int getTransactionId() {
		try {
			boolean isTransactionNull = AdminDaoImpl.checkTransaction();
			if(! isTransactionNull) {
				startTransaction = 1000;
				System.out.println("From generate transaction id class:" + isTransactionNull);
			} else {
				startTransaction = AdminDaoImpl.getMaxTransactionId() + 1;
			}
			
		} catch (SQLException | OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return startTransaction;
		
	}

}
