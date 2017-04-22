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
 * @author User
 */
public class SearchFlight {
    public static ArrayList<FlightBean> searchSingleFlight(String from,String to,String date){
        Connection con=null;
        PreparedStatement prst=null;
        ArrayList<FlightBean> flightList;
        flightList = new ArrayList<>();
        try {
            String[] dateParts=date.split("-");
            int month=Integer.parseInt(dateParts[0]);
            int day=Integer.parseInt(dateParts[1]);
            int year=Integer.parseInt(dateParts[2]);
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
            String sql = "SELECT * FROM dbo.flight WHERE departure LIKE ? AND destina LIKE ? AND year="
                    +year+" AND month="+month+" AND day="+day;
            prst=con.prepareStatement(sql);
            prst.setString(1, "%"+from+"%");
            prst.setString(2,"%"+to+"%");
            ResultSet rs =prst.executeQuery();
            while(rs.next()){
                FlightBean f=new FlightBean();
                f.setFID(rs.getInt("FID"));
                f.setFlightNo(rs.getString("fNumber"));
                f.setFrom(rs.getString("Departure"));
                f.setTo(rs.getString("Destina"));
                f.setPrice(rs.getInt("Price"));
                f.setRemainSeat(rs.getInt("RemainSeat"));
                Timestamp t=rs.getTimestamp("TakeOff");
                f.setDeptTime(t.toString());
                t=rs.getTimestamp("Land");
                f.setArrivTime(t.toString());
                f.setStatus(rs.getInt("Status"));
                f.setCompany(rs.getString("Company"));
                //give discount by remaining seats
                int p=Discount.giveDicountByRemainSeat(f.getPrice(), f.getRemainSeat());
                f.setPrice(p);
                if(f.getRemainSeat()>0&&!f.getStatus().equals("Canceled"))
                    flightList.add(f);
            }
        
            rs.close();
  
            prst.close();
     
            con.close();
        
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchFlight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flightList;

    }
    
    public String getTime(Connection con,int fid) throws SQLException{
        Statement stmt=con.createStatement();
        String sql="SELECT convert(varchar(8), TakeOff, 108) from dbo.flight where fid="+fid;
        ResultSet rs=stmt.executeQuery(sql);
        String time=null;
        while(rs.next())
            time= rs.getString(1);
        stmt.close();
        return time;
        
    }

    public static FlightBean searchByFid(int fid){
        Connection con=null;
        FlightBean f=new FlightBean();
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
            
            Statement stmt=con.createStatement();
            String sql="select * from dbo.flight where fid="+fid;
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                
                f.setFID(rs.getInt("FID"));
                f.setFlightNo(rs.getString("fNumber"));
                f.setFrom(rs.getString("Departure"));
                f.setTo(rs.getString("Destina"));
                f.setPrice(rs.getInt("Price"));
                f.setRemainSeat(rs.getInt("RemainSeat"));
                Timestamp t=rs.getTimestamp("TakeOff");
                f.setDeptTime(t.toString());
                t=rs.getTimestamp("Land");
                f.setArrivTime(t.toString());
                f.setStatus(rs.getInt("Status"));
                f.setCompany(rs.getString("Company"));
                //give discount by remaining seats
                int p=Discount.giveDicountByRemainSeat(f.getPrice(), f.getRemainSeat());
                f.setPrice(p);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SearchFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
}

