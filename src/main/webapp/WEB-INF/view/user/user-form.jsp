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

Add User

<%--@elvariable id="user" type=""--%>
<form:form action="saveUser" modelAttribute="user" method="POST">
    <form:input type="text" path="firstName" placeholder="First Name"/> <br>
    <form:input type="text" path="lastName" placeholder="Last Name"/> <br>
    <form:input type="text" path="email" placeholder="Email"/> <br>
    <form:input type="password" path="password" placeholder="Password"/> <br>
    <form:select path="role">
        <option value="ROLE_ADMIN">Admin</option>
        <option value="ROLE_OPERATOR">Operator</option>
    </form:select>
    <input type="submit" value="Save"/>
</form:form>


</body>
</html>