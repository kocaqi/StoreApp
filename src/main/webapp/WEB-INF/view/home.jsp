<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31/08/2022
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
Welcome ${user.firstName} ${user.lastName}
<br>
<br> <%--You are logged in as:
<security:authentication property="principal.role"/>
<br>
<br>--%>

<security:authorize access="hasRole('ROLE_ADMIN')">
    <a href="users/">Users</a>
    <br>
    <br>
</security:authorize>
<a href="clients/">Clients</a>
<br>
<br>
<security:authorize access="hasRole('ROLE_ADMIN')">
    <a href="products/">Products</a>
    <br>
    <br>
</security:authorize>
<a href="orders/">Orders</a>
<br>
<br>

<form:form action="${pageContext.request.contextPath}/logout"
           method="post">
    <input type="submit" value="Logout"/>
</form:form>

</body>
</html>
