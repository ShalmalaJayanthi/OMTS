
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Payment</title>
</head>
<body>

<form action ="paymentController" method ="post">

<input type = "hidden" value=<%=request.getAttribute("ticketId")%> name = "ticketId">
<input type = "hidden" value=<%=request.getAttribute("theatreId") %> name = "theatreId">
<input type = "hidden" value=<%=request.getAttribute("movieId") %> name = "movieId">
<input type = "hidden" value=<%=request.getAttribute("showId") %> name = "showId">
<input type = "hidden" value=<%=request.getAttribute("screenId") %> name = "screenId">

<table>

<tr><td>Account Number<td><input type="number" name="acc" required>
<tr><td>Cvv<td><input type="number" name="cvv" required>
<tr><td>Password<td><input type="password" name="pass" required>
<tr><td>Total Amount<td><input type = "text" name = "totalPrice" value = <%=request.getAttribute("totalPrice") %> readonly>
<tr><td><td><input type ="submit" value="PAY">
</table>
</form>

</body>
</html>