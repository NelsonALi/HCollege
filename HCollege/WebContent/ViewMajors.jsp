<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Majors</title>
<jsp:include page="./header.jsp" />
</head>
<body>
	<jsp:include page="./carousel.jsp" />
	<jsp:include page="./menu.jsp" />
	<div class="container">
		<div class="jumbotron">
			<form role="form" action="ViewMajors" method="post">
				<p>${loginname}loggedin</p>
				<p>Select Major List filtering Criteria</p>
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
						class="form-control" id="classfilter" name="classfilter">
				</div>

				<button type="submit" class="btn btn-default">Show Majors</button>				
				<br><br>
				<p>List of Majors after being filtered</p>
				<table class="table table-bordered">
					<tr>
						<th>Major Name</th>
						<th>Department</th>
					</tr>
					<c:forEach items="${majorList}" var="major">
						<tr>
							<td>${major.majorname}</td>
							<td>${major.hdepartment.departname}</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>