<%-- 
    Document   : welcome
    Created on : Apr 10, 2017, 2:41:47 PM
    Author     : GUOXING
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to CityExpress</title>
    </head>
    <body>
        <jsp:useBean id="user" class="beans.UserBean" scope="application" />
        <h1>Hello, <%= user.getFirstName()%> <%= user.getLastName()%></h1>
        <jsp:getProperty name="user" property="firstName" />
        <p><jsp:getProperty name="user" property="firstName" /></p>
    </body>
</html>
