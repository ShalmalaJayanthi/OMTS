package com.cg.omts.controller;

import java.io.IOException;
//import java.io.InputStream;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;

import com.cg.omts.dto.Movie;


@WebServlet("/AddMovieServlet")
@MultipartConfig()
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
		
		Movie movie = new Movie(movieId, movieName, movieGenre, movieDirector, movieLength, movieLanguage, movieReleaseDate);
		
		ServletContext context=getServletContext();  
		context.setAttribute("movieDto",movie);  
		request.getRequestDispatcher("getTheatreDetails.jsp").include(request, response);
		
		
		
		
				
	
	}

}
