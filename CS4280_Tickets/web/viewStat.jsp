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
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Statistics</title>
    </head>
    <body>
        <section class="hero">
            <header>
                <div class="wrapper">
                    <a href="./index.jsp"><img src="img/logo.png" class="logo" alt="" titl=""/></a>

                    <nav>
                        <ul>
                            <li><a href="./ManageBookingHandler">History</a></li>
                            <li><a href="./accountLevel.jsp">My Account Level</a></li>
                            <li><a href="#">Contact</a></li>
                        </ul>
                        <% if (request.getSession().getAttribute("userbean") == null) {%>
                        <a href="./login.jsp" class="login_btn">Login</a>
                        <%} else {%>
                        <a href='./LogoutHandler' class="login_btn">Logout</a>
                        <%}%>
                    </nav>
                </div>
            </header><!--  end header section  -->

            <section class="caption">
                <h2 class="caption">Book Ticket For Your Trip</h2>
                <h3 class="properties">cheap-fast-convenient</h3>
            </section>
        </section><!--  end hero section  -->
        <section class="search">
            <div class="wrapper">
                <div id="ncontent">
        <p>view sold tickets information</p>
        <form action='./ViewStatHandler' method='POST'>
            <input type='hidden' name='action' value='sale'>
            <select name='period'>
                <option value='7'>Past 7 days</option>
                <option value='30'>Past 30 days Month</option>
            </select>
            <input type='submit' value='Search'/>
            
        </form>
        <form action='./ViewStatHandler' method='POST'>
            <input type='hidden' name='action' value='placesale'>

            <p>Departure: <input type="text" name='from' value='' /><p/>
            <p>Destination: <input type="text" name='to' value='' /><p/>

            <input type='submit' value='Search'/>
            
        </form>
        
        <p>view all refund history</p>
        <form action='./ViewStatHandler' method='POST'>
            <input type='hidden' name='action' value='refund'>
            <input type='submit' value='Search'/>
            
        </form>
         
       </div>

            </div>


        </section><!--  end search section  -->
    </body>
    <footer>

        <div class="copyrights wrapper">
            This web site exists to fulfill the coursework requirement of CS4280.
            <br/>Do not use your real personal data as input.
            <br/>Copyright © 2017 atrip.com. All Rights Reserved.
        </div>
    </footer><!--  end footer  --></html>
