    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import Lookup.Discount;
import Lookup.SearchFlight;
import beans.FlightBean;
import beans.UserBean;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class FlightBookHandler extends HttpServlet {

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
        int fid = Integer.parseInt(request.getParameter("fid"));
        String round = request.getParameter("trip");
        FlightBean f;
        f = SearchFlight.searchByFid(fid);
        request.setAttribute("book", f);
        request.setAttribute("fid", f.getFID());
        request.setAttribute("round", round);
        request.setAttribute("action", "book");
        String role = null;
        HttpSession httpSession = request.getSession(false);
        if(httpSession==null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("./login.jsp");
            dispatcher.forward(request, response);
        }
        else{
            role = (String) httpSession.getAttribute("role");
        
        if(role ==null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
        else if(role=="passenger"){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
        else if (httpSession != null&&role=="customer") {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookTicket.jsp");
            UserBean u=(UserBean)request.getSession().getAttribute("userbean");
            f.setPrice(Discount.giveDiscountByMem(f.getPrice(), u.getMembership()));
            dispatcher.forward(request, response);
        }
        else if (httpSession != null&&role=="manager") {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookTicket.jsp");
            dispatcher.forward(request, response);
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
