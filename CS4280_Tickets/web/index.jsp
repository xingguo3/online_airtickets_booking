<%-- 
    Document   : index
    Created on : Mar 20, 2017, 8:26:50 PM
    Author     : jzhang387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="./css/datepicker.css"/>
<html>
    <jsp:useBean id="user" scope="session" class="beans.UserBean" />
    <script type="text/javascript" src="./js/datepicker.js"></script>
    <script type="text/javascript">
        function disableReturn() {
            document.getElementById('return').style.visibility = "hidden";

        }
        function enableReturn() {
            document.getElementById('return').style.visibility = "visible";

        }
        function validate() {
            if (document.forms["form"].departure.value == "" || document.forms["form"].destination.value == "") {
                alert("You must input all fields");
                return false;
            }

            return true;

        }

    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>A TRIP Home</title>
    </head>
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
                        <% if(request.getSession().getAttribute("userbean")==null)%>
                        <a href="./login.jsp" class="login_btn">Login</a>
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

                <FORM id="form" ACTION="SearchFlightHandler" METHOD="POST">
                    <input type='hidden' name='role' value='passager' />
                    <input type="radio" name="type" value="single" onclick="disableReturn()" checked="checked">single trip
                    <input type="radio" name="type" value="round" onclick="enableReturn()">round trip<BR>

                    Departure: <INPUT TYPE="TEXT" NAME="departure">
                    Destination: <INPUT TYPE="TEXT" NAME="destination"><BR>
                    Departure Date: 
                    <INPUT TYPE="TEXT" class="date" NAME="startDate" style='width:10%'>
                    <input type=button class="button" value="Select Date" onclick="displayDatePicker('startDate', this);">
                    <div id="return">
                        Return Date : 
                        <INPUT TYPE="TEXT" class="date" NAME="returnDate" style='width:10%'>
                        <input type=button class="button" name="rdCalendar" value="Select Date" onclick="displayDatePicker('returnDate', this);"><BR>
                    </div>
                    <P>
                        <INPUT onclick="return validate();"  class="button" TYPE="SUBMIT"  NAME="flights" VALUE="Search">
                    </p>
                </FORM>
            </div>


        </section><!--  end search section  -->

        <!-- <p>No Account? <a href="./RegistHandler">Register</a></p>-->
      
    </body>
      <footer>

        <div class="copyrights wrapper">
            This web site exists to fulfill the coursework requirement of CS4280.
            <br/>Do not use your real personal data as input.
            <br/>Copyright © 2017 atrip.com. All Rights Reserved.
        </div>
    </footer><!--  end footer  -->

</html>
