<%-- 
    Document   : manageTicket
    Created on : Mar 20, 2017, 8:46:52 PM
    Author     : jzhang387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <input name = 'startDate' type='date'/>
            <input type='submit' value='Submit'/>
        </FORM>
        <a href=''>add new flights</a>
    </body>
</html>
