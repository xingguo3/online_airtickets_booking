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
public class ManagerFlightHandler extends HttpServlet {

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
        
        String action = request.getParameter("action");
        
        if (action != null) {
            // call different action depends on the action parameter
            if (action.equalsIgnoreCase("update")) {
                this.doUpdateProcess(request, response);
            }
            else if (action.equalsIgnoreCase("delete")) {
                this.doDeleteProcess(request, response);
            }
            else if (action.equalsIgnoreCase("addnew")) {
                this.doAddNewProcess(request, response);
            }else if(action.equalsIgnoreCase("dodelete")){
                this.doDeleteFromJDBC(request, response);
            }
        }
    }

    private void doDeleteProcess(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        int fid = Integer.parseInt(request.getParameter("fid"));
            String round = request.getParameter("trip");
            FlightBean f;
            f = searchFlight.searchByFid(fid);
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
                out.println("<p>"+request.getRequestURI()+"</p>");
                out.println("<a href='/CS4280_Tickets/ManagerFlightHandler?action=dodelete&FID=" + fid + "'>Delete</a>");
                out.println("<button onclick = 'window.history.back()'>Cancel</button>");

                out.println("</body>");
                out.println("</html>");
            } catch (IOException ex) {
            Logger.getLogger(ManagerFlightHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManagerFlightHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerFlightHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManagerFlightHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerFlightHandler.class.getName()).log(Level.SEVERE, null, ex);
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

    private void doUpdateProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doAddNewProcess(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        String fno = request.getParameter("fno");            
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String date = request.getParameter("date");
        String takeoff = request.getParameter("takeoff");
        String land = request.getParameter("land");
        String company = request.getParameter("company");
        String price = request.getParameter("price");
        String seats= request.getParameter("seats");
        String[] datearray = date.split("-");
        String fid = datearray[0]+datearray[1]+fno.substring(fno.length()-3,fno.length());
        String value="'"+ fid + "', '"+ fno + "', '"+ from + "', '"+ to + "', '"+ datearray[2]+"-"+datearray[0]+"-"+datearray[1] + "', '"+ takeoff + "', '"+ land + "', '"+ price + "', '"+ seats + "', '1', '"+ company + "', '"+ datearray[2] + "', '"+ datearray[0] + "', '"+ datearray[1] + "'";
        MgrFlights.AddFlights(value);
       PrintWriter out = response.getWriter();
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<body><p>Successful! </p>");
                out.println("<p><a href='./managerIndex.jsp'>Click here to continue.<a></p>");
        out.println("</body>");
        out.println("</html>");
    }

    private void doDeleteFromJDBC(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        int fid = Integer.parseInt(request.getParameter("FID"));
        String round = request.getParameter("trip");
        FlightBean f;
        f = searchFlight.searchByFid(fid);
        MgrFlights.DeleteFlights(f);
        String time = f.getDeptTime();
        String[] dateParts=time.split(" ");
        String ymd=(dateParts[0]);
        String tmp=(dateParts[1]);
        String[] time1 = ymd.split("-");
        String mdy = time1[1]+"-"+time1[2]+"-"+time1[0];
        PrintWriter out;
        out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
                
        out.println("<a href='"+request.getContextPath()+"/SearchFlightHandler?departure=HKG&destination=BKK&startDate=04-25-2017&returnDate='>Delete</a>");
        out.println("</body>");
                out.println("</html>");
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchFlightHandler?departure=HKG&destination=BKK&startDate=04-25-2017");
//        rd.forward(request, response);   
    }

}
