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

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Search Result</title>
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
        <% ArrayList<FlightBean> deptList = (ArrayList<FlightBean>) request.getAttribute("deptFlight");
            ArrayList<FlightBean> rtList = (ArrayList<FlightBean>) request.getAttribute("returnFlight");
        %>

    <section class="search">
            <div class="wrapper">
                <div id="content">
                    <h2>Search Result:</h2>
                    <table>

                        <% if (deptList.size() == 0) { %>
                        <tr>No Flight Found</tr>

                        <% } else if (deptList.size() != 0) { %>
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
                                out.print("<td>" + dept.getFrom() + "</td>");
                                out.print("<td>" + dept.getTo() + "</td>");
                                out.print("<td>" + dept.getDeptTime() + "</td>");
                                out.print("<td>" + dept.getArrivTime() + "</td>");
                                out.print("<td>" + dept.getPrice() + "HKD</td>");
                                out.print("<td><a href='" + request.getContextPath() + "/ManagerFlightHandler?action=update&fid=" + dept.getFID()
                                        + "&trip=go'>Update</a></td>");
                                out.print("<td><a href='" + request.getContextPath() + "/ManagerFlightHandler?action=delete&fid=" + dept.getFID()
                                        + "&trip=go'>Delete</a></td></tr>");
                            }%>

                        <% } %>


                    </table>
                    <table>

                        <% if (rtList != null && rtList.size() == 0) { %>
                        <tr>No Flight Found</tr>

                        <% } else if (rtList != null && rtList.size() != 0) { %>
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
                                out.print("<td>  <a href='" + request.getContextPath() + "/FlightBookHandler?fid=" + rt.getFID()
                                        + "&trip=back'>Book</a></td></tr>");
                            }%>

                        <% }%>


                    </table>
                    </br>
                    <a href="./managerIndex.jsp">Go back</a>
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
