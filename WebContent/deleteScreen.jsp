<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action = "DeleteScreenServlet">
	<input type = "number" name = "screenId" placeholder = "Enter Screen ID"></br>
			<input type = "submit" value = "Submit">
	<c:if test="${displayDetails != null}">
		<table border="1">
			<tr><th>Screen ID<th>Screen Name<th>Theatre ID<th>Theatre Name<th>Theatre City</tr>
			
			
			</br></br>
			<c:forEach items="${displayDetails}" var="details">
							<tr>
					<td><c:out value = "${details.screenId}"></c:out>
					<td><c:out value = "${details.screenName}"></c:out>
					<td><c:out value = "${details.theatreId}"></c:out>
					<td><c:out value = "${details.theatreName}"></c:out>
					<td><c:out value = "${details.theatreCity}"></c:out>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</form>

</body>
</html>