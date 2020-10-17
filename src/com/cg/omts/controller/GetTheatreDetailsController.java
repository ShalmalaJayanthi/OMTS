package com.cg.omts.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;

@WebServlet("/GetTheatreDetails")
public class GetTheatreDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String theatreCity = request.getParameter("theatreCity");
		IAdminService adminService = new AdminServiceImpl();
		
		ArrayList<Theatre> getTheatres = null;
		ArrayList<Movie> getMovieDetails = null;
		try {
			request.setAttribute("theatreCity", theatreCity);
			ServletContext context=getServletContext();    
			Screen screen = (Screen) context.getAttribute("screen");
			context.setAttribute("screen",screen);
			
			getTheatres = adminService.getTheatreDetails(theatreCity);
			request.setAttribute("theatreDetails", getTheatres);
			
			if(screen == null) {
				getMovieDetails = adminService.getMovieIdName();
				 
				request.setAttribute("movieDetails", getMovieDetails);
				request.getRequestDispatcher("addMovieToTheatre.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("selectTheatreId.jsp").forward(request, response);
			}
		} catch (OMTSException e) {
			
			e.printStackTrace();
		}
		
		
	
	}

}
