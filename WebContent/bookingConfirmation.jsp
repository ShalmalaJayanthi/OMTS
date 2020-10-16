<%@page import="com.cg.omts.dto.Transaction"%>
<%@page import="com.cg.omts.dto.Booking"%>
<%@page import="com.cg.omts.dto.Ticket"%>
<%@page import="com.cg.omts.dao.UserDaoImpl"%>
<%@page import="com.cg.omts.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Confirmation</title>
</head>
<body>
<center><h1>BOOKING CONFIRMATION</h1></center>
<center><h2>TICKET DETAILS</h2></center>

 <%
int ticketId=1;
IUserDao user = new UserDaoImpl();
Ticket ticket = user.getTicket(ticketId);
%>
<center>
<table>
<tr><td>Ticket ID: <td><%=ticket.getTicketId() %>
<tr><td>No Of Seats: <td><%=ticket.getNoOfSeats() %>
<tr><td>Ticket Status:<td> <%=ticket.getTicketStatus() %>
<tr><td>Screen Id:<td> <%=ticket.getScreenId() %>
<tr><td>Theatre Id:<td> <%=ticket.getTheatreId() %>
<tr><td>Show Id:<td><%=ticket.getShowId() %>
<tr><td>Movie Id:<td><%=ticket.getMovieId() %>
</table>
</center>
<% Booking booking = (Booking)session.getAttribute("booking");
System.out.println("In booking config transactioin obj is: "+booking);%>

<%--
<%
Booking booking = user.getBookingDetails(ticketId);


%>
--%>
<center>
<table>
<tr><td>Booking Id:<td><%=booking.getBookingId() %>
<tr><td>Booking Date:<td><%=booking.getBookingDate() %>

</table>
</center>
 
<% Transaction transaction = (Transaction)session.getAttribute("transaction");
System.out.println("In booking config transactioin obj is: "+transaction);%>
<center>
<tr><td>Transaction Id:<td><%=transaction.getTransactionId() %>
<tr><td>Account Number:<td><%=transaction.getAccountNumber() %>
<tr><td>Total Amount:<td><%=transaction.getTotalAmount() %>
</center> 


</html>