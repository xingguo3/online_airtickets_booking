<%-- 
    Document   : managerAddTick
    Created on : Apr 17, 2017, 3:40:53 PM
    Author     : GUOXING
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Tickets</title>
    </head>
    <body>
        <h1>Fill in below form</h1>
        <form action="/ManagerFlightHandler" method='POST'>
            <input type='hidden' name='action' value='addnew'/>
            <p>From: <input type='text' name='from'/></p>
            <p>to: <input type='text' name='to'/></p>
            <p>Date: <input type='date' name='date'/></p>
            <p>Take off: <input type='datetime' name='takeoff'/></p>
            <p>Land: <input type='datetime' name='land'/></p>
            <p>Price: <input type='text' name='price'/></p>
            <p>Total Seats: <input type='text' name='seats'/></p>
        </form>
    </body>
</html>
