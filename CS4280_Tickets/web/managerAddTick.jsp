<%-- 
    Document   : managerAddTick
    Created on : Apr 17, 2017, 3:40:53 PM
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
        <title>Add Tickets</title>
    </head>
    <body>
        <h1>Fill in below form</h1>
        <form action="./ManagerFlightHandler" method='POST'>
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
    </body>
    <footer>This web site exists to fulfill the coursework requirement of CS4280.<br/>Do not use your real personal data as input.
</html>
