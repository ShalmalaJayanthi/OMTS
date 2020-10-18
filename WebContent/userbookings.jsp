<%@page import="com.cg.omts.dto.Booking"%>
<%@page import="com.cg.omts.dto.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cg.omts.dto.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

.header a {
	float:right;
	color: white;
	padding: 12px;
	text-decoration: none;
	line-height: 25px;
	border-radius: 4px;
	display: block;
	color: white;
	text-align: right;
	width:0%;
	padding: 14px 20px;
	width: 200px;
	font-size: 180%;
}
a {
	float: left;
}

.header a:hover {
	background-color: #a89e8a;
	font-size: 200%;
}

.bgpic {
	background-image: url("background.png");
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
.header {
	overflow: hidden;
	background-color: #291f04;
	padding: 0px 0px;
	opacity: 1;
	height:4%;
	margin-top:0%;
}
.header a.logout {
	background-color: #291f04;
	color: white;

}
.header logo {
	weight: 10;
	color: white;
	font-size: 40px;
}
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	color: white;
	background-color:#291f04;
	margin-top: 100%;
	width: 100%;
	height: 6%;
	font-size: 200%;
	text-align: center;
	opacity: 1;
}

@media screen and (max-width: 500px) {
	.header a {
		float: none;
		display: block;
		text-align: left;
	}
	.header-right {
		float: none;
	}
}

.input {
	width: 170px;
	height: 30px;
	border-radius: 10px;
	background: rgba(255, 255, 255, .1);
	font-size: 15px;
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	color: white;
	background-color: #a89e8a;
	margin-top: 100%;
	width: 100%;
	height: 5%;
	font-size: 200%;
	text-align: center;
	opacity: 0.7;
}

</style>

<body class="bgpic">
 <div class="header">
	 		
	 		<a href="index.jsp" class = "logout" align="right"><img src="logout.png" alt="logout button" style="width:20px;height:20px;border:0;float:right"></a>
		    
			<a href="ViewBookingController" class="active" ><b>My Bookings</b></a>
		    <a href="userhome.jsp" class="active" ><b>User Home </b></a>
		  	<a class="logo" style="width:100px;height:20px;border:0;float:left">T-CKT</a>
		    
	</div> 
	<%
		List<Ticket> ticketList = new ArrayList<Ticket>();
	
		List<Transaction> transactionList = new ArrayList<Transaction>();
		List<Booking> bookingList = new ArrayList<Booking>();
		ticketList = (List<Ticket>)request.getAttribute("ticketList");
		transactionList = (List<Transaction>) request.getAttribute("transactionList");
		bookingList = (List<Booking>) request.getAttribute("bookingList");
		List<String> theatreNameList = new ArrayList<String>();
		List<String> movieNameList = new ArrayList<String>();
		List<String> showNameList = new ArrayList<String>();
		List<String> screenNameList = new ArrayList<String>();
		theatreNameList = (List<String>)request.getAttribute("theatreNameList");
		showNameList = (List<String>)request.getAttribute("showNameList");
		screenNameList = (List<String>)request.getAttribute("screenNameList");
		movieNameList = (List<String>)request.getAttribute("movieNameList");
	%>
	
	<table border="1" align ="center">
		<tr>
			
			<th>TICKETID</th>
			<th>NUMBER OF SEATS</th>
			<th>THEATRE NAME</th>
			<th>MOVIE NAME</th>
			<th>SHOW NAME</th>
			<th>SCREEN NAME</th>
			<th>TOTAL AMOUNT</th>
			<th>BOOKING DATE</th>
			<th>SEAT NUMBERS</th>
			
		</tr>
		<%	for(int i = 0; i < ticketList.size(); i++){
		%> 		<tr>
					<td><%=ticketList.get(i).getTicketId() %>
					<td><%=ticketList.get(i).getNoOfSeats() %>
					<td><%=theatreNameList.get(i) %> 
					<td><%=movieNameList.get(i) %>
					<td><%=showNameList.get(i) %>
					<td><%=screenNameList.get(i)%>
					<td><%=transactionList.get(i).getTotalAmount() %>
					<td><%=bookingList.get(i).getBookingDate() %>
					<td><a href="CancelBookingController?ticketId=<%=ticketList.get(i).getTicketId()%>">cancel</a>
				</tr>	
			<%
			}%>
			
	</table>
<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>
</body>
</html>