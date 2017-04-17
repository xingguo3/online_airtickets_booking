<%-- 
    Document   : login
    Created on : Mar 20, 2017, 8:31:27 PM
    Author     : jzhang387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <FORM method='POST' action="./LoginHandler" style='width:600px;'>
            <p>username *<br/><input type='text' name='username' style='width:40%;' value='' /></p>
            <p>password *<br/><input type='text' name='password' style='width:40%;' value='' /></p>
            <input type="hidden" name="action" value="<%request.getAttribute("action").toString();%>">
            <input type="hidden" name="fid" value="<%request.getAttribute("fid").toString();%>">
            <input type="hidden" name="trip" value="<%request.getAttribute("round").toString();%>"
            <p><input type='submit' value='Login' /></p>
        </FORM>
    </body>
</html>
