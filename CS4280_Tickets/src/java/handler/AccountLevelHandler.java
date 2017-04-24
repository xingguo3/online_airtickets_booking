/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import Lookup.CustFlights;
import beans.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class AccountLevelHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession(false)!=null){
            UserBean u=(UserBean)request.getSession().getAttribute("userbean");
            int membership=u.getMembership();
            Boolean b=CustFlights.updateMem(u.getId(), membership);
               if(b){
                   u.setMembership(membership+1);
                   request.getSession().setAttribute("userbean", u);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accountLevel.jsp");
                    dispatcher.forward(request, response);
                   
               }
               else{
                   try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Update failed!')");
            out.println("</script>");
            response.sendRedirect("/accountLevel.jsp");
            
        }
               }
                   
        }else{
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Time out, please login again</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h3>Time out, please login again</h3>"); 
                    out.println("<p><a href='./login.jsp'>Click here to log in again</a></p>");
                    out.println("</body><footer>This web site exists to fulfill the coursework requirement of CS4280.<br/>Do not use your real personal data as input.");
                    out.println("</html>");
                }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
