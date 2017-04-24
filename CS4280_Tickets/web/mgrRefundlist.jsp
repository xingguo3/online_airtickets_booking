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

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Manage Refund</title>
    </head>
    <body>
        <section class="hero">
            <header>
                <div class="wrapper">
                    <a href="./index.jsp"><img src="img/logo.png" class="logo" alt="" titl=""/></a>

                    <nav>
                        <ul>
                            <li><a href="./ManageBookingHandler">History</a></li>
                            <li><a href="./accountLevel.jsp">My Account Level</a></li>
                            <li><a href="#">Contact</a></li>
                        </ul>
                        <% if (request.getSession().getAttribute("userbean") == null) {%>
                        <a href="./login.jsp" class="login_btn">Login</a>
                        <%} else {%>
                        <a href='./LogoutHandler' class="login_btn">Logout</a>
                        <%}%>
                    </nav>
                </div>
            </header><!--  end header section  -->

            <section class="caption">
                <h2 class="caption">Book Ticket For Your Trip</h2>
                <h3 class="properties">cheap-fast-convenient</h3>
            </section>
        </section><!--  end hero section  -->
        <section class="search">
            <div class="wrapper">
                <div id="content">
        <h2>refund list</h2>
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
    </div>

            </div>


        </section><!--  end search section  -->
    </body>
    <footer>

        <div class="copyrights wrapper">
            This web site exists to fulfill the coursework requirement of CS4280.
            <br/>Do not use your real personal data as input.
            <br/>Copyright © 2017 atrip.com. All Rights Reserved.
        </div>
    </footer><!--  end footer  -->      
</html>
