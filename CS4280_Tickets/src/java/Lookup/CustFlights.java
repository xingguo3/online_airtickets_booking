/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lookup;
import beans.BookedTicketBean;
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
      //  Statement stmt=null;
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
            prst.close();
            con.close();
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
 //       stmt.close();
    }
    public static int getFlightStatus(int fid, Connection con) throws SQLException{
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql="select status from dbo.flight where fid="+fid;
        ResultSet rs=stmt.executeQuery(sql);
        int status=1;
        while(rs.next())
            status=rs.getInt(1);
        stmt.close();
        rs.close();
        return status;
        
    }
    
    public static int getFlightPrice(int fid, Connection con) throws SQLException{
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql="select price from dbo.flight where fid="+fid;
        ResultSet rs=stmt.executeQuery(sql);
        int price=1;
        while(rs.next())
            price=rs.getInt(1);
        stmt.close();
        rs.close();
        return price;
        
    }
    
    public static int getHisColNo(Connection con) throws SQLException{
        Statement stmt=con.createStatement();
        String sql="select count(*) FROM dbo.history";
        ResultSet rs=stmt.executeQuery(sql);
        int n=1;
        while(rs.next())
            n=rs.getInt(1);
        stmt.close();
        rs.close();
        return n+1;
    }
    
    public static ArrayList<BookedTicketBean> findHistoryByUid(int uid){
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<BookedTicketBean> blist=new ArrayList<>();
         try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
             String sql="select * from dbo.history where uid= "+uid;
             stmt=con.createStatement();
             rs=stmt.executeQuery(sql);
             while(rs.next()){
                 BookedTicketBean b=new BookedTicketBean();
                 b.setId(rs.getInt("ID"));
                 b.setFlightId(rs.getInt("FID"));
                 b.setLname(rs.getString("LastName"));
                 b.setFname(rs.getString("FirstName"));
                 b.setStatus(rs.getInt("BookingStatus"));
                 b.setUserID(rs.getInt("UID"));
                 b.setActualPrice(rs.getInt("ActualPrice"));
                 b.setFStatus(rs.getInt("FlightStatus"));
                 blist.add(b);
             }
             rs.close();
             stmt.close();
             con.close();
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(CustFlights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustFlights.class.getName()).log(Level.SEVERE, null, ex);
        }
         return blist;
    }
}
