<%@page import="com.cg.omts.dto.Show"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cg.omts.dto.Screen"%>
<%@page import="com.cg.omts.dto.Theatre"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.omts.service.UserServiceImpl"%>
<%@page import="com.cg.omts.service.IUserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking</title>
<script type="text/javascript">
	function changeActionForScreen(){
		document.bookingForm.action = "BookingScreenController";
		document.bookingForm.submit();
	}
	function changeActionForShow(){
		document.bookingForm.action = "BookingShowController";
		document.bookingForm.submit();
	}
	function proceedToPay(){
		document.bookingForm.action = "ProceedToPayController";
		document.bookingForm.submit();
	}
</script>
</head>
<body>
	<form action ="BookingController" method = "post" id = "theatreSelection" name = "bookingForm">
		<table>
		
			<tr>
				<td><label>Select Theatre </label></td>
				<td>:</td>
				<td><select name = "theatreId" onchange = "document.bookingForm.submit();" id = "selectedTheatre">
						<option value="-1" selected disabled>Select Theatre</option>
						<%
							String mId = request.getParameter("movieId");
							int movieId = Integer.parseInt(mId);
							IUserService userService = new UserServiceImpl();
							List<Integer> theatreIdList = userService.getTheatresByMovie(movieId);
			
							List<Theatre> theatresList = userService.getTheatres(theatreIdList);
							for(Theatre theatre : theatresList){
						%>
						<option value = <%=theatre.getTheatreId() %>><%=theatre.getTheatreName() %></option>
						<%
							}			
						%>
						<input type = "hidden" value=<%=movieId %> name = "movieId" id = "selectedMovie">
					</select>
				</td>
			</tr>
			
			<tr>
				<td><label>Select screen </label></td><td>:</td>
				<td><select name = "screenId" onchange = "changeActionForScreen();" id = "selectedScreen">
						<option value="-1"  selected disabled>Select Screen</option>
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
									<option value="" selected disabled>No Screen</option>
						<%	
								}
							}else {
								
						%>
								<option value = <%=request.getAttribute("screenId")%> ><%=request.getAttribute("screenName")%></option>
								<script>
									document.getElementById("selectedScreen").value=<%=request.getAttribute("screenId")%>;
								
								</script>
						<%
							}
						%>
					
				
					</select>
				</td>
			</tr>
			<tr>
				<td><label>Select Show </label></td><td>:</td>
				<td><select name = "showId" onchange = "changeActionForShow();" id = "selectedShow">
						<option value="-1" selected disabled>Select Show</option>
						<%
							if(request.getAttribute("showList") != null) {
					
								List<Show> showList = (ArrayList<Show>)request.getAttribute("showList");
					
								if(showList.size() !=  0){
									for(Show show : showList){				
						%>
										<option value = <%=show.getShowId()%>><%=show.getShowName() %></option>
						<%
									}
								}else{
						%>
									<option value="" selected disabled>No Shows</option>
						<%	
								}
							}else {
						%>
								<option value = <%=request.getAttribute("showId") %>><%=request.getAttribute("showName")%></option>
								
						<%
							}
						%>
				
					</select>
				</td>
			</tr>
			<tr>
				<td><label>Enter Number of seats</label></td><td>:</td>
				<td>
					<input type ="number" name = "noOfSeats" min = "1" max = "6" value="1">
				</td>
			</tr>
			<tr>
				<td><label>Cost </label></td><td>:</td>
				<td><input type = "text" value=<%=request.getAttribute("price") %> name = "seatPrice" id = "selectedScreenSeatPrice" readonly>
				</td>
			</tr>
			<!-- <tr>
				<td><label>Total Price</label></td><td>:</td>
				<td><input type = "text" value=<%=request.getAttribute("totalPrice") %> name="totalPrice" id = "totalPrice" readonly> </td>
			</tr>-->
			
		</table>
		
		
		<Script>
			<%				
				if(request.getAttribute("screenList")!= null && request.getAttribute("theatreId") != null){
					System.out.println("In booking after selecting theatre"+request.getAttribute("theatreId"));
			%>
					document.getElementById("selectedMovie").value=<%=request.getAttribute("movieId")%>;
					document.getElementById("selectedTheatre").value=<%=request.getAttribute("theatreId")%>;
			<%
				}
				if(request.getAttribute("screenId")!= null && request.getAttribute("theatreId") != null && request.getAttribute("showList") != null){
					System.out.println("In booking after selecting screen"+request.getAttribute("screenId"));
			%>
					document.getElementById("selectedMovie").value=<%=request.getAttribute("movieId")%>;
					document.getElementById("selectedTheatre").value=<%=request.getAttribute("theatreId")%>;
					document.getElementById("selectedScreen").value=<%=request.getAttribute("screenId")%>;
			<%
				}if(request.getAttribute("price") != null && request.getAttribute("screenId")!= null && request.getAttribute("theatreId") != null && request.getAttribute("showId") != null){
					System.out.println("In booking after selecting show"+request.getAttribute("theatreId"));
					System.out.println("In booking after selecting show"+request.getAttribute("screenId"));
					System.out.println("In booking after selecting show"+request.getAttribute("showId"));
			%>
					document.getElementById("selectedMovie").value=<%=request.getAttribute("movieId")%>;
					document.getElementById("selectedTheatre").value=<%=request.getAttribute("theatreId")%>;
					document.getElementById("selectedScreen").value=<%=request.getAttribute("screenId")%>;
					document.getElementById("selectedShow").value=<%=request.getAttribute("showId")%>;
					document.getElementById("selectedScreenSeatPrice").value=<%=request.getAttribute("price")%>;
			<%
				}
			%>
		</Script>
		
		
	</form>
	
	<button onclick="proceedToPay()">Proceed to Pay</button>
</body>
</html>