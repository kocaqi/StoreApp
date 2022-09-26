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

    <c:forEach items="${clients}" var="order_product">
        <tr>
            <c:url var="updateLink" value="/clients/update">
                <c:param name="clientId" value="${order_product.id}"/>
            </c:url>
            <td>${order_product.firstName}</td>
            <td>${order_product.lastName}</td>
            <td>${order_product.theUser.firstName} ${order_product.theUser.lastName}</td>
            <td>${order_product.email}</td>
            <td>${order_product.dateCreated}</td>
            <td>${order_product.dateUpdated}</td>
            <td>
                <a href="${updateLink}">Update</a>
                ||

                <form:form method="post" action="/orders/add">
                    <%--<c:url var="createOrder" value="/orders/add">
                        <c:param name="clientId" value="${order_product.id}"/>
                    </c:url>--%>
                    <input type="hidden" value="${order_product.id}" name="clientId">
                    <input  type="submit" value="New Order">
                    <%--<a href="${createOrder}">Create new order</a>--%>
                </form:form>
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