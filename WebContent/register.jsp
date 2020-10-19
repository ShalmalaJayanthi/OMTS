<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel ="stylesheet" href="style.css">
<link rel ="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-md-10 offset=md-1">
			<div class="row">
				<div class="col-md-5 register-left">
					<img src="icon.png">
					<h3>JOIN US</h3>
					<p>Be a part of T-CKT family to know more</p>
					<button type="button" class="btn btn-primary">About Us</button>
				</div>

				<div class="col-md-7 register-right">
					<h2>Register Here</h2>
					<form method="post" action="RegisterServlet" >
					<div class="register-form">
					
						<div class="form-group">
							<input type="text" class="form-control" placeholder="UserName" pattern="^[a-zA-Z][0-9]{10}$" title = "User Name can be alphabet and numbers only with length 10" name="name" required>
							
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="UserID" pattern="^[1]{1}[0-9]{3}$" title = "User Id should start with 1, should contain numbers only with length 4" name="custid" required>
							
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="password" name="pass" pattern = "^[a-zA-Z][0-9]{10}$" title = "User Name can be alphabet and numbers only with length 10"required>
							
						</div>
						<div class="form-group">
							<input type="date" class="form-control" placeholder="Date" name="custdob" required>
							
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Contact Number" name="contact" required>
							
						</div>
						
						<button type="submit" class="btn btn-primary" onclick="submit">Register</button>
					</form>
					</div>
				
					
				</div>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>