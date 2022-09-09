<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>CLient Form</title>
</head>
<body>

Add Client

<%--@elvariable id="client" type=""--%>
<form:form action="saveClient" modelAttribute="client" method="POST">
    <form:input type="text" path="firstName" placeholder="First Name"/> <br>
    <form:input type="text" path="lastName" placeholder="Last Name"/> <br>
    <form:input type="text" path="email" placeholder="Email"/> <br>
    <input type="submit" value="Save"/>
</form:form>


</body>
</html>