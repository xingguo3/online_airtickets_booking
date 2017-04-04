/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



// todo
//INSERT INTO dbo.usersList
//VALUES (6, 'chingming', 'ching','M', 'notok', 'ching', 'ming', '0', '0', 0, '0', '0')
package Lookup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GUOXING
 */
public class addNewUsers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
    */
    private static int CustomerID=100;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String username = (String)request.getAttribute("username");
        //String gender = (String)request.getAttribute("gender");
        String password = (String)request.getAttribute("password");
        String email = (String)request.getAttribute("email  ");
        String firstname = (String)request.getAttribute("firstname");
        String lastname = (String)request.getAttribute("lastname");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String strQL = "INSERT INTO dbo.usersList VALUES ("+ this.getCustomerID()+ ','+username+','+ 'M'+','+password+','+email+','+firstname+','+lastname+','+  "'0', '0', 0, '0', '0')";
        String strQl = "INSERT INTO dbo.usersList VALUES ("+ this.getCustomerID()+ ", 'chingming', 'ching','M', 'notok', 'ching', 'ming', '0', '0', 0, '0', '0')";
        Connection con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(strQl);
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
        
    }
    
    public void setCustomerID(){
        this.CustomerID = 6;
    }
    public int getCustomerID(){
        CustomerID++;
        return this.CustomerID;
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addNewUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addNewUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addNewUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addNewUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
   
