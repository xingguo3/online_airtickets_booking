<%-- 
    Document   : searchResult
    Created on : Mar 20, 2017, 8:33:17 PM
    Author     : jzhang387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.awt.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="beans.FlightBean" %>

<!DOCTYPE html>
 <jsp:useBean id="flight" scope="session" class="beans.FlightBean" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% ArrayList deptList=(ArrayList)request.getAttribute("deptFlight");
        ArrayList returnList=(ArrayList)request.getAttribute("deptFlight");
        %>
   
    <body>
        <h1>Search Result:</h1>
        <table>
            <tr>
                <td>Flight No</td>
                <td>From</td>
                <td>To</td>
                <td>Departure Time</td>
                <td>Arrive Time</td>
                <td>Price</td>
                <td></td>
            </tr>
            <% if(deptList.size()==0) %>
                <tr>No Flight Found</tr>
            
            <% if(deptList.size()!=0){ %>
                <c:forEach items="${deptList}" var="dept">
                    <tr>
                    
                    <td>  ${dept.flightNo}</td>
                    <td>  ${dept.from}</td>
                    <td>  ${dept.to}</td>
                    <td>  ${dept.deptTime}</td>
                    <td>  ${dept.arrivTime}</td>
                    <td>  ${dept.price} HKD</td>
                    <td>  <a href="bookTicket.jsp">Book</a></td>
                </tr>  
                </c:foreach>
            <% } %>
            </c:if>
            <% if(deptList.size()==0) %>
                <tr>No Return Flight Found</tr>
            
            <% if(returnList.size()!=0) {%>
             <c:forEach items="${returnList}" var="return">
                <tr>
                    <td>  ${return.flightNo}</td>
                    <td>  ${return.from}</td>
                    <td>  ${return.to}</td>
                    <td>  ${return.deptTime}</td>
                    <td>  ${return.arrivTime}</td>
                    <td>  ${return.price} HKD</td>
                    <td>  <a href="bookTicket.jsp">Book</a>    </td>
                </tr>  
            </c:forEach>
            <% } %>
        </table>
    </body>
</html>
