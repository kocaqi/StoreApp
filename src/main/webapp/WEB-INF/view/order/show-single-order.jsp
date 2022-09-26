<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/09/2022
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url var="selectProduct" value="/orders/selectProduct">
  <c:param name="orderId" value="${order.id}"/>
</c:url>
Order id: ${order.id} <br>
User: ${order.user.firstName} ${order.user.lastName}<br>
Client: ${order.client_id.firstName} ${order.client_id.lastName} <br> <br>
Products:  <br> <br>
<c:forEach items="${products}" var="order_product">
  ${order_product.product.name} <br>
  Quantity: ${order_product.quantity} <br>
  Price/Unit: ${order_product.product.price} <br>
  Total for this product: ${order_product.amount} <br> <br>
</c:forEach>
Total for this order: ${order.amount} <br>
Date Created: ${order.dateCreated} <br>
Last Update: ${order.dateUpdated} <br>
<a href="${selectProduct}">Add Product to this Order</a><br>
<a href="/orders/">View all orders</a>
</body>
</html>
