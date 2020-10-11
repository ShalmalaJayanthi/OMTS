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
Enter Theater id : <input type="number" name = "theatreId">
<br>
Enter Theater name :  <input type="text" name="theatreName">
<br>
Enter Theater city: <input type="text" name = "theatreCity">
<br>
Enter Manager name: <input type="text" name="managerName">
<br>
Enter Manager contact: <input type="number" name="managerContact">
<br>
<input type="submit" value = "Insert Data">
</form>
</body>
</html>