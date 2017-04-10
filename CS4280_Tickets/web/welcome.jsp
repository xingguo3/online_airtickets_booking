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
        <jsp:useBean id="userbean" class="beans.UserBean" scope="session" />
        <h1>Hello, <%= userbean.getFirstName()%> <%= userbean.getLastName()%></h1>
        <jsp:getProperty name="userbean" property="firstName" />
       
    </body>
</html>
