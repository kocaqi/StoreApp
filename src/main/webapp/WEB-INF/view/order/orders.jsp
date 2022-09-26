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
<a href="/clients/">Add new Order (Select Client for new Order)</a>

<hr>

<c:forEach items="${orders}" var="order">
    <c:url var="selectProduct" value="/orders/selectProduct">
        <c:param name="orderId" value="${order.id}"/>
    </c:url>
    Order id: ${order.id} <br>
    User: ${order.user.firstName} ${order.user.lastName}<br>
    Client: ${order.client_id.firstName} ${order.client_id.lastName} <br> <br>
    Products:  <br> <br>
    <c:forEach items="${order.orderProducts}" var="order_product">
        ${order_product.product.name} <br>
        Quantity: ${order_product.quantity} <br>
        Price/Unit: ${order_product.product.price} <br>
        Total for this product: ${order_product.amount} <br> <br>
    </c:forEach>
    Total for this order: ${order.amount} <br>
    Date Created: ${order.dateCreated} <br>
    Last Update: ${order.dateUpdated} <br>
    <a href="${selectProduct}">Add Product to this Order</a>
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