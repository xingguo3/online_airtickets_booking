package cs4280;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class RegCookieServlet extends HttpServlet {
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            StringBuffer html = new StringBuffer("");
            html.append("<html><head>");
            html.append("<title>City Company - Membership System</title>");
            html.append("</head>");
            html.append("<body>");
            html.append("<h1>Registration</h1>");
            html.append("<form action='" + request.getRequestURI() + "' method='POST' style='width:600px;'>");
            html.append("<fieldset>");
            String pageNum = request.getParameter("page");
            String error = "Error.";
            if (pageNum != null && pageNum.equals("2")
            && request.getParameter("name").equals("")&& request.getParameter("email").equals("")&& request.getParameter("password").equals("")
            ) {
                // display error message and Page 1 instead of Page 2
                html.append("<p style='color: red'>" + error + "</p>");
                pageNum = "1";
            }
            if (pageNum != null && pageNum.equals("2")) {
                // save Page 1 info into cookies
                // response.addCookie ( ... )
                 response.addCookie( new Cookie("name",request.getParameter("name")));  
                 response.addCookie( new Cookie("email",request.getParameter("email")));
                 response.addCookie( new Cookie("password",request.getParameter("password")));
                // Page 2 Layout
                html.append("<legend>Please fill in the form below</legend>");
                html.append("<input type='hidden' name='page' value='3' />");
                html.append("<p>Education Level<br/><select name='level' style='width:100%;'>");
                html.append("<option>Secondary School</option>");
                html.append("<option>College</option>");
                html.append("<option>Undergraduate</option>");
                html.append("<option>Postgraduate</option>");
                html.append("<option>Other</option>");
                html.append("</select></p>");
                html.append("<p>Year of Birth (YYYY)<br/><input type='text' name='yob' style='width:100%;' /></p>");
                html.append("<p>Self Description<br/><textarea name='desc' rows='5' style='width:100%;'></textarea></p>");
                html.append("<p><input type='submit' value='Continue' /></p>");
   
            }
            else if (pageNum != null && pageNum.equals("3")) {
                // save page 2 info into cookies
                response.addCookie( new Cookie("level",request.getParameter("level"))); 
                 response.addCookie( new Cookie("yob",request.getParameter("yob")));
                 response.addCookie( new Cookie("desc",request.getParameter("desc")));
                String name="",email="",password="",level="",yob="",desc="";
                Cookie[] cookies = request.getCookies();
                for (int i = 0;  i <cookies.length; i++) {
                    if (cookies[i].getName().equals("name")) 
                        name=cookies[i].getValue();
                    if (cookies[i].getName().equals("email")) 
                        email=cookies[i].getValue();
                    if (cookies[i].getName().equals("password")) 
                        password=cookies[i].getValue();
                    if (cookies[i].getName().equals("level")) 
                        level=cookies[i].getValue();
                    if (cookies[i].getName().equals("yob")) 
                        yob=cookies[i].getValue();
                    if (cookies[i].getName().equals("desc")) 
                        desc=cookies[i].getValue();
                }
                        
                // Page 3 Layout - Summary
                // display the form information by obtaining the values from cookies
                html.append("<legend>Completed</legend>");
                html.append("<p><b>Thank you for your registration.</b></p><br />");
                html.append("<p>Name</br><LI>"+name+" </p>");
                html.append("<p>Email</br><LI>"+email+" </p>");
                html.append("<p>Password</br><LI>"+password+" </p>");
                html.append("<p>Education Level</br><LI>"+level+" </p>");
                html.append("<p>Year of Birth</br><LI>"+yob+" </p>");
                html.append("<p>Self Description</br><LI>"+desc+" </p>");
              
            }
            else {
                // Page 1 Layout)
                html.append("<legend>Please fill in the form below</legend>");
                html.append("<input type='hidden' name='page' value='2' />");
                html.append("<p>Name *<br/><input type='text' name='name' style='width:100%;' value='' /></p>");
                html.append("<p>Email *<br/><input type='text' name='email' style='width:100%;' value='' /></p>");
                html.append("<p>Password *<br/><input type='text' name='password' style='width:100%;' value='' /></p>");
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

