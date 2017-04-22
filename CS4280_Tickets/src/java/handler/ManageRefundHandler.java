/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import Lookup.CustFlights;
import Lookup.MgrRefund;
import beans.BookedTicketBean;
import beans.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GUOXING
 */
public class ManageRefundHandler extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        String action = request.getParameter("action");
        if (request.getSession(false)!=null) {
            if (action != null) {
                // call different action depends on the action parameter
                if (action.equalsIgnoreCase("search")) {
                    this.doSearchProcess(request, response);
                }else if(action.equalsIgnoreCase("approve")){
                    this.doApproveProcess(request, response);
                }else if(action.equalsIgnoreCase("refuse")){
                    this.doRefuseProcess(request, response);
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

    private void doSearchProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        ArrayList<BookedTicketBean> blist=new ArrayList<>();
            blist=CustFlights.findHistoryByStatus(0);
            request.setAttribute("refund", blist);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mgrRefundlist.jsp");
                dispatcher.forward(request, response);
    }
    
    

    private void doApproveProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        String id = request.getParameter("id");
        MgrRefund.approve(id);
        PrintWriter out;
        out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<a href='"+request.getContextPath()+"/ManageRefundHandler?action=search>Done</a>");
        out.println("</body><footer>This web site exists to fulfill the coursework requirement of CS4280.<br/>Do not use your real personal data as input.");
        out.println("</html>");
    }

    private void doRefuseProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        String id = request.getParameter("id");
        MgrRefund.refuse(id);
        PrintWriter out;
        out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<a href='"+request.getContextPath()+"/ManageRefundHandler?action=search>Done</a>");
        out.println("</body><footer>This web site exists to fulfill the coursework requirement of CS4280.<br/>Do not use your real personal data as input.");
        out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageRefundHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageRefundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageRefundHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageRefundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
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