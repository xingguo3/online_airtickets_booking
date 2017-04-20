<%-- 
    Document   : viewDetail
    Created on : 2017-4-19, 18:17:51
    Author     : User
--%>

<%@page import="beans.BookedTicketBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% BookedTicketBean b=(BookedTicketBean)request.getAttribute("history");%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Flight No:<%= b.getFlight().getFlightNo()%></p>
        <p>Flight Status: <%=b.getFlight().getStatus()%></p>
        <p>Booking Time: <%= b.getBTime().toString()%></p>
        <p>From <%= b.getFlight().getFrom()%> To <%= b.getFlight().getTo()%></p>
        <p><%= b.getFlight().getDeptTime()%> To <%=b.getFlight().getArrivTime()%></p>
        <p>Passenger: <%= b.getLname()%><%=b.getFname()%></p>
        <p>Actual Price: <%= b.getActualPrice()%> HKD</p>
        <p>Status:<%= b.getStatus()%>
        <% if(b.getStatus().equals("Normal")){%>
            <a href="/CS4280_Tickets/ApplyRefundHandler?id=<%= b.getId()%>">Apply for Refund</a>
            <% }%>
        </p>
        <button onclick="window.print()">Print</button>
    </body>
</html>
