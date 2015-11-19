<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Harrison College Sit</title>
<jsp:include page="./header.jsp" />
</head>
<body>
	<jsp:include page="./carousel.jsp" />
	<jsp:include page="./menu.jsp" />
	<div class="container">
		<div class="jumbotron">
			<form role="form">
				<p>${loginname}loggedin</p>
				<p>This is the class you have just enrolled successfully.</p>
				<table class="table table-bordered">
					<tr>
						<th>Class CRN Number</th>
						<th>Subject Code</th>
						<th>Department</th>
						<th>Instructor Name</th>
						<th>Course Name</th>
						<th>Room</th>
						<th>Schedule</th>
						<th>Enrollment Count</th>
					</tr>
						<tr>
							<td>${theclass.crn}</td>
							<td>${theclass.hcourse.subjectcode}</td>
							<td>${theclass.hcourse.hdepartment.departname}</td>
							<td>${theclass.hinstructor.instructorname}</td>
							<td>${theclass.hcourse.coursename}</td>
							<td>${theclass.hclassroom.bldgname} ${theclass.hclassroom.roomnumber}</td>
							<td>${theclass.hschedule.dow1} ${theclass.hschedule.dow2} at ${theclass.hschedule.hour12} ${theclass.hschedule.ampm} for ${theclass.hschedule.minutes60} minutes</td>
							<td>${theclass.enrollmenthold}</td>
						</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>