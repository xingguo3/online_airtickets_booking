<%-- 
    Document   : managerAddTick
    Created on : Apr 17, 2017, 3:40:53 PM
    Author     : GUOXING
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="./css/datepicker.css"/>
<script type="text/javascript" src="./js/datepicker.js"></script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Add Flight</title>
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
                <div id="ncontent">
                    <h1>Fill in below form</h1>
                    <form id="form" action="./ManagerFlightHandler" method='POST'>
                        <input type='hidden' name='action' value='addnew'/>
                        <p>Flight No.: <input type='text' name='fno'/></p>
                        <p>From: <input type='text' name='from'/></p>
                        <p>to: <input type='text' name='to'/></p>
                        <p>Date: <input class="date" name='date'/>
                            <input type=button value="Select Date" onclick="displayDatePicker('date', this);"></p>
                        <p>Take off: <input type='texe' name='takeoff' value='yyyy-mm-dd hh:mm:ss'/></p>
                        <p>Land: <input type='text' name='land' value='yyyy-mm-dd hh:mm:ss'/></p>
                        <p>Company: <input type='text' name='company'/></p>
                        <p>Price(HKD): <input type='text' name='price'/></p>
                        <p>Total Seats: <input type='text' name='seats'/></p>
                        <p><input type='submit' value='Confirm' onclick="return validate();"/><p>
                    </form>
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
