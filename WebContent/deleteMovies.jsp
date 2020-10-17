<%@ page import = "java.util.*" %>
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
	<%
		String message = (String)request.getAttribute("message");
		if(message != null)
			out.print(message);
	%>
	
	<form method = "post" action = "DeleteMovieServlet" align = "center">
		<input type = "number" name = "movieId" placeholder = "Enter Movie ID" required></br>
		<input type = "submit" value = "Submit"></br></br>
	<c:if test="${displayDetails != null}">
		<table border="1" align = "center">
			<caption>Movie Details</caption>
			<tr><th>ID<th>Name<th>Genre<th>Director<th>Language</tr>
			
			
			</br></br>
			<c:forEach items="${displayDetails}" var="details">
							<tr>
					<td><c:out value = "${details.movieId}"></c:out>
					<td><c:out value = "${details.movieName}"></c:out>
					<td><c:out value = "${details.movieGenre}"></c:out>
					<td><c:out value = "${details.movieDirector}"></c:out>
					<td><c:out value = "${details.language}"></c:out>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</form>
</body>

</html>