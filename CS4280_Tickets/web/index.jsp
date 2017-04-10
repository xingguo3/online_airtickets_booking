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
        function disableReturn(){
            var x = document.getElementsByName("returnDate");
            x.setAttribute("type", "hidden");
            var c = document.getElementsByName("rdCalendar");
            c.setAttribute("type", "hidden");
    }

    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Welcome to Air Web</h1><BR>
        <input type="button" value="single trip">
        
        <FORM id="single" ACTION="SearchFlightHandler" METHOD="POST">
            Departure from: <INPUT TYPE="TEXT" NAME="departure"><BR>
            Destination: <INPUT TYPE="TEXT" NAME="destination"><BR>
            Depart Date : 
            <INPUT TYPE="TEXT"class="date" NAME="startDate1" SIZE=8><BR>
            <input type=button value="Select Date" onclick="displayDatePicker('startDate1', this);">
    
            <P>
                <INPUT TYPE="SUBMIT" NAME="flights" VALUE="Search">
            </p>
        </FORM>
        <FORM id="round" ACTION="SearchFlightHandler" METHOD="POST">
            Departure from: <INPUT TYPE="TEXT" NAME="departure"><BR>
            Destination: <INPUT TYPE="TEXT" NAME="destination"><BR>
            Departure Date: 
            <INPUT TYPE="TEXT" class="date" NAME="startDate" SIZE=8>
            <input type=button value="Select Date" onclick="displayDatePicker('startDate', this);"><BR>
            Return Date : 
            <INPUT TYPE="TEXT" class="date" NAME="returnDate" SIZE=8>
            <input type=button name="rdCalendar" value="Select Date" onclick="displayDatePicker('returnDate', this);"><BR>
            <P>
                <INPUT TYPE="SUBMIT" NAME="flights" VALUE="Search">
            </p>
        </FORM>

        <p><a href="./login.jsp">login</a><p/>
        <p>No Account? <a href="./RegistHandler">Register</a></p>
    </body>

</html>
