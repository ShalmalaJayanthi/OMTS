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
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.MovieTheatreServiceImpl;

@WebServlet("/GetTheatreScreenDetailsController")
public class GetTheatreScreenDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theatreCity = request.getParameter("theatreCity");
		IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
		
		ArrayList<Theatre> getTheatres = null;
		try {
			request.setAttribute("theatreCity", theatreCity);
					
			getTheatres = movieTheatreService.getTheatreDetails(theatreCity);
			request.setAttribute("theatreDetails", getTheatres);
			
			int seatPrice = Integer.parseInt((String)request.getParameter("seatPrice"));
			
			ServletContext context=getServletContext();    
			Screen screen = (Screen) context.getAttribute("screen");
			context.setAttribute("screen",screen);
			request.setAttribute("seatPrice", seatPrice);
			System.out.println("In get theatre screen controller\nscreen: "+screen+"\nseatPrice: "+seatPrice);
			request.getRequestDispatcher("selectTheatreId.jsp").forward(request, response);
		} catch (OMTSException e) {
		
			e.printStackTrace();
	}
			
	}

}
