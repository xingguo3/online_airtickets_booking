<%-- 
    Document   : welcome
    Created on : Apr 10, 2017, 2:41:47 PM
    Author     : GUOXING
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
        <title>Welcome to CityExpress</title>
    </head>
    <body>
        <jsp:useBean id="userbean" class="beans.UserBean" scope="session" />
        <h1>Hello,  <%= userbean.getFirstName()%> <%= userbean.getLastName()%></h1>
        <h1>Welcome to Air Web</h1><BR>
        

        <FORM name="form" ACTION="SearchFlightHandler" METHOD="POST">
            <input type='hidden' name='role' value='customer' />
            <input type="radio" name="type" value="single" onclick="disableReturn()">single trip
            <input type="radio" name="type" value="round" onclick="enableReturn()">round trip<br>
        

            Departure from: <INPUT TYPE="TEXT" NAME="departure"><BR>
            Destination: <INPUT TYPE="TEXT" NAME="destination"><BR>
            Departure Date: 
            <INPUT TYPE="TEXT" class="date" NAME="startDate" style='width:10%'>
            <input type=button value="Select Date" onclick="displayDatePicker('startDate', this);"><BR>
            <div id="return">
                Return Date : 
            <INPUT TYPE="TEXT" class="date" NAME="returnDate" style='width:10%'>
            <input type=button name="rdCalendar" value="Select Date" onclick="displayDatePicker('returnDate', this);"><BR>
            </div>
            <P>
                <INPUT onclick="return validate();" TYPE="SUBMIT" NAME="flights" VALUE="Search" >
            </p>
        </FORM>
        <a href=''>Show my account level</a>
        <a href=''>Upgrade my account</a>
        <a href='/CS4280_Tickets/ManageBookingHandler'>purchase history</a> 
       
        <br/><a href='./LogoutHandler'>Logout</a>
    </body>
    <footer>This web site exists to fulfill the coursework requirement of CS4280.<br/>Do not use your real personal data as input.
</html>
