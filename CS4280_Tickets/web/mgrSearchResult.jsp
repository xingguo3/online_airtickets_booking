<%-- 
    Document   : searchResult
    Created on : Mar 20, 2017, 8:33:17 PM
    Author     : xingguo3
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
        <title>Modify Tickets(mgr)</title>
    </head>
    <% ArrayList<FlightBean> deptList = (ArrayList<FlightBean>) request.getAttribute("deptFlight");
        ArrayList<FlightBean> rtList = (ArrayList<FlightBean>) request.getAttribute("returnFlight");
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
                    out.print("</tr><td>" + dept.getFlightNo() + "</td>");
                    out.print("<td>" + dept.getFrom() + "</td>");
                    out.print("<td>" + dept.getTo() + "</td>");
                    out.print("<td>" + dept.getDeptTime() + "</td>");
                    out.print("<td>" + dept.getArrivTime() + "</td>");
                    out.print("<td>" + dept.getPrice() + "HKD</td>");
                    out.print("<td> <a href='"+request.getContextPath()+"/UpdateFlightHandler?fid=" + dept.getFID() 
                            + "&trip=go'>Update</a></td></tr>");
                    out.print("<td> <a href='"+request.getContextPath()+"/DeleteFlightHandler?fid=" + dept.getFID() 
                            + "&trip=go'>Delete</a></td></tr>");
                }%>
            
            <% } %>

            
        </table>
        <table>

            <% if (rtList!=null&&rtList.size() == 0){ %>
            <tr>No Flight Found</tr>

            <% }else if (rtList!=null&&rtList.size() != 0) { %>
            <tr>
                <td>Flight No</td>
                <td>From</td>
                <td>To</td>
                <td>Departure Time</td>
                <td>Arrive Time</td>
                <td>Price</td>
                <td></td>
            </tr>
            <% for (FlightBean rt : rtList) {
                    out.print("<td>" + rt.getFlightNo() + "</td>");
                    out.print("<td>" + rt.getFrom() + "</td>");
                    out.print("<td>" + rt.getTo() + "</td>");
                    out.print("<td>" + rt.getDeptTime() + "</td>");
                    out.print("<td>" + rt.getArrivTime() + "</td>");
                    out.print("<td>" + rt.getPrice() + "HKD</td>");
                    out.print("<td>  <a href='"+request.getContextPath()+"/FlightBookHandler?fid=" + rt.getFID() 
                            +"&trip=back'>Book</a></td></tr>");
                }%>
            
            <% } %>

            
        </table>
            </br>
        
    </body>
</html>
