<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Theatre</title>
</head>
<body>
<h1>
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
<% if(request.getAttribute("message")!=null) { %>
<%=request.getAttribute("message") %>
<%} %>
</h1>
<h1> Enter Theatre Details to Register </h1>
<br>
<form method="post" action="./AddTheatreController">
Enter Theater id : <input type="text" name = "theatreId" pattern="[2]{1}[0-9]{3}" title="Theatre Id should start with number 2 and of only 4 digits" required>
<br>
<br>
Enter Theater name :  <input type="text" name="theatreName" pattern= "[a-zA-Z]{1,}" title="Enter only alphabets" required>
<br>
<br>
Enter Theater city: <input type="text" name = "theatreCity" pattern="[a-zA-Z]{1,}" title="Enter only alphabets" required>
<br>
<br>
Enter Manager name: <input type="text" name="managerName" pattern="[a-zA-Z]{1,}" title="Enter only alphabets" required>
<br>
<br>
Enter Manager contact: <input type="text" name="managerContact" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit phone number" required>
<br>
<br>
<input type="submit" value = "Register Theatre">
</form>
</body>
</html>