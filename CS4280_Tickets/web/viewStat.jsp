<%-- 
    Document   : viewStat
    Created on : Mar 20, 2017, 8:54:19 PM
    Author     : xingguo3
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
            <input type='hidden' name='action' value='sale'>
            <select name='period'>
                <option value='7'>Past 7 days</option>
                <option value='30'>Past 30 days Month</option>
            </select>
            <input type='submit' value='Search'/>
            
        </form>
        
        <p>view all refund history</p>
        <form action='./ViewStatHandler' method='POST'>
            <input type='hidden' name='action' value='refund'>
            <select name='period'>
                <option value='week'>Past 7 days</option>
                <option value='month'>Past 30 days Month</option>
            </select>
            <input type='submit' value='Search'/>
            
        </form>
         
        <p></p>
    </body>
</html>
