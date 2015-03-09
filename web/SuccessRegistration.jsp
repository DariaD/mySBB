<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 07.03.2015
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SuccessRegistration</title>
</head>
<body>
<h1>Congratulations!!!</h1>
<jsp:useBean id="user" class="com.jpa.entity.User" scope="application"/>
User: <%= user.getLogin()%><br>
First Name: <%= user.getFirstName()%><br>
Second Name: <%= user.getSecondName()%><br>
Date of Birth: <%= user.getDateOfBirth()%><br>
Successfully registered.<br><br>
<a href="Authentication.jsp">Log in</a>
</body>
</html>
