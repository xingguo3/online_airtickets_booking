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

import Lookup.Registration;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Cookie;

/**
 *
 * @author GUOXING
 */
public class RegistHandler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException, ClassNotFoundException {
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            StringBuffer html = new StringBuffer("");
            html.append("<html><head>");
            html.append("<title>Travel By Air</title>");
            html.append("</head>");
            html.append("<body>");
            html.append("<h1>Registration</h1>");
            html.append("<form action='./RegistHandler' method='POST' style='width:600px;'>");
            // + request.getRequestURI() +
            html.append("<fieldset>");
            String pageNum = request.getParameter("page");
            String error = "Error.";
            String username="",email="",password="",firstname="", lastname="",gender="";
      
            username = request.getParameter("username");
            email = request.getParameter("email");
            gender = request.getParameter("gender");
            firstname = request.getParameter("firstname");
            lastname = request.getParameter("lastname");
            password = request.getParameter("password");
//               
            if (pageNum != null && pageNum.equals("2")
            && request.getParameter("username").equals("")&& request.getParameter("email").equals("")&& request.getParameter("password").equals("")
            ) {
                // display error message and Page 1 instead of Page 2
                html.append("<p style='color: red'>" + error + "</p>");
                pageNum = "1";
            }
            else if (pageNum != null && pageNum.equals("2") ){

                Registration reg;
                reg = new Registration(username, gender, password, email, firstname, lastname);
                if(reg.isExist()){
                    html.append("<p><b>Username already exists.</b></p><br />");
                }
                else{
                    reg.insert();
                    html.append("<legend>Successful</legend>");
                    html.append("<p><b>Thank you for your registration.</b></p><br />");
                    html.append("<legend>Successful</legend>");
                    html.append("<p><b>Thank you for your registration.</b></p><br />");
                    html.append("<p>Summary:</p>");
                    html.append("<p>Name</br><LI>"+ lastname + ' ' + firstname+" </p>");
                    html.append("<p>Gender</br><LI>"+gender+" </p>");
                    html.append("<p>User Name</br><LI>"+ username+" </p>");
                    html.append("<p>Password</br><LI>"+password+" </p>");
                    html.append("<p>Email</br><LI>"+email+" </p>");
                    
                    
                }
                
            }
            else {
                // Page 1 Layout)
                html.append("<legend>Please fill in the form below</legend>");
                html.append("<input type='hidden' name='page' value='2' />");
                html.append("<p>user name *<br/><input type='text' name='username' style='width:100%;' value='' /></p>");
                html.append("<p>Gender: <select name='gender'>\n" +
                            "  <option value=\"male\">Male</option>\n" +
                            "  <option value=\"female\">Female</option>\n" +
                            "  <option value=\"other\">Other</option>\n" +
                            "</select>" +
                            "</p>");
                html.append("<p>Password *<br/><input type='text' name='password' style='width:100%;' value='' /></p>");
                html.append("<p>First Name *<br/><input type='text' name='firstname' style='width:100%;' value='' /></p>");
                html.append("<p>Last Name *<br/><input type='text' name='lastname' style='width:100%;' value='' /></p>");
                html.append("<p>Email *<br/><input type='text' name='email' style='width:100%;' value='' /></p>");
                html.append("<p><input type='submit' value='Continue' /></p>");
                
            }
            //onclick='javascript: return SubmitForm()'
            html.append("</fieldset>");
            html.append("</form>");
            html.append("</body><footer>This web site exists to fulfill the coursework requirement of CS4280.<br/>Do not use your real personal data as input.");
            html.append("</html>");
                        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegistHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
