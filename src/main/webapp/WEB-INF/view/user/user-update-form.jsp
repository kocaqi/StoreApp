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

Update User

<%--@elvariable id="user" type=""--%>
<form:form action="updateUser" modelAttribute="user" method="POST">
    <form:hidden path="id"/>
    <form:hidden path="dateCreated"/>
    <form:hidden path="enabled"/>
    First Name: <form:input type="text" path="firstName" placeholder="First Name"/> <br>
    Last Name: <form:input type="text" path="lastName" placeholder="Last Name"/> <br>
    Email: <form:input type="text" path="email" placeholder="Email"/> <br>
    Password: <form:input type="password" path="password" placeholder="Password"/> <br>
    Role: <select name="role">
        <option value="ROLE_ADMIN">Admin</option>
        <option value="ROLE_OPERATOR">Operator</option>
    </select>
    <input type="submit" value="Save"/>
</form:form>


</body>
</html>