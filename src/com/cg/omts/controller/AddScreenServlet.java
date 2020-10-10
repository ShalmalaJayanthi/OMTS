package com.cg.omts.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Screen;

@WebServlet("/AddScreenServlet")
public class AddScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer screenId = Integer.parseInt(request.getParameter("screenId"));
		//Integer theatreId = Integer.parseInt(request.getParameter("theatreId"));
		String screenName = request.getParameter("screenName");
		String date = request.getParameter("movieEndDate");
		Date movieEndDate = Date.valueOf(date);
		Integer screenRows = Integer.parseInt(request.getParameter("screenRows"));
		Integer screenColumns = Integer.parseInt(request.getParameter("screenColumns"));
		
		Screen screen = new Screen(screenId, screenName, movieEndDate, screenRows, screenColumns);
		
		ServletContext context = getServletContext();
		context.setAttribute("screen", screen);
		request.getRequestDispatcher("getTheatreDetails.jsp").forward(request, response);
		/*IAdminDAO adminDao = new AdminDao();
		Boolean isAdded = adminDao.addScreen(screen);
		if(isAdded) {
			System.out.println("Screen is successfully added");
			request.getRequestDispatcher("addScreen.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("adminHomePage.html").forward(request, response);
		}*/
	}

}
