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
</body>
</html>