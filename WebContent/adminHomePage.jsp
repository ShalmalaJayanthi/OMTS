<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
            out.print("Hello, " + id + "  Welcome to ur Profile");
         }
      } 
%>
<form action="./LogoutServlet" method="post">
      <input type="submit" value="Logout">
</form>

<a href="addTheatre.jsp">Add Theatre</a>
		<a href="deleteTheatre.jsp">Delete Theatre</a>
		<a href= "addMovie.jsp">Add Movie</a>
		<a href = "DeleteMovieServlet">Delete Movie</a>
		<a href = "addScreen.jsp">Add Screen</a>
		<a href = "DeleteScreenServlet">Delete Screen</a>
		<a href="addShow.jsp">Add Show</a>
		<a href="deleteShow.jsp">Delete Show</a>
</body>
</html>