<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 07.03.2015
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Регистрация посетителей</h1>
<form action="AddUser" method="post">
    User Name: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    First Name: <input type="text" name="firstName"><br>
    Second Name: <input type="text" name="secondName"><br>
    Date of Birth: <input type="date" name="dateOfBirth"><br>
    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="save" value="Save">
            </small>
            <th><small>
                <input type="submit" name="cancel" value="Back">
            </small>
    </table>
</form>
</body>
</html>