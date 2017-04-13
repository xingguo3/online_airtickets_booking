<%-- 
    Document   : searchResult
    Created on : Mar 20, 2017, 8:33:17 PM
    Author     : jzhang387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.awt.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="beans.FlightBean" %>

<!DOCTYPE html>
<jsp:useBean id="flight" scope="session" class="beans.FlightBean" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% ArrayList<FlightBean> deptList = (ArrayList<FlightBean>) request.getAttribute("deptFlight");
        ArrayList<FlightBean> returnList = (ArrayList<FlightBean>) request.getAttribute("deptFlight");
    %>

    <body>
        <h1>Search Result:</h1>
        <table>

            <% if (deptList.size() == 0){ %>
            <tr>No Flight Found</tr>

            <% }else if (deptList.size() != 0) { %>
            <tr>
                <td>Flight No</td>
                <td>From</td>
                <td>To</td>
                <td>Departure Time</td>
                <td>Arrive Time</td>
                <td>Price</td>
                <td></td>
            </tr>
            <% for (FlightBean dept : deptList) {
                    out.print("<tr><td>" + dept.getFlightNo() + "</td>");
                    out.print("<tr><td>" + dept.getFrom() + "</td>");
                    out.print("<tr><td>" + dept.getTo() + "</td>");
                    out.print("<tr><td>" + dept.getDeptTime().toString() + "</td>");
                    out.print("<tr><td>" + dept.getArrivTime().toString() + "</td>");
                    out.print("<tr><td>" + dept.getPrice() + "</td>");
                    out.print("<td> <a href='FlightBookHandler?fno=" + dept.getFlightNo() + "'>Book</a></td><tr>");
                }%>
            
            <% } %>

            
        </table>
        <table>

            <% if (deptList.size() == 0){ %>
            <tr>No Flight Found</tr>

            <% }else if (deptList.size() != 0) { %>
            <tr>
                <td>Flight No</td>
                <td>From</td>
                <td>To</td>
                <td>Departure Time</td>
                <td>Arrive Time</td>
                <td>Price</td>
                <td></td>
            </tr>
            <% for (FlightBean dept : deptList) {
                    out.print("<tr><td>" + dept.getFlightNo() + "</td>");
                    out.print("<tr><td>" + dept.getFrom() + "</td>");
                    out.print("<tr><td>" + dept.getTo() + "</td>");
                    out.print("<tr><td>" + dept.getDeptTime().toString() + "</td>");
                    out.print("<tr><td>" + dept.getArrivTime().toString() + "</td>");
                    out.print("<tr><td>" + dept.getPrice() + "</td>");
                    out.print("<td> <a href='FlightBookHandler?fno=" + dept.getFlightNo() + "'>Book</a></td></tr>");
                }%>
            
            <% } %>

            
        </table>
            </br>
        
    </body>
</html>
