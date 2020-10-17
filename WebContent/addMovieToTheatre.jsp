<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form method = "post" action = "AddMovieToTheatre" align = "center">
		<input type = "hidden" name = "theatreCity" value = <%=request.getAttribute("theatreCity") %>>
		<input type = "number" name = "theatreId" placeholder = "Enter Theatre ID" required></br>
		<input type = "number" name = "movieId" placeholder = "Enter Movie ID" required></br></br>
		<input type = "submit" value = "Submit"></br></br>
			
	<c:if test="${theatreDetails != null}">
		<table border="1"  align = "left">
			<caption>Theatre Details</caption>
			<tr><th>Theatre ID<th>Theatre Name</tr>
			
					<c:forEach items="${theatreDetails}" var="details"> 
							<tr>
					<td><c:out value = "${details.theatreId}"></c:out>
					<td><c:out value = "${details.theatreName}"></c:out>
										
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${movieDetails != null}">
		<table border="1" align = "right">
			<caption>Movie Details</caption>
			<tr><th>Movie ID<th>Movie Name</tr>
			
					<c:forEach items="${movieDetails}" var="details"> 
							<tr>
					<td><c:out value = "${details.movieId}"></c:out>
					<td><c:out value = "${details.movieName}"></c:out>
										
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	</form>

</body>
</html>