<%-- 
    Document   : welcome
    Created on : Apr 10, 2017, 2:41:47 PM
    Author     : GUOXING
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="./js/datepicker.js"></script>
    <script type="text/javascript">
        function disableReturn(){
            document.getElementById('return').style.visibility = "hidden"; 
            
        }
        function enableReturn(){
            document.getElementById('return').style.visibility = "visible"; 
            
         }

    </script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to CityExpress</title>
    </head>
    <body>
        <jsp:useBean id="userbean" class="beans.UserBean" scope="session" />
        <h1>Hello, <%= userbean.getFirstName()%> <%= userbean.getLastName()%></h1>
        <h1>Welcome to Air Web</h1><BR>
        <input type="button" value="single trip" onclick="disableReturn()">
        <input type="button" value="round trip" onclick="enableReturn()">
        
        <FORM id="round" ACTION="SearchFlightHandler" METHOD="POST">
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
                <INPUT TYPE="SUBMIT" NAME="flights" VALUE="Search">
            </p>
        </FORM>
        <a href=''>Show my account level</a>
        <a href=''>Upgrade my account</a>
        <a href=''>show miles</a>
        <a href=''>show bonus</a>
        <a href=''>purchase history</a> 
       
    </body>
</html>
