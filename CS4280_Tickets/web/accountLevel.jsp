<%-- 
    Document   : manageBooking
    Created on : Mar 20, 2017, 8:47:02 PM
    Author     : jzhang387
    customer check purchase history
--%>

<%@page import="beans.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% UserBean u=(UserBean)request.getSession().getAttribute("userbean");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>My Account Level</title>
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
                    Hello, <%=u.getFirstName()%> <%=u.getLastName()%></br>
                    Your Account Level is <%=u.getMembership()%></br>
                    <%if(u.getMembership()==0){%>
                    You are our basic members, you don't have any extra discount.</br>
                    You can <a href='./AccountLevelHandler'>update</a> your membership to get more discount.</br>
                    Price from basic members to vip members: 500HKD.</br>
                    <%}if(u.getMembership()==1){%>
                    You are our vip silver members, you have extra discount up to 10% off.</br>
                    You can <a href='./AccountLevelHandler'>update</a> your membership to get more discount.</br>
                    Price from vip silver members to vip gold members: 1000HKD.</br>
                    <%}if(u.getMembership()==2){%>
                    You are our vip gold members, you have extra discount up to 20% off.</br>
                    You can <a href='./AccountLevelHandler'>update</a> your membership to get more discount.</br>
                    Price from vip gold members to vip diamond members: 2000HKD.</br>
                    <%}if(u.getMembership()==3){%>
                    You are our vip diamond members, you have extra discount up to 30% off.</br>
                    <%}if(u.getMembership()==4){%>
                    You are manager.</br>
                    <%}%>
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
