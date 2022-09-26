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

    <c:forEach items="${products}" var="order_product">
        <tr>

            <c:url var="updateLink" value="/products/update">
                <c:param name="productId" value="${order_product.id}"/>
            </c:url>

            <td>${order_product.name}</td>
            <td>${order_product.price}</td>
            <td>${order_product.stock}</td>
            <td>${order_product.dateCreated}</td>
            <td>${order_product.dateUpdated}</td>
            <td>
                <a href="${updateLink}">Update</a>
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