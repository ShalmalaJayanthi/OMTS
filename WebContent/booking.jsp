<%@page import="com.cg.omts.service.UserServiceImpl"%>
<%@page import="com.cg.omts.service.IUserService"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.omts.dto.Screen"%>
<%@page import="java.util.ArrayList"%>
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
	<form action ="" method = "get" id = "" name = "theatreForm">
		<select name = "theatreId" onchange = "document.theatreForm.submit();" id = "selectedTheatre">
			<option value="-1" selected disabled>Select Theatre</option>
			<c:forEach items = "${theatresList}" var = "theatre">
				<option value = "${theatre.theatreId}">${theatre.theatreName}</option>
			</c:forEach>
		</select>
		<select name = "screenList">
			<%
				if(request.getAttribute("screenList") != null) {
					IUserService userService = new UserServiceImpl();
					List<Screen> screenList = (ArrayList<Screen>)request.getAttribute("screenList");
				}
			
			%>
		
		</select>
	</form>

</body>
</html>