package com.cg.omts.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Show;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;

/**
 * Servlet implementation class AddShowControllern
 */
@WebServlet("/AddShowServlet")
public class AddShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "";
		  IAdminService adminService = new AdminServiceImpl();
		  int showId = Integer.parseInt(request.getParameter("showId"));
		  String showName = request.getParameter("showName");
		  int movieId = Integer.parseInt(request.getParameter("movieId"));
		  int theatreId = Integer.parseInt(request.getParameter("theatreId"));
		  int screenId = Integer.parseInt(request.getParameter("screenId"));
		  java.util.Date startTime,endTime;
		  int finaltime = 0;
		  Show show = new Show();
		  String movieName="";
		  try {
			  movieName = adminService.getMovieNameById(movieId);
		  }catch (OMTSException e) {
			  
		  }
		show.setMovieName(movieName);
		try {
			startTime = new SimpleDateFormat("HH:mm").parse(request.getParameter("stime"));
			endTime = new SimpleDateFormat("HH:mm").parse(request.getParameter("etime"));
			java.sql.Time showStartTime =  new java.sql.Time(startTime.getTime());
			java.sql.Time showEndTime =  new java.sql.Time(endTime.getTime());
			  
			System.out.println(startTime+" "+endTime);
			Long t = startTime.getTime() - endTime.getTime();
			  long difference_In_Time = startTime.getTime() - endTime.getTime(); 
			  long difference_In_Minutes = (difference_In_Time  / (1000 * 60)) % 60 ;
			  long difference_In_Hours = (difference_In_Time  / (1000 * 60 * 60)) % 24;
			  int hourinmin = 0;
			  if(difference_In_Hours != 0 ) {
				 hourinmin = (int) (difference_In_Hours * 60);
			  }
			 finaltime = (int)difference_In_Minutes+hourinmin;
			  if(finaltime < 0 ) {
				  finaltime = finaltime*-1;
			  }
			  System.out.println(finaltime);
			  show.setShowId(showId);
			  show.setShowName(showName);
			  show.setShowStartTime(showStartTime);
			  show.setShowEndTime(showEndTime);
			  show.setMovieId(movieId);
			  show.setTheatreId(theatreId);
			  show.setScreenId(screenId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		int len = adminService.getMovieLength(movieId);
		  System.out.println(len);
		  if(len ==  finaltime) {
			  System.out.println("Equal time");
		  } else {
			 message += "Show Duration is not same as movie length. ";
		  }
		  String existShow = adminService.checkShowNameandScreenId(showName, screenId);
		  System.out.println("exist show" + existShow);
		  if(existShow.length()==0) {
			  System.out.println("You can enter");
		  }else {
			message += "Show is already available at this time";  
		  }
		 List<Integer> sList = adminService.getScreenFromMovieAndTheatre(theatreId, movieId);
		 System.out.println("sList" + sList +" list contains " + sList.contains(screenId));
		 if(sList.contains(screenId)) {
			 System.out.println("screen is there");
		 }else {
			 message += "TheatreId, ScreenId and MovieId do not match"; 
		 }
		 System.out.println(sList);
		 if((sList.contains(screenId) && (len == finaltime) &&(existShow.length()==0))){
			 System.out.println("all conditions true");
			 int rowsInserted = adminService.addShow(show);
			 System.out.println(rowsInserted);
			 if(rowsInserted > 0) {
			  request.setAttribute("message", "Successful");
			  RequestDispatcher rd = request.getRequestDispatcher("displayShows.jsp");
			  rd.forward(request, response);
			 } else  {
				 //request.setAttribute("message", "Not Successful Id already exists"); 
				 message+= "Show Id already exists";
			 }
			// RequestDispatcher rd = request.getRequestDispatcher("time.jsp");
			 //rd.forward(request, response);
		 }else {
			 //message += "TheatreId, ScreenId and MovieId do not match.Try Again";
			 System.out.println(message);
			 //request.setAttribute("message", message);
		 }
		}catch(OMTSException e) {
			message+= "Show Id already exists";
			System.err.println(e);
		}
		 request.setAttribute("message", message);
		 RequestDispatcher rd = request.getRequestDispatcher("addShow.jsp");
		 rd.forward(request, response);

	}

}
