/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*      todo

1. gender information
2. pass all parameters into Lookup.addNewUser.java and then store into DB

*/
package handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 *
 * @author GUOXING
 */
public class SignUp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            StringBuffer html = new StringBuffer("");
            html.append("<html><head>");
            html.append("<title>Travel By Air</title>");
            html.append("</head>");
            html.append("<body>");
            html.append("<h1>Registration</h1>");
            html.append("<form action='" + request.getRequestURI() + "' method='POST' style='width:600px;'>");
            html.append("<fieldset>");
            String pageNum = request.getParameter("page");
            String error = "Error.";
            if (pageNum != null && pageNum.equals("2")
            && request.getParameter("username").equals("")&& request.getParameter("email").equals("")&& request.getParameter("password").equals("")
            ) {
                // display error message and Page 1 instead of Page 2
                html.append("<p style='color: red'>" + error + "</p>");
                pageNum = "1";
            }
            else if (pageNum != null && pageNum.equals("2")) {
                
                 response.addCookie( new Cookie("username",request.getParameter("username")));  
                 //response.addCookie( new Cookie("gender",request.getParameter("gender"))); 
                 response.addCookie( new Cookie("password",request.getParameter("password")));
                 response.addCookie( new Cookie("firstname",request.getParameter("firstname")));
                 response.addCookie( new Cookie("lastname",request.getParameter("lastname")));
                 response.addCookie( new Cookie("email",request.getParameter("email")));
                 
                String username="",email="",password="",firstname="", lastname="",gender="";
                Cookie[] cookies = request.getCookies();
                for (int i = 0;  i <cookies.length; i++) {
                    if (cookies[i].getName().equals("username")) 
                        username=cookies[i].getValue();
                    if (cookies[i].getName().equals("email")) 
                        email=cookies[i].getValue();
                    if (cookies[i].getName().equals("password")) 
                        password=cookies[i].getValue();
                    if (cookies[i].getName().equals("firstname")) 
                        firstname=cookies[i].getValue();
                    if (cookies[i].getName().equals("lastname")) 
                        lastname=cookies[i].getValue();
//                    if (cookies[i].getName().equals("gender")) 
//                        gender=cookies[i].getValue();
                }
//                request.setAttribute("username", username);
//                request.setAttribute("password", password);
//                request.setAttribute("email", email);
//                request.setAttribute("firstname", firstname);
//                request.setAttribute("lastname", lastname);
//                RequestDispatcher rd = request.getRequestDispatcher("../Lookup.addNewUsers.java");
//                rd.forward(request, response);
                response.sendRedirect("http://localhost:8080/CS4280_Tickets/addNewUsers");
                
                // Page 2 Layout - Summary
                // display the form information by obtaining the values from cookies
                html.append("<legend>Successful</legend>");
                html.append("<p><b>Thank you for your registration.</b></p><br />");
                html.append("<p>Summary:</p>");
                html.append("<p>Name</br><LI>"+ lastname+' '+firstname+" </p>");
                //html.append("<p>Gender</br><LI>"+gender+" </p>");
                html.append("<p>User Name</br><LI>"+ username+" </p>");
                html.append("<p>Password</br><LI>"+password+" </p>");
                html.append("<p>Email</br><LI>"+email+" </p>");
                html.append("<p>Click here to redirect to login page</p>");
                
            }
            else {
                // Page 1 Layout)
                html.append("<legend>Please fill in the form below</legend>");
                html.append("<input type='hidden' name='page' value='2' />");
                html.append("<p>user name *<br/><input type='text' name='username' style='width:100%;' value='' /></p>");
//                html.append("<p>gender *<br/>\n" +
//                            "  <input type=\"radio\" name=\"gender\" value=\"male\" checked> Male<br>\n" +
//                            "  <input type=\"radio\" name=\"gender\" value=\"female\"> Female<br>\n" +
//                            "  <input type=\"radio\" name=\"gender\" value=\"other\"> Other\n" +
//                            "</p>");
                html.append("<p>Password *<br/><input type='text' name='password' style='width:100%;' value='' /></p>");
                html.append("<p>First Name *<br/><input type='text' name='firstName' style='width:100%;' value='' /></p>");
                html.append("<p>Last Name *<br/><input type='text' name='lastName' style='width:100%;' value='' /></p>");
                html.append("<p>Email *<br/><input type='text' name='email' style='width:100%;' value='' /></p>");
                html.append("<p><input type='submit' value='Continue' /></p>");
            }
            html.append("</fieldset>");
            html.append("</form>");
            html.append("</body></html>");
                        
            out.print (html.toString());
        }
        catch (NullPointerException e) {
            // return a Bad Request (400) Error
            response.sendError(response.SC_BAD_REQUEST, e.getMessage());
        }
        finally {
        out.close();
        }
                
                
    }
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
        
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
