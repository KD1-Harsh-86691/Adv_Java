<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p>
			<jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean"/>
			<jsp:setProperty property="*" name="rb"/>
			
			${rb.register() }
			
			<c:choose>
				<c:when test="${rb.userStatus == 1}"><h2>User register successfully</h2></c:when>
				<c:otherwise><h2>Registration failed..</h2></c:otherwise>
			</c:choose>
		</p>
		<h2><a href="index.jsp">To Login</a></h2>
	</div>
</body>
</html>