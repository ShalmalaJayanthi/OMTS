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
	<form method = "post" action = "AddScreenServlet" align = "center">
		<table align = "center">
			<h3><caption>Enter the Screen Details</caption></h3>
			<tr><td>Screen Id<td><input type="number" name = "screenId" required>
			<tr><td>Screen Name<td><input type = "text" name = "screenName" required>
			<tr><td>Screen Rows<td><input type = "number" name = "screenRows" required>
			<tr><td>Screen Columns<td><input type = "number" name = "screenColumns" required>
			<tr colspan="2" align = "centre"><td><input type = "submit" value = "Submit">
			
		</table>
	</form>

</body>
</html>