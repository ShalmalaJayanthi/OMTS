<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
background: url(bg.jpg);
font-size:50px;
}
.container {
width:900px;
height:900px;
margin:auto;
background: url(bg.jpg);
}
.container1{
positon:auto;
width:90%;
height:22%;

background: url(bg.jpg);

}
.box1 {
width:40%;
height:85%;
margin-left:99px;
margin-top:25px;
float:left;
opacity:0.95;
background: url(gradient.jpg);
background-size: 500px 170px;
border-radius: 35px;
}
.box2 {
width:40%;
height:85%;
float:right;
margin-top:25px;
margin-right:1px;
background: url(gradient.jpg);
opacity:0.95;
background-size: 500px 170px;
border-radius: 35px;
}
.box3 {
width:40%;
height:85%;
margin: 0 auto;
padding: 10px;
left:5%;
position: relative;
background: url(gradient.jpg);
opacity:0.95;
background-size: 700px 190px;
border-radius: 35px;
}
#txt1 {
text-align:center;
font-size:45px;
}
a:link {
color:white;
}
a:visited {
color:white;
}
.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
.button {
  background-color: #4CAF50;
  float:right;
  border: none;
  color: white;
  padding: 14px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 17px;
  cursor: pointer;
}
body {
margin:0px;
}
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	color: white;
	background-color: #a89e8a;
	margin-top: 100%;
	width: 100%;
	height: 5%;
	font-size: 200%;
	text-align: center;
	opacity: 0.7;
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
  
 

<div class="topnav">
<a class="active" href="index.jsp">Go back</a>
  <a class="active" href="#home">OMTS</a>
  <form  action="./LogoutServlet" method="post">
      <input class="button" type="submit" value="Logout">
</form>
</div>
<% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
            %><%= session.getAttribute("username")%> <%    
         }
      } 
%>
<%
		String message = (String)request.getAttribute("message");
		if(message != null) {
			out.print("<html><body><h5 align = center;>");
			out.print(message);
			out.print("</h5></body></html>");
		}
	%>

<center><h1>Welcome Admin</h1></center>
<div class="container">
<div class="container1">
<div class="box1"><p id="txt1"><a style="text-decoration:none" href="addTheatre.jsp">Add Theater</a></p></div>
<div class ="box2"><p id="txt1"><a style="text-decoration:none" href="deleteTheatre.jsp">Remove Theater</a></p></div>
</div>
<div class="container1">
<div class="box1"><p id="txt1" ><a style="text-decoration:none" href="addMovie.jsp">Add Movie</a></p></div>
<div class="box2"><p id="txt1" ><a style="text-decoration:none" href="DeleteMovieServlet">Remove Movie</a></p></div>
</div>
<div class="container1">
<div class="box3"><p id="txt1" ><a style="text-decoration:none" href="getTheatreDetails.jsp">Add Movie To Theatre</a></p></div>
</div>
<div class="container1">
<div class="box1"><p id="txt1"><a style="text-decoration:none" href="addShow.jsp">Add Show</a></p></div>
<div class="box2"><p id="txt1"><a style="text-decoration:none" href="deleteShows.jsp">Remove Show</a></p></div>
</div>
<div class="container1">
<div class="box1"><p id="txt1"><a style="text-decoration:none" href="addScreen.jsp">Add Screen</a></p></div>
<div class="box2"><p id="txt1"><a style="text-decoration:none" href="DeleteScreenServlet">Remove Screen</a></p></div>
</div>
</div>
<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>
</body>
</html>