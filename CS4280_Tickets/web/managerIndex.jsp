<%-- 
    Document   : managerIndex
    Created on : Mar 20, 2017, 8:54:42 PM
    Author     : jzhang387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Manager Index</title>
    </head>
    <body>
        <section class="hero">
            <header>
                <div class="wrapper">
                    <a href="./index.jsp"><img src="img/logo.png" class="logo" alt="" titl=""/></a>

                    <nav>
                        <ul>
                            <li><a href="./ManageRefundHandler?action=search">manage booking (refund)</a></li>
                            <li><a href='./manageTicket.jsp'>manage tickets information</a></li>
                            <li><a href='./viewStat.jsp'>view statistics</a></li>
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

    </body>
    <footer>This web site exists to fulfill the coursework requirement of CS4280.<br/>Do not use your real personal data as input.
</html>
