<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			
				Movie Id <c:out value="${movie.movieId}" /><br>
				Movie Name <c:out value="${movie.movieName}" /><br>
				Movie Genre <c:out value="${movie.movieGenre}" /><br>
				Movie Director <c:out value="${movie.movieDirector}" /><br>
				Movie Length <c:out value="${movie.movieLength}" /><br>
				Language <c:out value="${movie.language}" /><br>
				Movie Release Date <c:out value="${movie.movieReleaseDate}" /><br>
				<form action="BookingController" method="post">
					<input type = "hidden" name= "action"  value = "UpdateServlet">
					<input type="text" name="movieId" value="${movie.movieId}">
					<input type = "hidden" value = "${movie.movieId } name = "movieId">
					<input type = "submit" value = "BOOK">
				</form>
</body>
</html>