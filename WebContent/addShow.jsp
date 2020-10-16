<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Show</title>
</head>
<body>
<h1>Enter Details to Register Show</h1>
<%if(request.getAttribute("message")!= null)  { %>
<h1><%= request.getAttribute("message")%></h1>
<%} %>
<br>
<form method="post" action="./AddShowServlet">
Enter Show Id : 
<input type="text" name="showId" pattern="[5]{1}[0-9]{3}" title="Show Id should be minimum 4 digit" required>
<br>
<br>
Enter Show Name:<select id="showType" name="showName" onchange="myFunction()">
 <option value="" selected disabled hidden>Choose here</option>
<option value="morning">Morning</option>
<option value="matinee">Matinee</option>
<option value="firstshow">First show</option>
<option value="secondshow">Second Show</option>
</select>
<br>

<br>
Enter Show Start Time:
<input type="time" id="stime" name="stime" required>
<br>
<br>
Enter Show End Time :
<input type="time" id="etime" name="etime" required>
<br>
<br>
Enter Theatre Id:
<input type="text" name="theatreId" pattern="[2]{1}[0-9]{3,}" title="Theatre Id should start with number 2 and minimum of 4 digits" required>
<br>
<br>
Enter Movie Id :
<input type="text" name="movieId" pattern="[3]{1}[0-9]{3,}" title="Movie Id should start with number 3 and minimum of 4 digits" required>
<br>
<br>
Enter Screen Id :
<input type="text" name="screenId"pattern="[4]{1}[0-9]{3,}" title="Screen Id should start with number 4 and minimum of 4 digits" required>
<br>
<br>
<input type="submit" value="Enter Show">
</form>
<script type="text/javascript">
function myFunction() {
  var x = document.getElementById("showType").value;
  console.log(x);
  if(x==='morning') {
	  document.getElementById("stime").min="06:00"
	  document.getElementById("stime").max="08:00"
	  document.getElementById("etime").min="07:00"
	  document.getElementById("etime").max="11:00"
  } else if(x==='matinee') {
	  document.getElementById("stime").min="10:00"
	  document.getElementById("stime").max="12:00"
	  document.getElementById("etime").min="11:00"
	  document.getElementById("etime").max="15:00"
  } else if(x==='firstshow') {
	  document.getElementById("stime").min="17:00"
	  document.getElementById("stime").max="20:00"
	  document.getElementById("etime").min="18:00"
	  document.getElementById("etime").max="23:00"
  } else {
	  document.getElementById("stime").min="21:00"
	  document.getElementById("stime").max="23:00"
	  document.getElementById("etime").min="22:00"
	  document.getElementById("etime").max="02:00"
  }
  //document.getElementById("num").min=89;
  //document.getElementById("starttime").min="07:00"
}
</script>

</body>
</html>