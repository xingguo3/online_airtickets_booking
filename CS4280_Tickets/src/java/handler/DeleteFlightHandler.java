/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import Lookup.MgrFlights;
import Lookup.searchFlight;
import beans.FlightBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class DeleteFlightHandler extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8"); 
        int fid = Integer.parseInt(request.getParameter("fid"));
        String round = request.getParameter("trip");
        String action = request.getParameter("action");
        FlightBean f;
        f = searchFlight.searchByFid(fid);
        if(action==null){
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet DeleteFlightHandler</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Sure to delete below tickets:</h1>");
                out.println("<p>Flight ID: "+(f.getFID())+"</p>");            
                out.println("<p>Flight No.: "+f.getFlightNo()+"</p>");
                out.println("<p>From: "+f.getFrom()+"</p>");
                out.println("<p>To: "+f.getTo()+"</p>");
                out.println("<button onclick='" + request.getRequestURI() + "?action=delete&FID=" + f.getFID() + "'>Delete</button>");
                out.println("<button onclick = 'window.history.back()'>Cancel</button>");

                out.println("</body>");
                out.println("</html>");
            }
        }else{
            if (action.equalsIgnoreCase("delete")) {
                this.deleteProcess(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteFlightHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteFlightHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteProcess(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8"); 
        int fid = Integer.parseInt(request.getParameter("fid"));
        FlightBean f;
        f = searchFlight.searchByFid(fid);
        MgrFlights.DeleteFlights(f);
        
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
            Logger.getLogger(DeleteFlightHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteFlightHandler.class.getName()).log(Level.SEVERE, null, ex);
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
