package com.cg.omts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.MovieTheatreServiceImpl;


@WebServlet("/AddMovieServlet")
public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String movieName = request.getParameter("movieName");
		String movieGenre = request.getParameter("movieGenre");
		String movieDirector = request.getParameter("movieDirector");
		int movieLength = Integer.parseInt(request.getParameter("movieLength"));
		String movieLanguage = request.getParameter("movieLanguage");
		String releaseDate = request.getParameter("movieReleaseDate");
	 
		Date movieReleaseDate = Date.valueOf(releaseDate);
		IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
		PrintWriter out = response.getWriter();
		String message = " ";
		try {
			if(movieTheatreService.isMovieIdExists(movieId)){
				message = "Movie with ID: "+movieId+" already exists!!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("addMovie.jsp").forward(request, response);
			} else {
				Movie movie = new Movie(movieId, movieName, movieGenre, movieDirector, movieLength, movieLanguage, movieReleaseDate);
				
				boolean isMovieAdded = false;
				isMovieAdded = movieTheatreService.addMovie(movie);
				if(isMovieAdded) {
					message = "Movie details with ID : "+ movie.getMovieId()+ " is successfully added";
					request.setAttribute("message", message);
					request.getRequestDispatcher("addMovie.jsp").forward(request, response);
				}
				else {
					message = "Failed to add movie details with ID : "+ movie.getMovieId();
					request.setAttribute("message", message);
					request.getRequestDispatcher("addMovie.jsp").forward(request, response);
				}
			}
		} catch (OMTSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
				
	
	}

}
