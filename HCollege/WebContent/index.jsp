<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Harrison College Site</title>
	<jsp:include page="./header.jsp"/>
</head>
<body>
	<jsp:include page="./carousel.jsp"/>
 	<jsp:include page="./menu.jsp" />
 <div class="container">
  <div class="jumbotron">
    <h2>Most actions requires logging in first. <br> You need to register to be eligible for logging in.</h2><br>
    <p>All actions are based on authorization level. <br>
    	 You can choose the action from the menu. However, <br>you may not be able to execute the action you choose.  </p>     
  </div>
</div></body>
</html>