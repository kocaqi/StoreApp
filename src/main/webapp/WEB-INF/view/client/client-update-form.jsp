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

Update Client

<%--@elvariable id="client" type=""--%>
<form:form action="updateClient" modelAttribute="client" method="POST">
  <form:hidden path="id"/>
  First Name: <form:input type="text" path="firstName" placeholder="First Name"/> <br>
  Last Name: <form:input type="text" path="lastName" placeholder="Last Name"/> <br>
  Email: <form:input type="text" path="email" placeholder="Email"/> <br>
  <input type="submit" value="Save"/>
</form:form>


</body>
</html>