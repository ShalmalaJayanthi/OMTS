package com.cg.omts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.MovieTheatreServiceImpl;

@WebServlet("/AddMovieToTheatre")
public class AddMovieToTheatre extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String theatreCity = request.getParameter("theatreCity");
		
		int theatreId = Integer.parseInt(request.getParameter("theatreId"));
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		
		IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
		boolean movieIdExists = false, theatreIdExists = false, theatreInSameCity = false;
		String message = "";
		
		try {
			movieIdExists = movieTheatreService.isMovieIdExists(movieId);
			theatreIdExists = movieTheatreService.isTheatreIdExists(theatreId);
			theatreInSameCity = movieTheatreService.checkTheatreIdInCity(theatreId, theatreCity);
		
			if(movieIdExists && theatreIdExists && theatreInSameCity ) {
				if(! movieTheatreService.checkIdTheatreMovieAlreadyExists(theatreId, movieId)) {
					
						boolean isAdded = false;
						
						isAdded = movieTheatreService.addMovieToTheatre(movieId, theatreId);
						if(isAdded) {
							message = "Successfully added movie with ID: "+ movieId + " to the theatre with ID: " + theatreId;
							request.setAttribute("message", message);
							request.getRequestDispatcher("getTheatreDetails.jsp").forward(request, response);
						} else {
							message = "Failed to add movie with ID: "+ movieId + " to the theatre with ID: " + theatreId;
							request.setAttribute("message", message);
							request.getRequestDispatcher("getTheatreDetails.jsp").forward(request, response);
						}
				} else {
					message = "Movie with ID: "+ movieId + " already exists in Theatre with ID: "+ theatreId;
					request.setAttribute("message", message);
					request.getRequestDispatcher("getTheatreDetails.jsp").forward(request, response);
				}
			} else {
				message = "Enter valid Theate ID and Movie ID";
				request.setAttribute("message", message);
				request.getRequestDispatcher("getTheatreDetails.jsp").forward(request, response);
			}
		} catch (OMTSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
