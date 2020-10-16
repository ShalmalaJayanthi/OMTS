package com.cg.omts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IAdminService;
import com.cg.omts.service.IUserService;
import com.cg.omts.service.UserServiceImpl;

@WebServlet("/paymentController")
public class PaymentProcessController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub.
		PrintWriter out = resp.getWriter();
		int accountNo=Integer.parseInt(req.getParameter("acc"));
		int cvv =Integer.parseInt(req.getParameter("cvv"));
		String password=req.getParameter("pass");
		
		IUserService user = new UserServiceImpl();
		
		try {
			
			Boolean flag= user.validatePayment(accountNo, cvv, password);
			if(flag==true) {
				int ticketId = 1;
				int userId = 1;
				int totalCost = 1000; 
				int transactionId = GenerateTransactionID.getTransactionId();
				System.out.println("Transaction Id generated id: "+transactionId);
				Transaction transaction = new Transaction(transactionId, accountNo, totalCost);
				System.out.println("Transaction obj in paymentprocess: " + transaction);
				
				int isTransact= user.addTransaction(transaction, ticketId, userId);
				System.out.println("is Transaction done: "+ isTransact);
				//add transaction (get tran id) -- completed
				//Booking id=customerid+theatreid+movieid+showid;
				int theatreId =1, movieId = 1, showId = 1; 
				
				/*
				 * DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss"); Date dateobj = new
				 * Date(); System.out.println(df.format(dateobj));
				 */
				String bookingId1 = "" + userId + theatreId + movieId + showId;
				int bookingId = Integer.parseInt(bookingId1);
				
				
				Date todayDate = new Date(System.currentTimeMillis());
				System.out.println("Today's date : "+ todayDate);
				//call addbooking
				
				Booking booking = new Booking(bookingId, todayDate);
				int isBooked = user.addBooking(booking, ticketId, transactionId);
				
				//setSeatstatus to booked.
				
				//setTicketstatus to booked.
				if(isBooked > 0) {
					user.setTicketStatus(ticketId, "BOOKED");
				//user.setSeatStatus(seatId, "BOOKED");
				
					List<Integer> seatList =  user.getSeatsByTicket(ticketId);
					int seatListLength = seatList.size();
					
					for(Integer seatId: seatList) {
						user.setSeatStatus(seatId, "BOOKED");
		
					}
					
					HttpSession session = req.getSession();
					session.setAttribute("booking", booking);
					session.setAttribute("transaction", transaction);
					resp.sendRedirect("bookingConfirmation.jsp");
					}
			}else
				out.println("Invalid Credentials");
			
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
