/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import Lookup.Login;
import beans.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GUOXING
 */
public class LoginHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        try {
            response.setContentType("text/html;charset=UTF-8");
            String username="", password="";
            username = request.getParameter("username");
            password = request.getParameter("password");
            //Login lg = new Login(username, password);
            if(username!=null&&password!=null){
                //create a bean and then store the bean into a session
                UserBean ub = new UserBean();
//                ub.setBonus(lg.getBonus());
//                ub.setEmail(lg.getEmail());
                ub.setFirstName("first");
                ub.setLastName("last");
                ub.setId("user");
//                HttpSession httpSession = request.getSession();
//                httpSession.setAttribute("online", ub); 
                response.sendRedirect("./welcome.jsp");
                
            }else{
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Login Failed</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>wrong username or password, please try again</h1>");
                    out.println("<a href = \"login.jsp\">Click here to login again</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

//}
