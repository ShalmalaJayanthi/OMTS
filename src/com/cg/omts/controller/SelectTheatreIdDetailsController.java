package com.cg.omts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;


@WebServlet("/SelectTheatreIdDetails")
public class SelectTheatreIdDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
				
		IAdminService adminService = new AdminServiceImpl();
		int theatreId = Integer.parseInt(request.getParameter("theatreId"));
		Boolean isAdded;
		
		ServletContext context=getServletContext();  
		Movie movie = (Movie) context.getAttribute("movieDto");
		Screen screen = (Screen) context.getAttribute("screen");
		try {
			if(screen == null) {
				isAdded = adminService.addMovie(movie,theatreId);
				if(isAdded) {
					System.out.println("Successfully Added movie details");
					out.println("<h2>Successfully Added movie details with movie Id: "+movie.getMovieId());
			}
			} else {
				String screenId = ""+ screen.getScreenId() + theatreId; 
				screen.setScreenId(Integer.parseInt(screenId));
				isAdded = adminService.addScreen(screen, theatreId);
				if(isAdded) {
					System.out.println("Successfully Added Screen details");
					out.println("<h2>Successfully added Screen details with screen Id: "+screen.getScreenId());
				}
			}
		} catch (OMTSException e) {
			System.out.println("Couldn't add the details\n" + e);
			
		}
	}

}
