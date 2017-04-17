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
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import beans.FlightBean;
/**
 *
 * @author GUOXING
 */
public class CustFlights {
    public static boolean bookFlight(int fid,int uid,String fname,String lname){
        Connection con=null;
        Statement stmt=null;
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
            
            String sql="Insert into history values((count(*) FROM dbo.history)+1, "+fid+", "+uid+", "+lname+", "+fname+
                    ", CURRENT_TIMESTAMP, 2,)";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustFlights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustFlights.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
           
    }
    
    public void updateSeatNo(int fid,Connection con) throws SQLException{
        Statement stmt=con.createStatement();
        String sql="update dbo.flight set remainseat=(select remainseat from dbo.flight where fid= "+fid+" )-1 where fid="+fid;
        stmt.execute(sql);
    }
    public int getFlightStatus(int fid, Connection con) throws SQLException{
        Statement stmt=con.createStatement();
        String sql="select status from dbo.flight where fid="+fid;
        ResultSet rs=stmt.executeQuery(sql);
        int status=1;
        while(rs.next())
            status=rs.getInt("status");
        return status;
        
    }
    
    
}
