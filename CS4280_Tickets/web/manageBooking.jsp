<%-- 
    Document   : manageBooking
    Created on : Mar 20, 2017, 8:47:02 PM
    Author     : jzhang387
    customer check purchase history
--%>

<%@page import="beans.BookedTicketBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ArrayList<BookedTicketBean> blist=(ArrayList<BookedTicketBean>)request.getAttribute("history");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
        <title>Booking History</title>
=======
        <title>History</title>
>>>>>>> origin/GUOXing
    </head>
    <body>
        <h1>My Booking</h1>
        <table>
            <% if(blist.size()==0){ %>
            <tr>No History Found</tr>
            <% } else { %>
            <tr>
                <td>Book Date</td>
                <td>Flight No</td>
                <td>Route</td>
                <td>Schedule</td>
                <td>Status</td>
                <td>Price</td>
            </tr>    
            <%for(BookedTicketBean b:blist){%>
                <tr >
                    <td><%= b.getBTime().toString()%></td>
                    <td><%= b.getFlight().getFlightNo()%></td>
                    <td><%= b.getFlight().getFrom()%> --- <%= b.getFlight().getTo()%></td>
                    <td><%= b.getFlight().getDeptTime()%> --- <%=b.getFlight().getArrivTime()%></td>
                    <td><%= b.getStatus()%></td>
                    <td><%= b.getActualPrice()%>HKD</td>
                    <td><a href="/CS4280_Tickets/ViewDetailHandler?id=<%=b.getId()%>">view detail</a></td>
                </tr>
            <%      }
                }%>
        </table>
    </body>
</html>
