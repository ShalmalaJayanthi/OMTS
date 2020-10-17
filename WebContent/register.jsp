<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1>Registration Form</h1>
<form method="post" action="RegisterServlet">
	<table >
		<tr>
			<td>Customer Name</td><td><input type="text" name="name" required></td>
		</tr>
		<tr>
			<td>Customer Id</td><td><input type="number" name="custid"></td>
		</tr>
		<tr>
			<td>Password</td><td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td>Date of Birth</td><td><input type="date" name="custdob"></td>
		</tr>
		<tr>
			<td>Contact Number</td><td><input type="text" name="contact"></td>	

		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="submit"></td>
		</tr>
		
	</table>
</form>

</body>
</html>