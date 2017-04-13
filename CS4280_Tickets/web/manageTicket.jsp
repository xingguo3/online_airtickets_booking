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
        <FORM action='./' method ='POST'>
            <LEGEND>Search Tickets</legend>
            <input type='hidden' name='role' value='manager' />
            <input name='from' type='text' value=''/>
            <input name = 'to' type='text' value = ''/>
            <input name = 'date'type='date'/>
            <input type='submit' value='Submit'/>
        </FORM>
        <a href=''>add new flights</a>
    </body>
</html>
