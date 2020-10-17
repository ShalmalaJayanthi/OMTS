package com.cg.omts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dao.AdminDaoImpl;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;


@WebServlet("/SelectTheatreIdDetails")
public class SelectTheatreIdDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdminService adminService = new AdminServiceImpl();
		String theatreCity = request.getParameter("theatreCity");
		int theatreId = Integer.parseInt(request.getParameter("theatreId"));
		System.out.println("Theatre ID in SelectTheatreIdDetails Controller" + theatreId);
		Boolean isAdded = false;
		
		ServletContext context=getServletContext();  
		Screen screen = (Screen) context.getAttribute("screen");
		
		PrintWriter out = response.getWriter();
		String message;
		try {
			if(adminService.isTheatreIdExists(theatreId) && adminService.checkTheatreIdInCity(theatreId, theatreCity)) {
				isAdded = adminService.addScreen(screen, theatreId);
				if(isAdded) {
					message = "Successfully added screen details with ID: "+ screen.getScreenId();
					request.setAttribute("message", message);
					request.getRequestDispatcher("addScreen.jsp").forward(request, response);
				} else {
					message = "Failed to add Screen details with ID: "+screen.getScreenId();
					request.setAttribute("message", message);
					request.getRequestDispatcher("addScreen.jsp").forward(request, response);
				}
			} else {
				message = "Enter valid theatre ID";
				request.setAttribute("message", message);
				request.getRequestDispatcher("addScreen.jsp").forward(request, response);
			}
		} catch (OMTSException e) {
			System.out.println("Couldn't add the details\n" + e);
			
		}
	}

}
