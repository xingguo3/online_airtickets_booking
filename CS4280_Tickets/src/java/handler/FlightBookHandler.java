/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import beans.FlightBean;
import java.io.IOException;
import java.io.PrintWriter;
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
                int fid=Integer.parseInt(request.getParameter("fid"));
                //String round=request.getParameter("trip");
//                FlightBean f;
//                if(round.equals("go")){
//                    ArrayList<FlightBean> deptList = (ArrayList<FlightBean>) request.getAttribute("deptFlight");
//                    for(FlightBean dept:deptList){
//                        if(dept.getFID()==fid)
//                            f=dept;
//                    }
//                }
//                if(round.equals("back")){
//                     ArrayList<FlightBean> rtList = (ArrayList<FlightBean>) request.getAttribute("returnFlight");
//                     for(FlightBean rt:rtList){
//                        if(rt.getFID()==fid)
//                            f=rt;
//                    }
//                }
                String role=null;
                role = request.getParameter("role");
        if(role==null||role.equals("passager")){
            HttpSession httpSession = request.getSession(false);
            if(httpSession == null){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }
            
        }
        else if(role.equals("manager")){
            HttpSession httpSession = request.getSession(false);
            if(httpSession != null){
            
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookTicket.jsp");
                dispatcher.forward(request, response);
            
            }
        }
        else{
            HttpSession httpSession = request.getSession(false);
            if(httpSession != null){
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookTicket.jsp");
                dispatcher.forward(request, response);
            }
        }
                
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FlightBookHandler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FlightBookHandler at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
