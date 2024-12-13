<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<h1>Thankyou!!</h1>
${session.inValidate("user_details") }
<button onclick="login.jsp">Login</button>
</body>
</html>