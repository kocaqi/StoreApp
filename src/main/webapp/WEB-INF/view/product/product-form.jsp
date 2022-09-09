<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Form</title>
</head>
<body>

Add Product

<%--@elvariable id="product" type=""--%>
<form:form action="saveProduct" modelAttribute="product" method="POST">
    <form:input type="text" path="name" placeholder="Name"/> <br>
    <form:input type="number" path="price" placeholder="Price"/> <br>
    <form:input type="number" path="stock" placeholder="Stock"/> <br>
    <input type="submit" value="Save"/>
</form:form>


</body>
</html>