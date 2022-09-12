<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<body>
Orders:
<br>
<a href="/orders/add">Add a new Order</a>

<hr>

<c:forEach items="${orders}" var="order">
    Order id: ${order.id} <br>
    User: ${order.user_id.firstName} ${order.user_id.lastName}<br>
    Client: ${order.client_id.firstName} ${order.client_id.lastName} <br> <br>
    Products:  <br> <br>
    <c:forEach items="${order.orders}" var="product">
        ${product.product.name} <br>
        Quantity: ${product.quantity} <br>
        Price/Unit: ${product.product.price} <br>
        Total for this product: ${product.amount} <br> <br>
    </c:forEach>
    Total for this order: ${order.amount} <br>
    Date Created: ${order.dateCreated} <br>
    Last Update: ${order.dateUpdated} <br>
    <a href="#">Update</a>
    |
    <a href="#">Delete</a>
    <hr>
</c:forEach>


<a href="${pageContext.request.contextPath}/">Back to Main Page</a>
<br>
<form:form action="${pageContext.request.contextPath}/logout"
           method="post">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>