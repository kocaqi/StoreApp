<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
Products:
<br>
<a href="/products/add">Add a new Product</a>

<table border="1px">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Date Created</th>
        <th>Date Updated</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${products}" var="client">
        <tr>

            <c:url var="updateLink" value="/products/update">
                <c:param name="productId" value="${client.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/products/delete">
                <c:param name="productId" value="${client.id}"/>
            </c:url>

            <td>${client.name}</td>
            <td>${client.price}</td>
            <td>${client.stock}</td>
            <td>${client.dateCreated}</td>
            <td>${client.dateUpdated}</td>
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