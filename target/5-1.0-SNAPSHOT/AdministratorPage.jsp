<%@ page import="com.jpa.entity.Train" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 07.03.2015
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Hallo Admin! :)</title>
</head>
<body>
<h1>Welcome, dear administrator! </h1>

<h3>Add Station</h3>
<form method="POST" action='<%= response.encodeURL("AddStation") %>' >
    <table border="0" cellspacing="5">
        <tr>
            <th align="right">New station:</th>
            <td align="left"><input type="text" name="newStation"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="Add"></td>
            <td align="left"><input type="reset"></td>
        </tr>
    </table>
</form>
<h3>Add Train</h3>
<form method="POST" action='<%= response.encodeURL("AddTrain") %>' >
    <table border="0" cellspacing="5">
        <tr>
            <th align="right">Train Name:</th>
            <td align="left"><input type="text" name="trainname"></td>
        </tr>
        <tr>
            <th align="right">Number of seats:</th>
            <td align="left"><input type="text" name="number"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="Add"></td>
            <td align="left"><input type="reset"></td>
        </tr>

    </table>
</form>


<h3>Add Schedule</h3>


<form action='<%= response.encodeURL("AddRoute") %>' method="post" name="trainName">
    <table border="0" cellspacing="5">
        <tr>
            Train name:

             <select name="selectedTrain" size="1">
            <%Iterator trainItr;%>
            <% List data= (List)request.getAttribute("trainNames");
                for (trainItr=data.iterator(); trainItr.hasNext(); ) {
                    out.println("<option>" + trainItr.next() + "</option>");
                }%>
             </select>
        </tr>

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
            <th align="right">Date:</th>
            <td align="left"><input type="date" name="dateFrom"></td>
        </tr>

        <tr>
            <th align="right">Time:</th>
            <td align="left"><input type="time" name="timeFrom"></td>
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
            <td align="left"><input type="date" name="dateTo"></td>
         </tr>

        <tr>
            <th align="right">Time:</th>
            <td align="left"><input type="time" name="timeTo"></td>
        </tr>


        <tr>
            <td align="right"><input type="submit" value="submit"></td>
            <td align="left"><input type="reset"></td>
        </tr>
    </table>
</form>

<h3>Look passengers</h3>
<form method="POST" action='<%= response.encodeURL("PassengerViewer") %>' >
    <table border="0" cellspacing="5">
        <tr>
            Station To:
            <select name="selectedScheduleRecord" size="1">
                <%Iterator schItr;%>
                <% List scheduleRecord = (List)request.getAttribute("schedulesList");
                    for (schItr=scheduleRecord.iterator(); schItr.hasNext(); ) {
                        out.println("<option>" + schItr.next() + "</option>");
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
