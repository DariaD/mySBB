<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 08.03.2015
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form action='<%= response.encodeURL("Search") %>' method="post">
    <table border="0" cellspacing="5">
        <tr>
            Station From:
            <select name="selectedStationFrom" size="1">
                <%Iterator stItr1;%>
                <% List stationFrom= (List)request.getAttribute("stationNames");
                    for (stItr1=stationFrom.iterator(); stItr1.hasNext(); ) {
                        out.println("<option>" + stItr1.next() + "</option>");
                    }%>
            </select>
        </tr>


        <tr>
            Station To:
            <select name="selectedStationTo" size="1">
                <%Iterator stItr2;%>
                <% List stationTo= (List)request.getAttribute("stationNames");
                    for (stItr2=stationTo.iterator(); stItr2.hasNext(); ) {
                        out.println("<option>" + stItr2.next() + "</option>");
                    }%>
            </select>

        </tr>

        <tr>
            <th align="right">Date:</th>
            <td align="left"><input type="date" name="date"></td>
        </tr>

        <tr>
            <td align="right"><input type="submit" value="submit"></td>
            <td align="left"><input type="reset"></td>
        </tr>
    </table>
</form>

<form action='<%= response.encodeURL("ShowStationSchedule") %>' method="post">
    <table border="0" cellspacing="5">
        <tr>
            Station From:
            <select name="selectedStation" size="1">
                <%Iterator stItr3;%>
                <% List station= (List)request.getAttribute("stationNames");
                    for (stItr3=station.iterator(); stItr3.hasNext(); ) {
                        out.println("<option>" + stItr3.next() + "</option>");
                    }%>
            </select>
        </tr>


        <tr>
            <td align="right"><input type="submit" value="Show"></td>
            <td align="left"><input type="reset"></td>
        </tr>
    </table>
</form>

</body>
</html>
