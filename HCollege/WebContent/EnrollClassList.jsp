<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enroll Class</title>
<jsp:include page="./header.jsp" />
</head>
<body>
	<jsp:include page="./carousel.jsp" />
	<jsp:include page="./menu.jsp" />
	<div class="container">
		<div class="jumbotron">
			<form role="form" action="ViewAllClass" method="post">
				<p>${loginname}loggedin</p>
				${Message}
				<p>Enroll by clicking the enroll button for the class</p><br>
				<table class="table table-bordered">
					<tr>
						<th>Class CRN Number</th>
						<th>Subject Code</th>
						<th>Department</th>
						<th>Instructor Name</th>
						<th>Course Name</th>
						<th>Room</th>
						<th>Schedule</th>
						<th>Current Enrollment Count</th>
						<th>Class Id Button</th>
					</tr>
					<c:forEach items="${classList}" var="classes">
						<tr>
							<td>${classes.crn}</td>
							<td>${classes.hcourse.subjectcode}</td>
							<td>${classes.hcourse.hdepartment.departname}</td>
							<td>${classes.hinstructor.instructorname}</td>
							<td>${classes.hcourse.coursename}</td>
							<td>${classes.hclassroom.bldgname} ${classes.hclassroom.roomnumber}</td>
							<td>${classes.hschedule.dow1} ${classes.hschedule.dow2} at ${classes.hschedule.hour12} ${classes.hschedule.ampm} for ${classes.hschedule.minutes60} minutes</td>
							<td>${classes.enrollmenthold}</td>
							<td><a class="btn btn-default"	href="Enroll?classId=${classes.classnum}" role="button">${classes.classnum}</a></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>