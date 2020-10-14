<%@page import="com.cg.omts.dto.Theatre"%>
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
<h1>Theatre List</h1>
Enter Theatre Name:
<form method="get" action="./DeleteTheatreServlet">
<input type="text" name="theatreName" required>
<input type="submit" value="search theatre" >
</form>
<br>
<% if (request.getAttribute("errorMessage")!=null) {%>
<h2><%=request.getAttribute("errorMessage") %></h2>
<%} %>
<table border=1>
<% List<Theatre> searchTheatreList = (List<Theatre>)request.getAttribute("searchTheatreList");
if(request.getAttribute("searchTheatreList")!=null) {%>
<tr>
<td>Theatre Id</td>
<td>Theater Name</td>
<td>Theater City</td>
<td>Theater Manager Name</td>
<td>Theater Manager Contact</td>
<td> Delete </td> 
</tr>
<tr>
<%for(Theatre theatre: searchTheatreList) { %>
<td><%=theatre.getTheatreId() %></td>
<td>
<%=theatre.getTheatreName() %>
</td>
<td>
<%=theatre.getTheatreCity() %>
</td>
<td>
<%=theatre.getManagerName() %>
</td>
<td>
<%=theatre.getManagerContact() %>
</td>
<td>
<form action="./DeleteTheatreServlet" method="post">
<input type="hidden" name="theatreId" value="<%= theatre.getTheatreId()%>">
<input type="submit" value="Delete">
</form>
</td>
</tr>
<%} %>
</table>
<% } else { %>
<table  border=1>
<%IAdminService adminService = new AdminServiceImpl();
List<Theatre> theatreList = adminService.getTheatreDetails();
%>
<tr>
<td>Theatre Id</td>
<td>Theater Name</td>
<td>Theater City</td>
<td>Theater Manager Name</td>
<td>Theater Manager Contact</td>
<td> Delete </td> 
</tr>
<tr>
<%for(Theatre theatre: theatreList) { %>
<td><%=theatre.getTheatreId() %></td>
<td>
<%=theatre.getTheatreName() %>
</td>
<td>
<%=theatre.getTheatreCity() %>
</td>
<td>
<%=theatre.getManagerName() %>
</td>
<td>
<%=theatre.getManagerContact() %>
</td>
<td>
<form action="./DeleteTheatreServlet" method="post">
<input type="hidden" name="theatreId" value="<%= theatre.getTheatreId()%>">
<input type="submit" value="Delete">
</form>
</td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>