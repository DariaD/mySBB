<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 08.03.2015
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SearchResult</title>
</head>
<body>

<h1>Trains:</h1>

<h2>From <% request.getAttribute("selectedStationFrom"); %> to  <% request.getAttribute("selectedStationTo"); %>  </h2>
<form name="trainForm" action=<%= response.encodeURL("TicketBuy") %> method="get">
    <div name = "trainSelected">
    <%Iterator itr;%>
    <% List data= (List)request.getAttribute("suitableTrainList");
        for (itr=data.iterator(); itr.hasNext(); ) {
            Object next = itr.next();
            out.println("<input type=\"radio\" name=\"train\" value=\""+ next + "\"/>" +  next  + "<br/>");
        }%>
    </div>
    <input type="submit" value="Buy Ticket" />
    <input type="reset" value="Reset" />
</form>
</body>
</html>
