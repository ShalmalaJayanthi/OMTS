<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Show</title>
</head>
<body>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("username")==null)
      response.sendRedirect("index.jsp");

  %> 

<% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
         }
      } 
%>
<form action="./LogoutServlet" method="post">
      <input type="submit" value="Logout">
</form>
<h1>Enter Details to Register Show</h1>
<%if(request.getAttribute("message")!= null)  { %>
<h1><%= request.getAttribute("message")%></h1>
<%} %>
<br>
<form method="post" action="./AddShowServlet">
Enter Show Id : 
<input type="text" name="showId" pattern="[5]{1}[0-9]{3}" title="Show Id should start with number 4 and of only 4 digit" required>
<br>
<br>
Enter Show Name:<select id="showType" name="showName" onchange="myFunction()">
 <option value="" selected disabled hidden>Choose here</option>
<option value="morning show">Morning</option>
<option value="matinee show">Matinee</option>
<option value="first show">First show</option>
<option value="second show">Second Show</option>
</select>
<br>

<br>
Enter Show Start Time:
<input type="time" id="stime" name="stime" required>
<br>
<br>
Enter Theatre Id:
<input type="text" name="theatreId" pattern="[2]{1}[0-9]{3}" title="Theatre Id should start with number 2 and of only 4 digits" required>
<br>
<br>
Enter Movie Id :
<input type="text" name="movieId" pattern="[3]{1}[0-9]{3}" title="Movie Id should start with number 3 and of only 4 digits" required>
<br>
<br>
Enter Screen Id :
<input type="text" name="screenId"pattern="[4]{1}[0-9]{3}" title="Screen Id should start with number 4 and of only 4 digits" required>
<br>
<br>
<input type="submit" value="Enter Show">
</form>
<script type="text/javascript">
function myFunction() {
  var x = document.getElementById("showType").value;
  console.log(x);
  if(x==='morning show') {
	  document.getElementById("stime").min="06:00"
	  document.getElementById("stime").max="09:00"
  } else if(x==='matinee show') {
	  document.getElementById("stime").min="10:00"
	  document.getElementById("stime").max="14:00"
  } else if(x==='first show') {
	  document.getElementById("stime").min="15:00"
	  document.getElementById("stime").max="19:00"
  } else {
	  document.getElementById("stime").min="20:00"
	  document.getElementById("stime").max="23:00"
  }
  //document.getElementById("num").min=89;
  //document.getElementById("starttime").min="07:00"
}
</script>

</body>
</html>