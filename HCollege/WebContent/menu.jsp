<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Harrison College</a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a href="login.jsp">Login</a></li>
				<li><a href="register.jsp">Register</a></li>
				<li><a href="EnrollClassList">Enroll Class (Student only)</a></li>
				<li><a href="DropCalss.jsp">Drop Class (Student only)</a></li>			
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">View Actions <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="ViewAllCourse.jsp">View Courses</a></li>
						<li><a href="ViewCurrentClasses.jsp">View Classes</a></li>
						<li><a href="ViewMajors.jsp">View Majors by Department</a></li>
						<li><a href="ViewSchedule">View Class Schedule</a></li>						
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">Transcript</li>
						<li><a href="ViewTranscript.jsp">View Transcript</a></li>
						<li><a href="BuyTranscript.jsp">Buy Transcript</a></li>
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">Grades</li>
						<li><a href="ViewGrades.jsp">View Grades</a></li>
						<li><a href="UpdateGrades.jsp">Update Grades</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Update Actions <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="dropdown-header">Courses</li>
						<li><a href="CreateCourse.jsp">Create Course</a></li>
						<li><a href="UpdateCourse.jsp">Update Course</a></li>
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">Classes</li>
						<li><a href="ViewTranscript.jsp">create Class</a></li>
						<li><a href="UpdateClass.jsp">Update Class</a></li>
						<li class="dropdown-header">Departments</li>
						<li><a href="CreateCourse.jsp">Create Department</a></li>
						<li><a href="UpdateCourse.jsp">Update DEpartment</a></li>
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">Majors</li>
						<li><a href="ViewTranscript.jsp">create Major</a></li>
						<li><a href="UpdateClass.jsp">Update Major</a></li>
					</ul></li>					
				<li><a href="UpdateRole.jsp">Change Person Role Type</a></li>			
				<li><a href="UpdateRoomMax.jsp">Reset Room Capacity</a></li>			
				<li><a href="logout.jsp">Log Out</a></li>			
			</ul>
		</div>
	</div>
</nav>
