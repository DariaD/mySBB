<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 07.03.2015
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница успешного входа в систему</title>
</head>
<body>
<br>
<h1>Log in success!</h1>
<jsp:useBean id="user" class="servlets.User" scope="application"/>
<h2>Hallo <%= user.getUser()%></h2>
User: <%= user.getUser()%><br>
Date of Birth: <%= user.getdateOfBerth()%><br>



</body>
</html>
