<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
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
					<label><input type="radio" name="viewclassfilter" onclick = \"getAnswer('All') value="All">All</label>
				</div>
				<div class="radio-inline">
					<label><input type="radio" name="viewclassfilter" onclick = \"getAnswer('departname') value="departname">By
						Department</label>
				</div>
				<br>
				<div class="form-group">
					<label for="classfilter">Input the appropriate data according to radio button selection.<br>Filter:</label> <input type="text"
						class="form-control" id="classfilter">
				</div>
				<button type="submit" class="btn btn-default">Show Classes</button>	
				<br><br><br>			
				<p>List of Courses after being filtered</p>
				<table class="table table-bordered">
					<tr>
						<th>Course Number</th>
						<th>Subject Code</th>
						<th>Course Name</th>
						<th>Description</th>
						<th>Number of Credit</th>
					</tr>
					<c:forEach items="${courseList}" var="course">
						<tr>
							<td>${course.coursecode}</td>
							<td>${course.subjectcode}</td>
							<td>${course.coursename}</td>
							<td>${course.description}</td>
							<td>${course.credits}</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>