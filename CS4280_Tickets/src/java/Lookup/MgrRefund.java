/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lookup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author GUOXING
 */
public class MgrRefund {
    public static void approve(String id) throws ClassNotFoundException, SQLException{
        Connection con = null;
        Statement stmt = null;
        try{

           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
           
           String strQl = null;
           int ID=Integer.parseInt(id);
           strQl = "UPDATE dbo.history SET BookingStatus=? WHERE id= '"+ID+"'";
           PreparedStatement ps = con.prepareStatement(strQl);
           ps.setInt(1, 4);
           ps.execute();
           // add thic action into another database
           // action: add, fid:
        }finally{
            if (stmt!=null) {
                stmt.close();
            } 
           try{
              if(con!=null)
                 con.close();
           }catch(SQLException se){
              se.printStackTrace();
           }
        }
    }
    
    public static void refuse(String id) throws ClassNotFoundException, SQLException{
        Connection con = null;
        Statement stmt = null;
        try{

           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
           
           String strQl = null;
           int ID=Integer.parseInt(id);
           strQl = "UPDATE dbo.history SET BookingStatus=? WHERE id= '"+ID+"'";
           PreparedStatement ps = con.prepareStatement(strQl);
           ps.setInt(1, 3);
           ps.execute();
           // add thic action into another database
           // action: add, fid:
        }finally{
            if (stmt!=null) {
                stmt.close();
            } 
           try{
              if(con!=null)
                 con.close();
           }catch(SQLException se){
              se.printStackTrace();
           }
        }
    }
}
