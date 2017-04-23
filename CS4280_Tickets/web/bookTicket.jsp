<%-- 
    Document   : bookTicket
    Created on : Mar 20, 2017, 8:41:58 PM
    Author     : jzhang387
--%>

<%@page import="beans.UserBean"%>
<%@page import="beans.FlightBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Book Ticket</title>
    </head>
    
    <% FlightBean f=(FlightBean)request.getAttribute("book");
        UserBean user=(UserBean)request.getSession().getAttribute("userbean");
        int price=f.getPrice();
    %>
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
        <h2>Book Tickets for Your <%=request.getAttribute("round")%> Trip</h2>
        <form action="ConfirmBookHandler" method="post" id="form">
        <p>Flight No: <%= f.getFlightNo()%></p>
        <p>Departure Time: <%= f.getDeptTime()%></p>
        <p>Arrive Time: <%=f.getArrivTime()%></p>
        <input type="hidden" name="fid" value='<%=f.getFID()%>'>
        <p>Last Name:<input type="text" name="lastname" ></p>
        <p>First Name:<input type="text" name="firstname"></p>
<!--        <button onclick="addPassenger()" type="button" value="Add One More Passenger">Add One More Passenger</button>   -->
<!--        <div id="second"></div> -->
        <p>Price: <%=f.getPrice()%> HKD</p>
        <button class="button" onclick="return validate();" type='submit' value="confirm">Confirm</button>
        </form>
        </div>
        </section><!--  end search section  -->
    </body>
    <script type="text/javascript">
        function conf(){
            if(confirm("Are you sure to book?")){
                   return true;
            }
            return false;    
        }
        function validate(){
            if(document.forms["form"].lastname.value==""||document.forms["form"].firstname.value==""){
                    alert("You must input all fields");
                     return false;  
                   }
                   
             return conf();
        }
        </script>
  
        <footer>
        <div class="copyrights wrapper">
            This web site exists to fulfill the coursework requirement of CS4280.
            <br/>Do not use your real personal data as input.
            <br/>Copyright © 2017 atrip.com. All Rights Reserved.
        </div>
    </footer><!--  end footer  -->
</html>
