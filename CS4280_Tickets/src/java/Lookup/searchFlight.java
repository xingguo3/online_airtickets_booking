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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import beans.FlightBean;

/**
 *
 * @author User
 */
public class searchFlight {
    public static ArrayList<FlightBean> searchSingleFlight(String from,String to,String date){
        Connection con=null;
        PreparedStatement prst=null;
        ArrayList flightList;
        flightList = new ArrayList<FlightBean>();
        try {
            String[] dateParts=date.split("-");
            int month=Integer.parseInt(dateParts[0]);
            int day=Integer.parseInt(dateParts[1]);
            int year=Integer.parseInt(dateParts[2]);
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
            String sql = "SELECT * FROM dbo.flight WHERE departure LIKE ? AND destina Like ? AND year="
                    +year+" AND month="+month+"AND day="+day;
            prst=con.prepareStatement(sql);
            prst.setString(1, from);
            prst.setString(2,to);
            ResultSet rs =prst.executeQuery();
            while(rs.next()){
                FlightBean f=new FlightBean();
                f.setFlightNo(rs.getString("fNumber"));
                f.setFrom(rs.getString("Departure"));
                f.setTo(rs.getString("Destina"));
                f.setPrice(rs.getInt("Price"));
                f.setRemainSeat(rs.getInt("RemainSeat"));
                f.setDeptTime(rs.getDate("TakeOff"));
                f.setArrivTime(rs.getDate("Land"));
                f.setStatus(rs.getInt("Status"));
                flightList.add(f);
            }
        
            rs.close();
  
            prst.close();
     
            con.close();
        
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchFlight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flightList;

    }
}
