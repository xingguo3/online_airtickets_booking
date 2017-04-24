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

        <meta charset="utf-8">


        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <title>Log In</title>
    </head>
    <body>
        <section class="hero">
            <header>
                <div class="wrapper">
                    <a href="./index.jsp"><img src="img/logo.png" class="logo" alt="" titl=""/></a>

                    <nav>
                        <ul>
                            <li><a href="#">Contact</a></li>
                        
                        <% if (request.getSession().getAttribute("userbean") == null) {%>
                        <li><a href="./RegistHandler">Register</a></li>
                        </ul>
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
                <FORM id="content" method='POST' action="./LoginHandler" style='width:600px;'>
                    <p>Username *<br/><input type='text' name='username' style='width:40%;' value='' /></p>
                    <p>Password *<br/><input type='password' name='password' style='width:40%;' value='' /></p>
                 <!--   <input type="hidden" name="action" value="<%=request.getAttribute("action")%>">
                    <input type="hidden" name="fid" value="<%=request.getAttribute("fid")%>">
                    <input type="hidden" name="round" value="<%=request.getAttribute("round")%>">   -->
                    <p><input type='submit' class="button" value='Login' /></p>
                    <p>No Account? <a href="./RegistHandler">Register</a></p>
                </FORM>

            </div>
        </section><!--  end search section  -->


    </body>
    <footer>

        <div class="copyrights wrapper">
            This web site exists to fulfill the coursework requirement of CS4280.
            <br/>Do not use your real personal data as input.
            <br/>Copyright © 2017 atrip.com. All Rights Reserved.
        </div>
    </footer><!--  end footer  -->
</html>
