<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Show</title>
</head>
<body>
<h1>Enter Details to Register Show</h1>
<%if(request.getAttribute("message")!= null)  { %>
<h1><%= request.getAttribute("message")%></h1>
<%} %>
<br>
<form method="post" action="./AddShowServlet">
Enter Show Id : 
<input type="text" name="showId" pattern="[1-9]{1}[0-9]{7,}" title="Screen Id should be minimum 8 digit" required>
<br>
<br>
Enter Show Name:<select id="showType" name="showName" >
<option value="Morning">Morning</option>
<option value="Matinee">Matinee</option>
<option value="Evening">Evening</option>
<option value="Night"> Night</option>
</select>
<br>
<p id='print'></p>
<br>
Enter Show Start Time:
<input type="time" name="stime" required>
<br>
<br>
Enter Show End Time :
<input type="time" name="etime" required>
<br>
<br>
Enter Theatre Id:
<input type="text" name="theatreId" pattern="[2]{1}[0-9]{3,}" title="Theatre Id should start with number 2 and minimum of 4 digits" required>
<br>
<br>
Enter Movie Id :
<input type="text" name="movieId" pattern="[3]{1}[0-9]{3,}" title="Movie Id should start with number 3 and minimum of 4 digits" required>
<br>
<br>
Enter Screen Id :
<input type="text" name="screenId"pattern="[4]{1}[0-9]{3,}" title="Screen Id should start with number 4 and minimum of 4 digits" required>
<br>
<br>
<input type="submit" value="Enter Show">
</form>
</body>
</html>