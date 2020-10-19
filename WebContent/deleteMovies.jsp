<%@ page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	body {
	margin:0;
	}
	.bgpic {
	background-image: url("background.jpg");
	height: 100vh;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	}
	.header {
	overflow: hidden;
	background-color: #291f04;
	padding: 5px 5px;
	opacity: 1;
	height:9%;
	}
	.header.logout {
	background-color: #291f04;
	color: white;
	left:95%;
	}
	
	.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	color: white;
	background-color:#291f04;
	margin-top: 100%;
	width: 100%;
	height: 6%;
	font-size: 200%;
	text-align: center;
	opacity: 1;
	}
	table {
	width: 50%;
	margin-left: 25%;
	margin-top: 2%;
	border: 2px;
	background-color:#e3dddc;
	style="overflow-y:auto;
	}
	th {
	font-size:30px;
	}
	td {
	font-size:20px;
	align:center
	}
	tr:hover {background-color:#f5f5f5;}
	.selectclass {
	width:250px;
	height:35px;
	margin-right:81%;
	font-size:15px;
	background-color:#e3dddc;
	}
	</style>
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
</form>
<div class="header">
	<a href="adminHomePage.jsp" class = "back" align="right">
		 <img src="back.png" alt="back button" style="width:20px;height:25px;border:0;">
   </a>
   <a href="index.jsp" class = "logout" align="right">
  <img src="logout.png" alt="logout button" style="width:60px;height:55px;border:0;float:right">
   </a>
</div>

	<%
		String message = (String)request.getAttribute("message");
		if(message != null)
			out.print(message);
	%>
	
	<form method = "post" action = "DeleteMovieServlet" align = "center">
		<input type = "number" name = "movieId" placeholder = "Enter Movie ID" required></br>
		<input type = "submit" value = "Submit"></br></br>
	<c:if test="${displayDetails != null}">
		<table border="1" align = "center">
			<caption>Movie Details</caption>
			<tr><th>ID<th>Name<th>Genre<th>Director<th>Language</tr>
			
			
			</br></br>
			<c:forEach items="${displayDetails}" var="details">
							<tr>
					<td><c:out value = "${details.movieId}"></c:out>
					<td><c:out value = "${details.movieName}"></c:out>
					<td><c:out value = "${details.movieGenre}"></c:out>
					<td><c:out value = "${details.movieDirector}"></c:out>
					<td><c:out value = "${details.language}"></c:out>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</form>
	<div class="footer" style="font-size: 20px">
<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
India Ltd.
</div>
</body>
<div class="footer" style="font-size: 20px">
<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
India Ltd.
</div>
</html>