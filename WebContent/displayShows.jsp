<%@page import="com.cg.omts.dto.Show"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.omts.service.AdminServiceImpl"%>
<%@page import="com.cg.omts.service.IAdminService"%>
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
         }
      } 
%>
<form action="./LogoutServlet" method="post">
      <input type="submit" value="Logout">
</form>
<h1>
<% if(request.getAttribute("message")!=null) { %>
<%= request.getAttribute("message") %>
<%} %>
</h1>
<h1>List of Shows </h1>
<table  border=1>

<%IAdminService adminService = new AdminServiceImpl();
List<Show> showList = adminService.getShowDetails();
%>
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
</tr>
<tr>
<%for(Show show: showList) {
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
</tr>
<%} %>
</table>
</body>
</html>