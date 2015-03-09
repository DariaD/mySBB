<%--
  Created by IntelliJ IDEA.
  User: Daria
  Date: 20.02.2015
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Blablabla</title>
  </head>
  <body>
 <%=(request.getAttribute("msg"))%>
 Counter: <%=(request.getAttribute("current_count")==null ? "error" : request.getAttribute("current_count") )%>
  </body>
</html>
