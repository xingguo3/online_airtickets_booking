<%-- 
    Document   : viewStat
    Created on : Mar 20, 2017, 8:54:19 PM
    Author     : jzhang387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistic</title>
    </head>
    <body>
        <p>view sold tickets information</p>
        <form action='./ViewStatHandler' method='POST'>
            <select name='period'>
                <option value='week'>Past 7 days</option>
                <option value='month'>Past 30 days Month</option>
            </select>
            
        </form>
        <p></p>
    </body>
</html>
