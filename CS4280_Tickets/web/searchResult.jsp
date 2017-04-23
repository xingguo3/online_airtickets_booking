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

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Search Result</title>
    </head>
    <% ArrayList<FlightBean> deptList = (ArrayList<FlightBean>) request.getAttribute("deptFlight");
        ArrayList<FlightBean> rtList = (ArrayList<FlightBean>) request.getAttribute("returnFlight");
    %>

    <body>
        <section class="hero">
            <header>
                <div class="wrapper">
                    <a href="./index.jsp"><img src="img/logo.png" class="logo" alt="" titl=""/></a>

                    <nav>
                        <ul>
                            <% if(request.getSession().getAttribute("userbean")==null){%>
                            <li><a href="./ManageBookingHandler">History</a></li>
                            <li><a href="">My Account Level</a></li>
                            <%}%>
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
        <h2>Search Result:</h2>
        <table>

            <% if (deptList.size() == 0){ %>
            <tr>No Flight Found</tr>

            <% }else if (deptList.size() != 0) { %>
            <tr>
                <td>Flight No</td>
                <td>Company</td>
                <td>From</td>
                <td>To</td>
                <td>Departure Time</td>
                <td>Arrive Time</td>
                <td>Price</td>
                <td></td>
            </tr>
            <% for (FlightBean dept : deptList) {%>
                    </tr><td> <%=dept.getFlightNo() %></td>
                    <td><%=dept.getCompany() %></td>
                    <td><%= dept.getFrom() %></td>
                    <td><%=dept.getTo() %></td>
                    <td><%= dept.getDeptTime() %></td>
                    <td><%= dept.getArrivTime() %></td>
                    <td><%= dept.getPrice() %>HKD</td>
                    <td> <a href="<%=request.getContextPath()%>/FlightBookHandler?fid=<%=dept.getFID()%>&trip=go">Book</a></td></tr>
              <%  }
             } %>

            
        </table>
        <table>

            <% if (rtList!=null&&rtList.size() == 0){ %>
            <tr>No Flight Found</tr>

            <% }else if (rtList!=null&&rtList.size() != 0) { %>
            <tr>
                <td>Flight No</td>
                <td>Company</td>
                <td>From</td>
                <td>To</td>
                <td>Departure Time</td>
                <td>Arrive Time</td>
                <td>Price</td>
                <td></td>
            </tr>
            <% for (FlightBean rt : rtList) {%>
                     </tr><td> <%=rt.getFlightNo() %></td>
                     <td><%=rt.getCompany() %></td>
                    <td><%= rt.getFrom() %></td>
                    <td><%=rt.getTo() %></td>
                    <td><%= rt.getDeptTime() %></td>
                    <td><%= rt.getArrivTime() %></td>
                    <td><%= rt.getPrice() %>HKD</td>
                    <td> <a href="<%=request.getContextPath()%>/FlightBookHandler?fid=<%=rt.getFID()%>&trip=back">Book</a></td></tr>
            <%  }
            
             } %>

            
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
