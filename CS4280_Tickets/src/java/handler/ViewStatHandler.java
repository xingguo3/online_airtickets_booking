/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import Lookup.CustFlights;
import beans.BookedTicketBean;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class ViewStatHandler extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (request.getSession(false)!=null) {
            if (action != null) {
                // call different action depends on the action parameter
                if (action.equalsIgnoreCase("sale")) {
                    this.doSearchSale(request, response);
                }
                else if(action.equalsIgnoreCase("refund")){
                    this.doSearchRefund(request, response);
                }else if(action.equalsIgnoreCase("placesale")){
                    this.doSearchPlace(request, response);
                }
            }
        
        }else {
             try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Time out, please login again</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h3>Time out, please login again</h3>"); 
                out.println("<p><a href='./login.jsp'>Click here to log in again</a></p>");
                out.println("</body>");
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

 
    private void doSearchRefund(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        ArrayList<BookedTicketBean> b=CustFlights.findHistoryByStatus(10);
        request.setAttribute("searchRefund", b);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/refundResult.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(ViewStatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doSearchSale(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String period = request.getParameter("period");
        
        if(period!=null){
            ArrayList<BookedTicketBean> b=CustFlights.findHistoryByDate(Integer.parseInt(request.getParameter("period")));
            request.setAttribute("historyStat", b);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/statResult.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(ViewStatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    private void doSearchPlace(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
       
            ArrayList<BookedTicketBean> b=CustFlights.findHistoryByPlace(from, to);
            request.setAttribute("historyPlaceStat", b);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/statPlaceResult.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(ViewStatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
  

}
