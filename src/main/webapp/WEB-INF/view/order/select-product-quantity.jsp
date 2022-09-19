<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forn" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15/09/2022
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Order #${orderProduct.order.id} <br>
Please select quantity for product "${orderProduct.product.name}" <br>
<%--@elvariable id="orderProduct" type=""--%>
<form:form action="saveProduct" modelAttribute="orderProduct" method="GET">
    <form:hidden name="orderId" value="${orderProduct.order.id}" path="order"/>
    <form:hidden name="productId" value="${orderProduct.product.id}" path="product"/>
    <form:input type="number" path="quantity"/>
    <%--<a href="${saveProduct}">Save</a>--%>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
