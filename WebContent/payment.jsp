<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>

<form action ="paymentController" method ="post">
<table>
<tr><td>Account Number<td><input type="number" name="acc" required>
<tr><td>Cvv<td><input type="number" name="cvv" required>
<tr><td>Password<td><input type="password" name="pass" required>
<tr><td>Total Amount<td><input>
<tr><td><td><input type ="submit" value="PAY">
</table>
</form>
</body>
</html>