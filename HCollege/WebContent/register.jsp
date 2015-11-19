<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Harrison College Site</title>
<jsp:include page="./header.jsp" />
</head>
<body>
	<jsp:include page="./carousel.jsp" />
	<jsp:include page="./menu.jsp" />
	<div class="container">
		<div class="jumbotron">
			<h2>
				Harrison College <br> Welcome to register first.
			</h2>
			<form class="form-inline" action="Register" method="post">
				<table class="table table-condensed">
					<tr>
						<td>
							<div class="form-group">
								<label class="sr-only" for="loginname">Login Name</label> <input
									type="text" class="form-control" id="loginname"
									placeholder="loginname" name="loginname" required="reguired">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="form-group">
								<label class="sr-only" for="email">Email</label> <input
									type="email" class="form-control" id="email"
									placeholder="email" name="email" required="reguired">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="form-group">
								<label class="sr-only" for="password">Password</label> <input
									type="password" class="form-control" id="password"
									placeholder="password, not required currently." name="password">
							</div>
						</td>
					</tr>
					<tr>
						<td><p>Select Your Role</p>
							<div class="radio-inline">
								<label><input type="radio" name="rolefilter" onclick = \"getAnswer('Student') value="Student">Student</label>
							</div>
							<div class="radio-inline">
								<label><input type="radio" name="rolefilter" onclick = \"getAnswer('Instructor') value="Instructor">Instructor</label>
							</div>
							<div class="radio-inline">
								<label><input type="radio" name="rolefilter" onclick = \"getAnswer('Advisor') value="Advisor">Advisor</label>
							</div>
							<div class="radio-inline">
								<label><input type="radio" name="rolefilter" onclick = \"getAnswer('Administrator') value="Administrator">Administrator</label>
							</div>
							<br>
						</td>
					</tr>
					<tr>
						<td>
							<button type="submit" class="btn btn-success">Register</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
