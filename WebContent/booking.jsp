<%@page import="com.cg.omts.service.UserServiceImpl"%>
<%@page import="com.cg.omts.service.IUserService"%>
<%@page import="java.util.List"%>
<%@ page import = "java.lang.*"%>
<%@page import="com.cg.omts.dto.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="BookingController" method = "post" id = "theatreSelection" name = "theatreForm">
		<select name = "theatreId" onchange = "document.theatreForm.submit();" id = "selectedTheatre">
			<option value="-1" selected disabled>Select Theatre</option>
			<%
					//int movieId = Integer.parseInt(request.getParameter("theatreId").trim());
					IUserService userService = new UserServiceImpl();
					List<Integer> theatreIdList = userService.getTheatresByMovie(1);
					
					List<Theatre> theatresList = userService.getTheatres(theatreIdList);
					for(Theatre theatre : theatresList){
			%>
			<option value = <%=theatre.getTheatreId() %>><%=theatre.getTheatreName() %></option>
			<%
					}			
			%>
		
			<Script>
				<%
					if(request.getAttribute("screenList")!= null && request.getAttribute("theatreId") != null){
						System.out.println(request.getAttribute("theatreId"));%>
						document.getElementById("selectedTheatre").value=<%=request.getAttribute("theatreId")%>;
				<%
					}
				%>
			</Script>
		</select>	
		<select name = "screenId">
			<%
				if(request.getAttribute("screenList") != null) {
					
					List<Screen> screenList = (ArrayList<Screen>)request.getAttribute("screenList");
					
					if(screenList.size() !=  0){
						for(Screen screen : screenList){				
			%>
							<option value = <%=screen.getScreenId()%>><%=screen.getScreenName() %>
			<%
						}
					}else{
			%>
						<option value="">No Screen</option>
			<%	
					}
				}else {
					{
						%>
						<option value = "">No Screen</option>
						<%
					}
				}
			%>
				
		</select>
	</form>

</body>
</html>