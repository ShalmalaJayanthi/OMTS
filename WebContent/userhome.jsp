<%@page import="java.util.Set"%>
<%@page import="com.cg.omts.service.UserServiceImpl"%>
<%@page import="com.cg.omts.service.IUserService"%>
<%@page import="com.cg.omts.dto.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie </title>
<script>
	function selectCity() {
		var city= document.getElementById('city').value;
		 window.location.href="./DisplayMoviesToUser?city="+city;
	}
</script>
</head>
<body>
	<form action="/DisplayMoviesToUser" method="get">
		<select name="city" id="city" onchange="selectCity()">
		<option value="">Select city</option>
		<option value="Hyderabad">HYDERABAD</option>
		<option value = "Warangal">WARANGAL</option>
		<option value = "Nizambad">NIZAMBAD</option>
		</select>
		<p id="demo"></p>
		<br><br><br>
	<table align="center">
	  <%
	  	if(request.getAttribute("movie") != null) {
	  		Set<Movie> moviecityList = (Set<Movie>)request.getAttribute("movie");
	  		for(Movie movie : moviecityList) {
				String movieName = movie.getMovieName();
				int movId = movie.getMovieId();
				%>
				<tr><td><%= movieName%></td><td></td><td><a href="MovieDetailsServlet?movieId=<%= movId%>">View Movie Details</a></td></tr>
	  		<% 
	  		}
	  	}else {
	  		IUserService userService = new UserServiceImpl();
	  	
			List<Movie> moviesList = userService.getAllMovies();
		//List<Integer> movieIdList = userService.getMovieDetails(movieId);
		for(Movie movie : moviesList) {
			String movieName = movie.getMovieName();
			int movId = movie.getMovieId();
	%>
	
	<tr><td><%= movieName%></td><td></td><td><a href="MovieDetailsServlet?movieId=<%= movId%>">View Movie Details</a></td></tr>
	<% }} %>
	</table>
	</form>  
</body>
</html>