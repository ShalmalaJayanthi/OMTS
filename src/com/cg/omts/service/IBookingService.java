package com.cg.omts.service;

import com.cg.omts.dto.Ticket;
import com.cg.omts.exceptions.OMTSException;

public interface IBookingService {

	/*******************************
	 * @description Method to generate ticket
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @param ticket
	 * @return int
	 * @throws OMTSException
	 */
	public int generateTicket(Ticket ticket) throws OMTSException;
	
	
}
