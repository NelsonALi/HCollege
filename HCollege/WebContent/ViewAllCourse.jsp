<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Courses</title>
<jsp:include page="./header.jsp" />
</head>
<body>
	<jsp:include page="./carousel.jsp" />
	<jsp:include page="./menu.jsp" />
	<div class="container">
		<div class="jumbotron">
			<form role="form" action="ViewAllCourse" method="post">
				<p>${loginname}loggedin</p>
				<p>Select Course List filtering Criteria</p>
				<div class="radio-inline">
					<label><input type="radio" name="viewcoursefilter" active>All</label>
				</div>
				<div class="radio-inline">
					<label><input type="radio" name="viewcoursefilter" disabled>By
						Department</label>
				</div><br>
				<div class="form-group">
					<label for="coursefilter">Input the appropriate data according to radio button selection.<br>Filter:</label> <input type="text"
						class="form-control" id="coursefilter">
				</div>

				<button type="submit" class="btn btn-default">Show Courses</button>				
			</form>
		</div>
	</div>
</body>
</html>