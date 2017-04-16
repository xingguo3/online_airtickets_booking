<%-- 
    Document   : bookTicket
    Created on : Mar 20, 2017, 8:41:58 PM
    Author     : jzhang387
--%>

<%@page import="beans.UserBean"%>
<%@page import="beans.FlightBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <% FlightBean f=(FlightBean)request.getAttribute("book");
        UserBean user=(UserBean)request.getSession().getAttribute("userbean");
    %>
    <body>
        <h1>Book Tickets for Your <%=request.getAttribute("round")%> Trip</h1>
        <form action="ManageBookingHandler" method="post" id="form">
        <p>Flight No: <%= f.getFlightNo()%></p>
        <p>Departure Time: <%= f.getDeptTime()%></p>
        <p>Arrive Time: <%=f.getArrivTime()%></p>
        <input type="hidden" name="fid" value="<%f.getFID();%>">
        <input type="text" name="lastname1" value="<% user.getLastName();%>">
        <input type="text" name="lastname1" value="<% user.getFirstName();%>">
        <button onclick="addPassenger()" value="Add One More Passenger">
        <div id="second"></div>
        <p>Price: <section id="price"></section> HKD</p>
        </form>
    </body>
    <script type="text/javascript">
        var pNo=1;
        var price=<% f.getPrice();%>;
        function addPasenger(){
            pNo=pNo+1;
            document.getElementById("second").innerHTML=" <input type="hidden" name="fid" value="<%f.getFID();%>">
            <input type="text" name="lastname"+pNo value="<% user.getLastName();%>">
            <input type="text" name="lastname"+pNo value="<% user.getFirstName();%>">";
            document.getElementById("second").innerHTML=pNo*price;
        }
        </script>
</html>
