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
body {
	margin:0;
}
.bgpic {
	background-image: url("background.jpg");
	height: 100vh;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
.header {
	overflow: hidden;
	background-color: #291f04;
	padding: 5px 5px;
	opacity: 1;
	height:9%;
}
.header.logout {
	background-color: #291f04;
	color: white;
	left:95%;
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
	margin-left: 25%;
	margin-top: 2%;
	border: 2px;
	background-color:#e3dddc;
	style="overflow-y:auto;
}
th {
	font-size:30px;
}
td {
	font-size:20px;
	align:center
}
tr:hover {background-color:#f5f5f5;}
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
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("username")==null)
      response.sendRedirect("index.jsp");

  %> 

<% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
         }
      }
%>
</form>
	 <div class="header">
		    <a href="index.jsp" class = "logout" align="right">
		  	<img src="logout.png" alt="logout button" style="width:60px;height:55px;border:0;float:right">
		    </a>
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
	<table align="center" border=1>
	  		<% 
	  		IUserService userService = new UserServiceImpl();
			List<Movie> moviesList = userService.getAllMovies();
		for(Movie movie : moviesList) {
			String movieName = movie.getMovieName();
			int movId = movie.getMovieId();
			%>
			
	<tr><th><%= movieName%></th><td><a href="MovieDetailsServlet?movieId=<%= movId%>">View Movie Details</a></td></tr>
	<% } %>
	</table> 
	</form>
	</div>
	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>  
</body>
</html>