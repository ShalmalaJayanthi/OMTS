<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<style>
* {
	padding: 0px;
	margin: 0px;
}
.header a {
	float:right;
	color: white;
	padding: 12px;
	text-decoration: none;
	line-height: 25px;
	border-radius: 4px;
	display: block;
	color: white;
	text-align: right;
	width:0%;
	padding: 14px 20px;
	width: 200px;
	font-size: 180%;
}
a {
	float: left;

}


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
	padding: 0px 0px;
	opacity: 1;

	height:8%;
}
.header a.logout {
	background-color: #291f04;
	color: white;

}
.header logo {
	weight: 10;
	color: white;
	font-size: 40px;
}
.bgpic {
	background-image: url("background.jpg");
	height: 100vh;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.active {
	background-color: #a89e8a;
	color: white;
}

.loginform {
	margin-top: 10%;
	background: #a89e8a;
	width: 26%;
	height: 50%;
	border-radius: 7%;
	opacity: 0.8;
	color: white;
	align: center;
	margin-left: 35%;
	display: none;
	position: absolute;
	box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0
		rgba(0, 0, 0, .19);
	border: 3px solid #f1f1f1;
}


.input {
	width: 170px;
	height: 30px;
	border-radius: 10px;
	background: rgba(255, 255, 255, .1);
	font-size: 15px;
}

.button {
	align-content: center;
	align: center;
	font-size: 12px;
	width: 140px;
	height: 40px;
	margin-left: -50px;
	margin-top: 40px;
	cursor: pointer;
	padding: 15px 20px;
	border-radius: 25px;
	color: black;
	
	text-align: center;
}

.img {
	width: 5%;
	height: 5%;
	margin-left: 0%;
	border-radius: 10%;
	position: left;
	cursor: pointer;
}

.cross-button {
	width: 50px;
}

.caption {
	font-style: italic;
	font-size: 30px;
	margin-bottom: 20px;
	margin-top: 10px;
}

.caption-image {
	position: absolute;
	width: 20%;
	height: 20%;
	border-radius: 20%;
	left: 40%;
	top: -11%;
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

table {
	width: 50%;
	margin-left: 20%;
	margin-top: 15%;
}

b {
	color: black;
}
img{
  width:65%;
  height:65%;
  float:left;
  padding: 0px 0px;
  margin-top:0%;
}
.errormessage {
	color: red;
	position: absolute;
	top: 20%;
	left: 40%;
	font-size: 150%;
}
</style>


<script type="text/javascript">
	function login() {
		document.getElementById("log").style.display = "block";
	}

	function cross() {
		document.getElementById("log").style.display = "none";
	}

	//window.history.forward();
	//function noBack() {
		//window.history.foward();
	//}
</script>

</head>
<body class="bgpic">

	<div class="header">

		<a class="logo"><img src="loggo.PNG" ></img></a>
		<a href="index.jsp" class="active"><b>Home </b></a>
				<% if (session.getAttribute("username") == null) {
			            %> <a class="active" href="register.jsp" > <b>Register</b></a><%
					}  else {%>
					 <% }%>
				<% if (session.getAttribute("username") != null) {
			            int id = (Integer)session.getAttribute("username");
			            System.out.println("session id "+ id); 
					%><a class="active" href="./LogoutServlet" id="logout"> <b>Logout</b></a><%
					}  else {%>
					<a href="#" onclick="login()" id="login" class="active"> <b>Login
					 <% }%>
					</b></a>
				<a href="about.html" class="active"><b>About US </b></a>

	</div>

	<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  %> 
  <% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
            %><%= session.getAttribute("username")%> <%    
         }
      } 
%>
<% if(request.getAttribute("logout")!=null) {%>
<h1 style="color:Green;"><%=request.getAttribute("logout") %></h1>
<%} %>
<% if(request.getAttribute("errormessage")!=null) {%>
<h1 style="color:Red;"><%=request.getAttribute("errormessage") %></h1>
<%} %>
<% if(request.getAttribute("message") != null){ %>
<h1 style="color:Red;"><%=request.getAttribute("message") %></h1>
<%} %>

	<div class="loginform" id="log">
		<img src="cross.png" class="img" onclick="cross()">

		<table style="margin-top: 30%;">
			<caption>
				<img src="caption1.png" class="caption-image">
			</caption>
			<br>
			<form action="./LoginServlet" method="post">
				<tr>
					<td><b>UserId:</b></td>
					<td><input type="text" name="user" class="input" pattern="^[1]{1}[0-9]{3}$" title = "User Id should start with 1, should contain numbers only with length 4" required></td>
				</tr>

				<tr>
					<td><b>Password:</b></td>
					<td><input type="Password" name="pass" class="input" required></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit" class="button">
							<b>Login</b>
						</button></td>
				</tr>
			</form>
		</table>

	</div>

	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>
</body>
</html>