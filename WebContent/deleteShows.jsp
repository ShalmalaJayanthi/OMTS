<%@page import="com.cg.omts.service.AdminServiceImpl"%>
<%@page import="com.cg.omts.service.IAdminService"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.omts.dto.Show"%>
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
      response.sendRedirect("login.jsp");

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
<a href="adminHomePage.jsp">Go Back</a>
<a href="deleteShow.jsp"> View ALL</a>
<h1>Delete Show</h1>
<form action="./DeleteShowServlet" method="get">
Enter Show Name:
<input type = "text" name="showNameSearch" required>
<input type="submit" value ="search">
</form>
<% if (request.getParameter("message")!=null) {%>
<h3><%=request.getParameter("message") %></h3>
<%} %>

<% if (request.getAttribute("errorMessage")!=null) {%>
<h2><%=request.getAttribute("errorMessage") %></h2>
<%} %>
<br>
<%
List<Show> showListSearch = (List<Show>)request.getAttribute("searchShowList");
if(request.getAttribute("searchShowList")!=null) {%>
<table border=1 width=50% height=50%>
<tr>
<td>
Show Id
</td>
<td>
Show Start Time
</td>
<td>
Show end Time
</td>
<td>
Show Name
</td>
<td>
Movie Name
</td>
<td>
Screen Id
</td>
<td>
Theatre Id
</td>
<td>
Movie Id
</td>
<td>
Delete
</td>
</tr>
<tr>
<%for(Show show: showListSearch)  {
%>
<td>
<%=show.getShowId() %>
</td>
<td>
<%=show.getShowStartTime() %>
</td>
<td>
<%=show.getShowEndTime() %>
</td>
<td>
<%=show.getShowName() %>
</td>
<td>
<%=show.getMovieName() %>
</td>
<td>
<%=show.getScreenId() %>
</td>
<td>
<%=show.getTheatreId() %>
</td>
<td>
<%=show.getMovieId() %>
</td>
<td>
<form method="post" action="./DeleteShowServlet">
<input type="hidden" name="showId" value="<%=show.getShowId() %>">
<input type ="submit" value="delete">
</form>
</td>
</tr>
<% 
}
%>
</tr>
</table>
	
<% }else {
%>

<table border=1 width=50% height=50%>
<tr>
<td>
Show Id
</td>
<td>
Show Start Time
</td>
<td>
Show end Time
</td>
<td>
ShowName
</td>
<td>
Movie Name
</td>
<td>
Screen Id
</td>
<td>
Theatre Id
</td>
<td>
Movie Id
</td>

<td>
Delete
</td>
</tr>
<% IAdminService adminDao = new AdminServiceImpl();
List<Show> showList = adminDao.getShowDetails();
for(Show show : showList) {
%>
<tr>
<td>
<%=show.getShowId() %>
</td>
<td>
<%=show.getShowStartTime() %>
</td>
<td>
<%=show.getShowEndTime() %>
</td>
<td>
<%=show.getShowName() %>
</td>
<td>
<%=show.getMovieName() %>
</td>
<td>
<%=show.getScreenId() %>
</td>
<td>
<%=show.getTheatreId() %>
</td>
<td>
<%=show.getMovieId() %>
</td>

<td>
<form method="post" action="./DeleteShowServlet">
<input type="hidden" name="showId" value="<%=show.getShowId() %>">
<input type ="submit" value="delete">
</form>
</td>
</tr>
<%}  %>
</table>
<%} %>
</body>
</html>