package com.cg.omts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.MovieTheatreServiceImpl;

@WebServlet("/DeleteMovieServlet")
public class DeleteMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
		
		ArrayList<Movie> displayDetails;
		try {
			displayDetails = movieTheatreService.getMovieDetailsToDelete();
			HttpSession session = request.getSession();
			session.setAttribute("displayDetails", displayDetails);
			request.getRequestDispatcher("deleteMovies.jsp").forward(request, response);
		} catch (OMTSException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
		String message;
		try {
			boolean isMIdExists = movieTheatreService.isMovieIdExists(movieId);
			if(isMIdExists) {
				int rowsDeleted = movieTheatreService.deleteMovie(movieId);
				if(rowsDeleted > 0) {
					message = "Successfully deleted record with movie ID: "+movieId;
					request.setAttribute("message", message);
					request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
				} else { 
					message = "Failed to delete the record with movie ID: "+movieId;
					request.setAttribute("message", message);
					request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
				}
			} else {
				message = "Enter a valid movie ID";
				request.setAttribute("message", message);
				request.getRequestDispatcher("adminHomePage.jsp").forward(request, response);
			}
		} catch (OMTSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	}

}
