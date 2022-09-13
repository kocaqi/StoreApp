<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
Users:
<br>
<a href="/users/add">Add a new User</a>

<table border="1px">
	<tr>
		<th>Fist Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Roles</th>
		<th>Date Created</th>
		<th>Date Updated</th>
		<th>Action</th>
	</tr>
	
	<c:forEach items="${users}" var="user">
	<tr>
		<c:url var="updateLink" value="/users/update">
			<c:param name="userId" value="${user.id}"/>
		</c:url>
		<c:url var="deleteLink" value="/users/delete">
			<c:param name="userId" value="${user.id}"/>
		</c:url>
		<td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.email}</td>
		<td>${user.roles}</td>
        <td>${user.dateCreated}</td>
        <td>${user.dateUpdated}</td>
		<td>
			<a href="${updateLink}">Update</a>
			||
			<a href="${deleteLink}">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
	
	
</table>



<a href="${pageContext.request.contextPath}/">Back to Main Page</a>
<br>
<form:form action="${pageContext.request.contextPath}/logout"
		   method="post">
	<input type="submit" value="Logout"/>
</form:form>

</body>
</html>