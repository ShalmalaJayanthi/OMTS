package com.cg.omts.service;

import com.cg.omts.dao.BookingDaoImpl;
import com.cg.omts.dao.IBookingDao;
import com.cg.omts.dto.Ticket;
import com.cg.omts.exceptions.OMTSException;

public class BookingServiceImpl implements IBookingService{

	IBookingDao bookingDao = new BookingDaoImpl();
	@Override
	public int generateTicket(Ticket ticket) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.generateTicket(ticket);
	}

}
