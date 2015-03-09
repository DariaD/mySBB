<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 07.03.2015
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegistrationError</title>
</head>
<body>
<br>
<h2>This User already exist or user data is not correct.</h2>
<form method="POST" action='<%= response.encodeURL("Registration") %>' >
    <table border="0" cellspacing="5">
        <tr>
            <td align="right"><input type="button" onclick="history.back();"  value="Back"></td>
        </tr>
    </table>
</form>
</body>
</html>
