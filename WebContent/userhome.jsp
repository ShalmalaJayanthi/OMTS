<%@page import="com.cg.omts.service.UserServiceImpl"%>
<%@page import="com.cg.omts.service.IUserService"%> 
<%@page import="com.cg.omts.dto.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserHome </title>
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
table {
	width: 50%;
	margin-left: 20%;
	margin-top: -1%;
	border: 2px;
}
th {
	font-size:30px;
}
td {
	font-size:20px;
	align:center
}
.selectclass {
	width:250px;
	height:35px;
	margin-right:81%;
	font-size:15px;
	background-color:#e3dddc;
}
</style>
<script>
	function selectCity() {
		var city= document.getElementById('city').value;
		 window.location.href="./DisplayMoviesToUser?city="+city;
	}
</script>
</head>
<body class="bgpic">
<%-- <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("username")==null)
      response.sendRedirect("index.jsp");

  %> --%>

<% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
         }
      }
%>
</form>
	 <div class="header">
	 		
	 		<a href="index.jsp" class = "logout" align="right"><img src="logout.png" alt="logout button" style="width:20px;height:20px;border:0;float:right"></a>
		    
			<a href="ViewBookingController" class="active" ><b>My Bookings</b></a>
		    <a href="userhome.jsp" class="active" ><b>User Home </b></a>
		  	<a class="logo" style="width:100px;height:20px;border:0;float:left">T-CKT</a>
		    
	</div> 
	
	<div class="userhome" id="userhome">
	<form action="/DisplayMoviesToUser" method="get" align="center">
		<select name="city" id="city" onchange="selectCity()" class="selectclass">
		<option value="-1" selected disabled align="center">Select city</option>
		<option value="All Cities" align="center">ALL CITIES</option>
		<option value="Hyderabad" align="center">HYDERABAD</option>
		<option value = "Warangal" align="center">WARANGAL</option>
		<option value = "Nizambad" align="center">NIZAMBAD</option>
		</select>
	<!-- <iframe height="400" width="700"> -->
	<table align="center" border=1>
	  		<% 
	  		IUserService userService = new UserServiceImpl();
			List<Movie> moviesList = userService.getAllMovies();
		for(Movie movie : moviesList) {
			String movieName = movie.getMovieName();
			int movId = movie.getMovieId();
			%>
	<tr><th><%= movieName%></th><td></td><td><a href="MovieDetailsServlet?movieId=<%= movId%>">View Movie Details</a></td></tr>
	<% } %>
	</table>
	<!-- </iframe> -->
	</form>
	</div>
	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>  
</body>
</html>