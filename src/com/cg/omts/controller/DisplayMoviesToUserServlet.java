package com.cg.omts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IUserService;
import com.cg.omts.service.UserServiceImpl;

@WebServlet("/DisplayMoviesToUser")
public class DisplayMoviesToUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		IUserService userService = new UserServiceImpl();
		System.out.println("Inside doGet");
		try {
			String city = request.getParameter("city");
			List<Integer> theatreIdList = userService.getTheatresByCity(city);
			List<Movie> movie = userService.getMoviesByTheatre(theatreIdList);

			HttpSession session = request.getSession();
			request.setAttribute("movie", movie);
			dispatcher = request.getRequestDispatcher("userhome.jsp");
			dispatcher.include(request, response);
			
		} catch(OMTSException e) {
			e.printStackTrace();
		}
	}

}
