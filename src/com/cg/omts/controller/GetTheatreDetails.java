package com.cg.omts.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Theatre;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;

@WebServlet("/GetTheatreDetails")
public class GetTheatreDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theatreCity = request.getParameter("theatreCity");
		System.out.println("City; "+theatreCity);
		IAdminService adminService = new AdminServiceImpl();
		ArrayList<Theatre> getTheatres = adminService.getTheatreDetails(theatreCity);
		
		ServletContext context=getServletContext();  
		Movie movie = (Movie) context.getAttribute("movieDto");  
		Screen screen = (Screen) context.getAttribute("screen");
		context.setAttribute("movie", movie);
		context.setAttribute("screen",screen);
		displayTheatreDetails(request, response, getTheatres);
	
	}
	
	protected void displayTheatreDetails(HttpServletRequest request, HttpServletResponse response, ArrayList<Theatre> getTheatres) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		request.setAttribute("theatreDetails", getTheatres); 
		request.getRequestDispatcher("selectTheatreId.jsp").forward(request, response);
	}

}
