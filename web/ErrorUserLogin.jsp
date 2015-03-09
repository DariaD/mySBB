<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 08.03.2015
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ErrorLogin</title>
</head>
<body>
<h2>Sorry, there is no such user or password is not correct. Please try again or register.</h2>
<form method="POST" action='<%= response.encodeURL("Registration") %>' >
    <table border="0" cellspacing="5">
        <tr>
            <td align="right"><input type="submit" value="Registration"></td>
        </tr>
        <tr>
            <td align="right"><input type="button" onclick="history.back();"  value="Back"></td>
        </tr>
    </table>
</form>



</body>
</html>
