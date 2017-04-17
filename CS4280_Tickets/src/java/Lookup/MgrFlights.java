/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lookup;

import beans.FlightBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author GUOXING
 */
public class MgrFlights {
    
    public static void DeleteFlights(FlightBean f) throws ClassNotFoundException, SQLException{
        f =searchFlight.searchByFid(f.getFID());
        Connection con = null;
        Statement stmt = null;
        try{

           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");

           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//           String cancelTick=null;
//           cancelTick = "SELECT UID , ActualPrice FROM dbo.history WHERE fid = '"+f.getFID()+"'";
//           ResultSet rs = stmt.executeQuery(cancelTick);
//           while(rs.next()){
//               int UID = rs.getInt("UID");
//               int price = rs.getInt("ActualPrice");
//               String refund = "UPDATE dbo.usersList SET Account = '"+price+"' WHERE UserID = '"+UID+"'";
//               stmt.executeQuery(refund);
//           }
           String strQl = null;
           strQl = "DELETE FROM dbo.Flight WHERE FID = '"+f.getFID()+"'";
           stmt.execute(strQl);
           
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
    
    public static void AddFlights(String value) throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        Statement stmt = null;
        try{

           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");

           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
           String strQl = null;
           strQl = "INSERT INTO dbo.Flight VALUES("+value+")";
           stmt.execute(strQl);
           
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
