<%@ page import = "com.cg.omts.dto.Screen" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<%
	if(request.getAttribute("screenId") != null) {
		int screenId = Integer.parseInt((String)(request.getAttribute("screenId")));
		String screenName = (String)request.getAttribute("screenName");
		int screenRows = Integer.parseInt((String)request.getAttribute("screenRows"));
		int screenColumns = Integer.parseInt((String)request.getAttribute("screenColumns"));
		request.setAttribute("screenName", screenName);
		request.setAttribute("screenRows", screenRows);
		request.setAttribute("screenColumns", screenColumns);
	}
	
	%>
	<form method = "post" action = "GetTheatreDetails" align = "center">
	<input type = "hidden" name = "screen" value = <%=request.getAttribute("screen") %>>
	Select Theatre City : 
		<select name = "theatreCity">
			<option value = "Hyderabad">Hyderabad</option>
			<option value = "Warangal">Warangal</option>
			<option value = "Adilabad">Adilabad</option>
			<option value = "Nizambad">Nizamabad</option>
			<option value = "Khammam">Khammam</option>
		</select>
		<input type = "submit" value = "Submit">
	</form>
		
	</body>
</html>