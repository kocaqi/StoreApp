<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
</head>
<body>
Clients:
<br>
<a href="/clients/add">Add a new Client</a>

<table border="1px">
    <tr>
        <th>Fist Name</th>
        <th>Last Name</th>
        <th>User</th>
        <th>Email</th>
        <th>Date Created</th>
        <th>Date Updated</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${clients}" var="product">
        <tr>
            <td>${product.firstName}</td>
            <td>${product.lastName}</td>
            <td>${product.theUser.firstName} ${product.theUser.lastName}</td>
            <td>${product.email}</td>
            <td>${product.dateCreated}</td>
            <td>${product.dateUpdated}</td>
            <td>
                <a href="#">Update</a>
                |
                <a href="#">Delete</a>
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