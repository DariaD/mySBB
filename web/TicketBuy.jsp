<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 08.03.2015
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy a Ticket</title>
</head>
<body>
<h2>Check your data please:</h2>
<form action='<%= response.encodeURL("TicketBuy") %>' method="post" name="trainName">
    <table border="0" cellspacing="5">


        <tr>
            <th align="right">Train:</th>
            <td align="left"><%=request.getAttribute("travel")%></td>
        </tr>



        <tr>
            <td align="right"><input type="submit" value="submit"></td>
            <td align="left"><input type="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
