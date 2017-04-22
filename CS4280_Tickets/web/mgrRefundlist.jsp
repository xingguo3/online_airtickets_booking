<%-- 
    Document   : mgrRefundlist
    Created on : Apr 19, 2017, 3:15:16 PM
    Author     : GUOXING
    manager check refund list and then take action
--%>
<%@page import="beans.BookedTicketBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ArrayList<BookedTicketBean> blist=(ArrayList<BookedTicketBean>)request.getAttribute("refund");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage refund</title>
    </head>
    <body>
        <h1>refund list</h1>
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
            <%for(BookedTicketBean b:blist){
                    out.print("<tr><td>"+ b.getBTime().toString() +"</td>");
                    out.print("<td>"+ b.getFlight().getFlightNo()+"</td>");
                    out.print("<td>"+ b.getFlight().getFrom()+"---"+  b.getFlight().getTo()+"</td>");
                    out.print("<td>"+ b.getFlight().getDeptTime()+"---"+b.getFlight().getArrivTime()+"</td>");
                    out.print("<td>"+ b.getStatus()+"</td>");
                    out.print("<td>"+ b.getActualPrice()+"HKD</td>");
                    out.print("<td><a href='"+request.getContextPath()+"/ManageRefundHandler?action=approve&id=" + b.getId()
                            + "'>Approve</a></td>");
                    out.print("<td><a href='"+request.getContextPath()+"/ManageRefundHandler?action=refuse&id=" + b.getId() 
                            + "'>Refuse</a></td></tr>");
            }%>
            <% } %>
        </table>
    </body>
</html>
