package com.cg.omts.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.MovieTheatreServiceImpl;

@WebServlet("/DisplayMoviesToUser")
public class DisplayMoviesToUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
		try {
			String city = request.getParameter("city");
			request.setAttribute("city", city);
			if(city.equals("All Cities")) {
				dispatcher = request.getRequestDispatcher("userhome.jsp");
				dispatcher.include(request, response);
			} else {
				List<Integer> movieIdList = new ArrayList<Integer>();
				List<Integer> theatreIdList = movieTheatreService.getTheatresByCity(city);
				movieIdList = movieTheatreService.getMoviesByTheatre(theatreIdList);
				List<Movie> movieList = new ArrayList<Movie>();
				Set<Integer> movieIdSet = new HashSet<Integer>();
				Set<Movie> movieSet = new HashSet<Movie>();
				for(Integer movieId : movieIdList) {
					movieIdSet.add(movieId);
				}
				movieIdList = new ArrayList<Integer>();
				for(Integer movieId: movieIdSet) {
					movieIdList.add(movieId);
				}
				movieList = movieTheatreService.getMoviesById(movieIdList);
				for(Movie movie : movieList) {
					movieSet.add(movie);
				}
				request.setAttribute("movie", movieSet);
			
				dispatcher = request.getRequestDispatcher("movieoncity.jsp");
				dispatcher.include(request, response);
			}
		} catch(OMTSException e) {
			e.printStackTrace();
		}
	}
}
