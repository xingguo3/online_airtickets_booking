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
            document.getElementById('return').style.visibility = "hidden"; 
            
        }
        function enableReturn(){
            document.getElementById('return').style.visibility = "visible"; 
            
         }
         function validate(){
             if(document.forms["form"].departure.value==""||document.forms["form"].destination.value==""){
            alert   ("You must input all fields");
             return false;  
         }
        
         return true;
               
         }

    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Welcome to Air Web</h1><BR>
        
        <FORM id="form" ACTION="SearchFlightHandler" METHOD="POST">
            <input type='hidden' name='role' value='passager' />
            <input type="radio" name="type" value="single" onclick="disableReturn()">single trip
            <input type="radio" name="type" value="round" onclick="enableReturn()">round trip<BR>
        
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
                <INPUT onclick="return validate();" TYPE="SUBMIT" NAME="flights" VALUE="Search">
            </p>
        </FORM>

        <p><a href="./login.jsp">login</a><p/>
        <p>No Account? <a href="./RegistHandler">Register</a></p>
    </body>
    <footer>This web site exists to fulfill the coursework requirement of CS4280.<br/>Do not use your real personal data as input.
</html>
