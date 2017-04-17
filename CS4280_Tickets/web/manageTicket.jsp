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
        <title>Manage Tickets</title>
    </head>

    <body>
        <FORM action='./SearchFlightHandler' method ='POST'>
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
    </body>
</html>
