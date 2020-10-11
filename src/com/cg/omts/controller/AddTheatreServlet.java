package com.cg.omts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;

/**
 * Servlet implementation class AddTheatreServlet
 */
@WebServlet("/AddTheatreServlet")
public class AddTheatreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTheatreServlet() {
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
		//doGet(request, response);
		String theatreName = request.getParameter("theatreName");
		int theatreId = Integer.parseInt(request.getParameter("theatreId"));
		String theatreCity = request.getParameter("theatreCity");
		String managerName = request.getParameter("managerName");
		String managerContact = request.getParameter("managerContact");
		Theatre theatre = new Theatre();
		theatre.setTheatreName(theatreName);
		theatre.setTheatreId(theatreId);
		theatre.setTheatreCity(theatreCity);
		theatre.setManagerName(managerName);
		theatre.setManagerContact(managerContact);
		IAdminService adminService = new AdminServiceImpl();
		try {
			adminService.addTheatre(theatre);
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
