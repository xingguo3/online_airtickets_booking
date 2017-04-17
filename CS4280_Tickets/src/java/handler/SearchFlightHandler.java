/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import Lookup.searchFlight;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import beans.FlightBean;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author GUOXING
 */
public class SearchFlightHandler extends HttpServlet {

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
 
        String from, to, deptDate, returnDate;
        from = request.getParameter("departure");
        to = request.getParameter("destination");
        deptDate = request.getParameter("startDate");
        returnDate = request.getParameter("returnDate");
        ArrayList deptFlight = new ArrayList<FlightBean>();
        ArrayList returnFlight = new ArrayList<FlightBean>();
        deptFlight = searchFlight.searchSingleFlight(from, to, deptDate);
        request.setAttribute("deptFlight", deptFlight);
        if (!returnDate.equals("") && returnDate != null) {
                returnFlight = searchFlight.searchSingleFlight(to, from, returnDate);
                request.setAttribute("returnFlight",returnFlight);
        }
        String role=null;
        HttpSession httpSession = request.getSession(false);
        role = (String) httpSession.getAttribute("role");
        if(role ==null||httpSession ==null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchResult.jsp");
            dispatcher.forward(request, response);
        }
        if (httpSession != null&&role=="customer") {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchResult.jsp");
            dispatcher.forward(request, response);
        }
        if (httpSession != null&&role=="manager") {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mgrSearchResult.jsp");
                dispatcher.forward(request, response);
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