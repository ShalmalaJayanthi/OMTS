<%@page import="com.cg.omts.dto.Theatre"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.omts.service.AdminServiceImpl"%>
<%@page import="com.cg.omts.dao.AdminDaoImpl"%>
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
<h1>
<% if(request.getAttribute("message")!=null) { %>
<%= request.getAttribute("message") %>
<%} %>
</h1>
<h1>List of Theatres </h1>
<br>
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
</tr>
<tr>
<%for(Theatre theatre: theatreList) {
%>
<td>
<%=theatre.getTheatreId() %>
</td>
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
</tr>
<%} %>
</table>
</body>
</html>