<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Client Form</title>
</head>
<body>

Add Order

<%--@elvariable id="order" type=""--%>
<form:form action="saveOrder" modelAttribute="order" method="POST">
    <c:url var="selectProduct" value="/orders/selectProduct">
        <c:param name="orderId" value="${order.id}"/>
    </c:url>
    Client: ${order.client_id.firstName} ${order.client_id.lastName} <br>
    <c:forEach items="${order.orderProducts}" var="order_product">
        ${order_product.product.name} <br>
        Quantity: ${order_product.quantity} <br>
        Price/Unit: ${order_product.product.price} <br>
        Total for this product: ${order_product.amount} <br> <br>
    </c:forEach>
    <a href="${selectProduct}">Add Product to this Order</a><br>
</form:form>


</body>
</html>