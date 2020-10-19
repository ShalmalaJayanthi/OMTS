
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<form action = "AddMovieServlet" method = "post" align = "center">
		<table align = "center">
			<caption>Enter Movie Details</caption>
			<tr><td>Movie Id</td><td><input type="number" name = "movieId" required title = "Movie ID must contain only digits"></td></tr>
			<tr><td>Movie Name</td><td><input type="text" name = "movieName" required></td></tr>
			<tr><td>Movie Genre</td><td><input type="text" name = "movieGenre" required></td></tr>
			<tr><td>Movie Director</td><td><input type= "text" name = "movieDirector" required></td></tr>
			<tr><td>Movie Length</td><td><input type= "number" name = "movieLength" required></td></tr>
			<tr><td>Movie Language</td><td><input type= "text" name = "movieLanguage" required></td></tr>
			<tr><td>Movie Release Date</td><td><input type="date" name = "movieReleaseDate" required></td></tr>
			<!-- <tr><td>Upload Movie Image</td><td><input type = "file" name = "uploadImg" required></td></tr> -->
			<tr ><td colspan="2" align = "center"><button type = "submit"> Submit </button>
		</table>
	</form>
	
	<div class="footer" style="font-size: 20px">
<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
India Ltd.
</div> 
</body>
</html>