<%-- 
    Document   : manageTicket
    Created on : Mar 20, 2017, 8:46:52 PM
    Author     : jzhang387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="./css/datepicker.css"/>
<script type="text/javascript" src="./js/datepicker.js"></script>
    <script type="text/javascript">
        function disableReturn(){
            document.getElementById('return').style.visibility = "hidden"; 
            
        }
        function enableReturn(){
            document.getElementById('return').style.visibility = "visible"; 
            
         }
         function validate(){
             if(document.forms["form"].departure.value==""||document.forms["form"].destination.value==""||document.forms["form"].startDate.value==""){
            alert   ("You must input all fields");
             return false;  
         }
         return true;
               
         }

    </script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Manage Tickets</title>
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
        <FORM id="form" action='./SearchFlightHandler' method ='POST'>
            <LEGEND>Search Tickets</legend>
            <input type='hidden' name='role' value='manager' />
            <input name='departure' type='text' value=''/>
            <input name = 'destination' type='text' value = ''/>
            <input name = 'startDate' type='TEXT' class="date"/>
            <INPUT TYPE="hidden" class="date" NAME="returnDate" />
            <input type=button value="Select Date" onclick="displayDatePicker('startDate', this);">
            <input type='submit' value='Submit'/>
        </FORM>
        <a href='./managerAddTick.jsp'>add new flights</a>
     
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
