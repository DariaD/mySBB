<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 03.03.2015
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mySBB Welcome</title>
</head>
<body>
<h1>Welcome to mySBB system! </h1>

<h2>Please login to continue </h2>
<form method="POST" action='<%= response.encodeURL("Authentication") %>' >
    <table border="0" cellspacing="5">
        <tr>
            <th align="right">Username:</th>
            <td align="left"><input type="text" name="user"></td>
        </tr>
        <tr>
            <th align="right">Password:</th>
            <td align="left"><input type="password" name="pass"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="Log In"></td>
            <td align="left"><input type="reset"></td>
        </tr>
    </table>
</form>

<h2>Are you new User?</h2>

<form method="POST" action='<%= response.encodeURL("Registration") %>' >
    <table border="0" cellspacing="5">
        <tr>
            <td align="right"><input type="submit" value="Registration"></td>
        </tr>
    </table>
</form>

</body>
</html>
