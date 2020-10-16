package com.cg.omts.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Screen;

@WebServlet("/AddScreenServlet")
public class AddScreenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int screenId = Integer.parseInt(request.getParameter("screenId"));
		String screenName = request.getParameter("screenName");
		int screenRows = Integer.parseInt(request.getParameter("screenRows"));
		int screenColumns = Integer.parseInt(request.getParameter("screenColumns"));
		
		Screen screen = new Screen(screenId, screenName, screenRows, screenColumns);
		
		ServletContext context = getServletContext();
		context.setAttribute("screen", screen);
		request.getRequestDispatcher("getTheatreDetails.jsp").forward(request, response);
		
	}

}
