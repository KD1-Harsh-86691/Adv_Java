<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Posts</title>
</head>
<body>
<c:url var="url" value="/blogger/logout"/>
	<div align="center">
		<h1>Posts</h1>
		<table border="1" width="70%">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Updated On</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${requestScope.post_list }">
					<tr>
						<td>${p.id }</td>
						<td>${p.title }</td>
						<td>${p.description }</td>
						<td>${p.updatedOn }</td>
						<td>
						<a href="edit.jsp/id=${p.getId()}">Edit</a>
						<a href="delete.jsp/id=${p.getId()}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a href="${url}">Logout</a>
		</p>
	</div>
</body>
</html>