<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Displaying Movie Details</title>
</head>
<body>
	<div class="display">
	<table align="center" border=1>
	<tr><td>Movie Id</td><td><c:out value="${movie.movieId}" /></td></tr>
	<tr><td>Movie Name</td><td><c:out value="${movie.movieName}"/></td></tr>
	<tr><td>Movie Genre</td><td><c:out value="${movie.movieGenre}" /></td></tr>
	<tr><td>Movie Director</td><td><c:out value="${movie.movieDirector}" /></td></tr>
	<tr><td>Movie Length</td><td><c:out value="${movie.movieLength}" /></td></tr>
	<tr><td>Language</td><td><c:out value="${movie.movieLength}" /></td></tr>
	<tr><td>Movie Release Date</td><td><c:out value="${movie.movieReleaseDate}" /></td></tr>
	</table>
	</div>
	<div>
	<button name="book ticket">
		<a href=""></a>
	</button>
	</div>
</body>
</html>