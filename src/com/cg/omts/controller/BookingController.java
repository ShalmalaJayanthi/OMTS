package com.cg.omts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IUserService;
import com.cg.omts.service.UserServiceImpl;
@WebServlet("/BookingController")
public class BookingController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = null;
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		System.out.println(movieId);
		IUserService userService = new UserServiceImpl();
		try {
		
			List<Integer> theatreIdList = userService.getTheatresByMovie(movieId);
			List<Theatre> theatresList = userService.getTheatres(theatreIdList);
			//List<Screen> screenList = userService.getScreenByTheatreId(theatreId);
			System.out.println(theatresList);
			
			
			request.setAttribute("theatresList", theatresList);
			dispatcher = request.getRequestDispatcher("booking.jsp");
			dispatcher.forward(request, response);
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
