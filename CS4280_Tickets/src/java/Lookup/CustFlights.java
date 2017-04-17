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
        PreparedStatement prst=null;
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
            int status=getFlightStatus(fid,con);
            int price=getFlightPrice(fid,con);
            int id=getHisColNo(con);
            String sql="Insert into dbo.history values(?,?,?,?,?,2,?,?,GETDATE())";
            prst=con.prepareStatement(sql);
            prst.setInt(1, id);
            prst.setInt(2, fid);
            prst.setInt(3, uid);
            prst.setString(4, lname);
            prst.setString(5, fname);
            prst.setInt(6, status);
            prst.setInt(7, price);
            prst.execute();
            updateSeatNo(fid,con);
            con.commit();
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustFlights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustFlights.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(CustFlights.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
           
    }
    
    public static void updateSeatNo(int fid,Connection con) throws SQLException{
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql="update dbo.flight set remainseat=(select remainseat from dbo.flight where fid= "+fid+" )-1 where fid="+fid;
        stmt.execute(sql);
    }
    public static int getFlightStatus(int fid, Connection con) throws SQLException{
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql="select status from dbo.flight where fid="+fid;
        ResultSet rs=stmt.executeQuery(sql);
        int status=1;
        while(rs.next())
            status=rs.getInt(1);
        return status;
        
    }
    
    public static int getFlightPrice(int fid, Connection con) throws SQLException{
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql="select price from dbo.flight where fid="+fid;
        ResultSet rs=stmt.executeQuery(sql);
        int price=1;
        while(rs.next())
            price=rs.getInt(1);
        return price;
        
    }
    
    public static int getHisColNo(Connection con) throws SQLException{
        Statement stmt=con.createStatement();
        String sql="select count(*) FROM dbo.history";
        ResultSet rs=stmt.executeQuery(sql);
        int n=1;
        while(rs.next())
            n=rs.getInt(1);
        return n+1;
    }
}
