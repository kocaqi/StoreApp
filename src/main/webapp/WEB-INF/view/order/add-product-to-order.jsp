<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14/09/2022
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
Add Product to Order #${order.id}
<br>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${products}" var="order_product">
        <tr>
            <c:url var="addProductToOrder" value="/orders/addProduct">
                <c:param name="productId" value="${order_product.id}"/>
                <c:param name="orderId" value="${order.id}"/>
            </c:url>
            <td>${order_product.name}</td>
            <td>${order_product.price}</td>
            <td>${order_product.stock}</td>
            <td><a href="${addProductToOrder}">Add To Order</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
