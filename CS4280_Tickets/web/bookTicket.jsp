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
        int price=f.getPrice();
    %>
    <body>
        <h1>Book Tickets for Your <%=request.getAttribute("round")%> Trip</h1>
        <form action="ConfirmBookHandler" method="post" id="form">
        <p>Flight No: <%= f.getFlightNo()%></p>
        <p>Departure Time: <%= f.getDeptTime()%></p>
        <p>Arrive Time: <%=f.getArrivTime()%></p>
        <input type="hidden" name="fid" value="<%f.getFID();%>">
        <p>Last Name:<input type="text" name="lastname" ></p>
        <p>First Name:<input type="text" name="firstname"></p>
<!--        <button onclick="addPassenger()" type="button" value="Add One More Passenger">Add One More Passenger</button>   -->
<!--        <div id="second"></div> -->
        <p>Price: <%=f.getPrice()%> HKD</p>
        <button onclick="return validate();" type='submit' value="confirm">Confirm</button>
        </form>
    </body>
    <script type="text/javascript">
        function conf(){
            if(confirm("Are you sure to book?")){
                   return true;
            }
            return false;    
        }
        function validate(){
            if(document.forms["form"].lastname.value==""||document.forms["form"].firstname.value==""){
                    alert("You must input all fields");
                     return false;  
                   }
                   
             return conf();
        }
        </script>
</html>
