<%@ page import = "java.util.ArrayList" %>
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
	
		<form method = "post" action = "./SelectTheatreIdDetails">
		<input type = "number" name = "theatreId" placeholder = "Enter Theatre ID"></br>
			<input type = "submit" value = "Submit">
			
	<c:if test="${theatreDetails != null}"><!--  // here i couldn't access that value -->
		<table border="1">
			<tr><th>Theatre ID<th>Theatre Name</tr>
			
					<c:forEach items="${theatreDetails}" var="details"> 
							<tr>
					<td><c:out value = "${details.theatreId}"></c:out>
					<td><c:out value = "${details.theatreName}"></c:out>
										
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	</form>
</body>
</html>