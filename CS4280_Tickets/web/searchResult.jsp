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
    <% ArrayList<FlightBean> deptList = (ArrayList<FlightBean>) request.getAttribute("deptFlight");
        ArrayList<FlightBean> rtList = (ArrayList<FlightBean>) request.getAttribute("returnFlight");
    %>

    <body>
        <h1>Search Result:</h1>
        <table>

            <% if (deptList.size() == 0){ %>
            <tr>No Flight Found</tr>

            <% }else if (deptList.size() != 0) { %>
            <tr>
                <td>Flight No</td>
                <td>Company</td>
                <td>From</td>
                <td>To</td>
                <td>Departure Time</td>
                <td>Arrive Time</td>
                <td>Price</td>
                <td></td>
            </tr>
            <% for (FlightBean dept : deptList) {%>
                    </tr><td> <%=dept.getFlightNo() %></td>
                    <td><%=dept.getCompany() %></td>
                    <td><%= dept.getFrom() %></td>
                    <td><%=dept.getTo() %></td>
                    <td><%= dept.getDeptTime() %></td>
                    <td><%= dept.getArrivTime() %></td>
                    <td><%= dept.getPrice() %>HKD</td>
                    <td> <a href="<%=request.getContextPath()%>/FlightBookHandler?fid=<%=dept.getFID()%>&trip=go">Book</a></td></tr>
              <%  }
             } %>

            
        </table>
        <table>

            <% if (rtList!=null&&rtList.size() == 0){ %>
            <tr>No Flight Found</tr>

            <% }else if (rtList!=null&&rtList.size() != 0) { %>
            <tr>
                <td>Flight No</td>
                <td>From</td>
                <td>To</td>
                <td>Departure Time</td>
                <td>Arrive Time</td>
                <td>Price</td>
                <td></td>
            </tr>
            <% for (FlightBean rt : rtList) {%>
                     </tr><td> <%=rt.getFlightNo() %></td>
                    <td><%= rt.getFrom() %></td>
                    <td><%=rt.getTo() %></td>
                    <td><%= rt.getDeptTime() %></td>
                    <td><%= rt.getArrivTime() %></td>
                    <td><%= rt.getPrice() %>HKD</td>
                    <td> <a href="<%=request.getContextPath()%>/FlightBookHandler?fid=<%=rt.getFID()%>&trip=back">Book</a></td></tr>
            <%  }
            
             } %>

            
        </table>
            </br>
        
    </body>
</html>
