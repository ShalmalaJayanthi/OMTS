package com.cg.omts.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Ticket.TicketStatus;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IUserService;
import com.cg.omts.service.UserServiceImpl;


@WebServlet("/ProceedToPayController")
public class ProceedToPayController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IUserService userService = new UserServiceImpl();
		RequestDispatcher dispatcher = null;
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		int theatreId = Integer.parseInt(request.getParameter("theatreId"));		
		int screenId = Integer.parseInt(request.getParameter("screenId"));
		int showId = Integer.parseInt(request.getParameter("showId"));
		int noOfSeats = Integer.parseInt(request.getParameter("noOfSeats"));
		int price = Integer.parseInt(request.getParameter("seatPrice"));
		int ticketId = GenerateTicketID.getTicketId();
		System.out.println(ticketId);
		List<Integer> selectedSeatsList = new ArrayList<Integer>();
		int seatStartId = GenerateTicketID.getSeatId();
		System.out.println(seatStartId);
		for(int seats = 0; seats < noOfSeats; seats++) {
			selectedSeatsList.add(seatStartId++);
		}
		int userId = 1;
		try {
			Ticket ticket = new Ticket(ticketId, noOfSeats, TicketStatus.INPROCESS, screenId, theatreId, showId, movieId);	
			int isGenerated = userService.generateTicket(userId, ticket);
			userService.allocateSeat(selectedSeatsList, screenId);
			userService.assignSeatsToTickets(ticketId, selectedSeatsList);
			userService.setTicketStatus(ticketId, "INPROCESS");
			request.setAttribute("ticketId", ticketId);
			request.setAttribute("movieId", movieId);
			request.setAttribute("screenId", screenId);
			request.setAttribute("showId", showId);
			dispatcher = request.getRequestDispatcher("payment.jsp");
			dispatcher.forward(request, response);
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
