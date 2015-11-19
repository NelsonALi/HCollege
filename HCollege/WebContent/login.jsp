<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<h2>Harrison College Login Page</h2><br>
			<form role="form" action="Login" method="post">
				<h3>${Message}</h3>
				<div class="form-group">
					<label for="loginname"></label> <input type="text"
						class="form-control" id="user" name="loginname"
						placeholder="Enter login name" required>
				</div>
				<div class="form-group">
					<label for="password"></label> <input type="password"
						class="form-control" id="pwd" name="pwd"
						placeholder="Enter password not required">
				</div>
				<button type="submit" class="btn btn-default">Login</button>
			</form><br><br>
			<h2>
				<a href="register.jsp">Register</a>
			</h2>
		</div>
	</div>
</body>
</html>