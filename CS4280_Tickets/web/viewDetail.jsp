<%-- 
    Document   : viewDetail
    Created on : 2017-4-19, 18:17:51
    Author     : User
--%>

<%@page import="beans.BookedTicketBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <% BookedTicketBean b=(BookedTicketBean)request.getAttribute("history");%>
     
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Flight Detail</title>
    </head>
    <body>
        <section class="hero">
            <header>
                <div class="wrapper">
                    <a href="./index.jsp"><img src="img/logo.png" class="logo" alt="" titl=""/></a>

                    <nav>
                        <ul>
                            <li><a href="./ManageBookingHandler">History</a></li>
                            <li><a href="">My Account Level</a></li>
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
             <div id="ncontent">
        <p>Flight No:<%= b.getFlight().getFlightNo()%></p>
        <p>Flight Status: <%=b.getFlight().getStatus()%></p>
        <p>Booking Time: <%= b.getBTime().toString()%></p>
        <p>From <%= b.getFlight().getFrom()%> To <%= b.getFlight().getTo()%></p>
        <p><%= b.getFlight().getDeptTime()%> To <%=b.getFlight().getArrivTime()%></p>
        <p>Passenger: <%= b.getLname()%><%=b.getFname()%></p>
        <p>Actual Price: <%= b.getActualPrice()%> HKD</p>
        <p>Status:<%= b.getStatus()%>
        <% if(b.getStatus().equals("Unused")){%>
            <a href="/CS4280_Tickets/ApplyRefundHandler?id=<%= b.getId()%>">Apply for Refund</a>
            <% }%>
        </p>
        <button class="button" onclick="window.print()">Print</button>
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
    </footer><!--  end footer  --></html>
