<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Add Theatre </h1>
<form method="post" action="./AddTheatreServlet">
Enter Theater id : <input type="text" name = "theatreId" pattern="[2]{1}[0-9]{3,}" title="Theatre Id should start with number 2 and minimum of 4 digits">
<br>
<br>
Enter Theater name :  <input type="text" name="theatreName">
<br>
<br>
Enter Theater city: <input type="text" name = "theatreCity">
<br>
<br>
Enter Manager name: <input type="text" name="managerName">
<br>
<br>
Enter Manager contact: <input type="text" name="managerContact" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit phone number">
<br>
<br>
<input type="submit" value = "Insert Data">
</form>
</body>
</html>