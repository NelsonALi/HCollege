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
			<form role="form" action="ViewAllClass" method="post">
				<p>${loginname}loggedin</p>
				<p>Select Class List filtering Criteria</p>
				<div class="radio-inline">
					<label><input type="radio" name="viewclassfilter">All</label>
				</div>
				<div class="radio-inline">
					<label><input type="radio" name="viewclassfilter">By
						Subject</label>
				</div>
				<div class="radio-inline">
					<label><input type="radio" name="viewclassfilter">By
						Instructor</label>
				</div>
				<div class="radio-inline">
					<label><input type="radio" name="viewclassfilter">By
						Time</label>
				</div><br>
				<div class="form-group">
					<label for="classfilter">Input the appropriate data according to radio button selection.<br>Filter:</label> <input type="text"
						class="form-control" id="classfilter">
				</div>

				<button type="submit" class="btn btn-default">Show Classes</button>				
				<!-- 				<div class="column">
					<div class="col-sm-3">Select Filter Criteria</div>
					<div class="col-sm-9">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-default"> <input type="radio"
								id="r1" name="viewcoursefilter" value="1" /> All
							</label> <label class="btn btn-default"> <input type="radio"
								id="r2" name="viewcoursefilter" value="2" /> Subject
							</label> <label class="btn btn-default"> <input type="radio"
								id="r3" name="viewcoursefilter" value="3" /> Instructor
							</label> <label class="btn btn-default"> <input type="radio"
								id="r4" name="viewcoursefilter" value="4" /> Time
							</label>
						</div>
					</div>
				</div>
 -->			<br>				<br><br>
				<p>List of Classes after being filtered</p>
				<table class="table table-bordered">
					<tr>
						<th>Class CRN Number</th>
						<th>Instructor Name</th>
						<th>Course Name</th>
						<th>Room</th>
						<th>Schedule</th>
					</tr>
					<c:forEach items="${classList}" var="classes">
						<tr>
							<td>${classes.crn}</td>
							<td>${classes.instructor.name}</td>
							<td>${classes.course.name}</td>
							<td>${classes.room.bldgName}+${classes.room.roomNo}</td>
							<td>${classes.scheduleDate}+${classes.scheduleTime}</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>