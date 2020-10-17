
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String message = (String)request.getAttribute("message");
		if(message != null)
			out.print(message);
	%>
	<form action = "AddMovieServlet" method = "post" align = "center">
		<table align = "center">
			<caption>Enter Movie Details</caption>
			<tr><td>Movie Id</td><td><input type="number" name = "movieId" required title = "Movie ID must contain only digits"></td></tr>
			<tr><td>Movie Name</td><td><input type="text" name = "movieName" required></td></tr>
			<tr><td>Movie Genre</td><td><input type="text" name = "movieGenre" required></td></tr>
			<tr><td>Movie Director</td><td><input type= "text" name = "movieDirector" required></td></tr>
			<tr><td>Movie Length</td><td><input type= "number" name = "movieLength" required></td></tr>
			<tr><td>Movie Language</td><td><input type= "text" name = "movieLanguage" required></td></tr>
			<tr><td>Movie Release Date</td><td><input type="date" name = "movieReleaseDate" required></td></tr>
			<!-- <tr><td>Upload Movie Image</td><td><input type = "file" name = "uploadImg" required></td></tr> -->
			<tr ><td colspan="2" align = "center"><button type = "submit"> Submit </button>
		</table>
	</form>
</body>
</html>