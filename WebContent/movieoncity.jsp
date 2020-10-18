<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cg.omts.service.UserServiceImpl"%>
<%@page import="com.cg.omts.service.IUserService"%>
<%@page import="com.cg.omts.dto.Movie"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie On City</title>
</head>
<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	color: white;
	background-color: #291f04;
	margin-top: 100%;
	width: 100%;
	height: 6%;
	font-size: 200%;
	text-align: center;
	opacity: 1;
}
.header {
	overflow: hidden;
	background-color: #291f04;
	padding: 5px 5px;
	opacity: 1;
	height:5%;
}
.header.logout {
	background-color:#291f04;
	color: white;
	left:95%;
}
.bgpic {
	background-image: url("background.png");
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
table {
	width: 50%;
	margin-left: 20%;
	margin-top: 5%;
}
th {
	font-size:20px;
}
td {
	font-size:20px;
}
.btn {
	width: 40px;
	align: center;
	color: green;
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
<body class="bgpic">
	<div class="header">
		    <a href="userhome.jsp" class = "back" align="right">
		  	<img src="back.png" alt="back button" style="width:60px;height:55px;border:0;">
		    </a>
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
	<h3 align="center">Selected City : <%= request.getAttribute("city")%></h3>
	  <%
	  	  	if(request.getAttribute("movie") != null && request.getAttribute("movie") != "All Cities") {
	  		Set<Movie> moviecityList = (Set<Movie>)request.getAttribute("movie");
	  		for(Movie movie : moviecityList) {
				String movieName = movie.getMovieName();
				int movId = movie.getMovieId();
				%>
				<tr><th><%= movieName%></th><td></td><td><a href="MovieDetailsServlet?movieId=<%= movId%>">View Movie Details</a></td></tr>
	  		<% 
	  		}
	  	}else if(request.getAttribute("movie") == "All Cities"){
	  		IUserService userService = new UserServiceImpl();
			List<Movie> moviesList = userService.getAllMovies();
		for(Movie movie : moviesList) {
			String movieName = movie.getMovieName();
			int movId = movie.getMovieId();
	%>
	
	<tr><th><%= movieName%></th><td></td><td><a href="MovieDetailsServlet?movieId=<%= movId%>">View Movie Details</a></td></tr>
	<% }} %>
	</table>
	</form>
	</div>
	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>
</body>
</html>