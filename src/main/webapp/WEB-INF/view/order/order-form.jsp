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

    <%--Register the client--%>

    <%--Add products one by one--%>
        <%--Enter product name--%>
        <%--Enter product quantity--%>

    <input type="submit" value="Save"/>
</form:form>


</body>
</html>