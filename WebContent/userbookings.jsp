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
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	width: 200px;
	font-size: 60%;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #a89e8a;
	font-size: 200%;
}

.active {
	background-color: #a89e8a;
}

.loginform {
	margin-top: 10%;
	background: #a89e8a;
	width: 26%;
	height: 50%;
	border-radius: 7%;
	opacity: 0.8;
	color: white;
	align: center;
	margin-left: 35%;
	display: none;
	position: absolute;
	box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0
		rgba(0, 0, 0, .19);
	border: 3px solid #f1f1f1;
}

.header {
	overflow: hidden;
	background-color: #a89e8a;
	padding: 20px 10px;
	opacity: 0.8;
}

.header a {
	float: left;
	color: white;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 28px;
	line-height: 25px;
	border-radius: 4px;
}

.header a.logo {
	weight: 10;
	font-size: 40px;
}

.header a:hover {
	background-color: #a89e8a;
}

.header a.active {
	background-color: #a89e8a;
	color: white;
}

.header-right {
	float: right;
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

<body>
<div class="header">

		<ul>
			<li><a class="logo"><b>T-CKT</b></a></li>
			<div class="header-right">
				<li><a href="userhome.jsp" class="active"><b>Home </b></a></li>
				<li><a href="ViewBookingController" class="active"><b>My Bookings</b></a></li>
				<li><a class="active" href="index.jsp" onclick="login()"><b>Signout
					</b></a></li>
				
			</div>
		</ul>



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