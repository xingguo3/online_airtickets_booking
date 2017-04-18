/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author jzhang387
 */
public class BookedTicketBean {
    private int id;
    private int userID;
    private int flightId;
    private int actualPrice;
    private String status;
    private String lname;
    private String fname;
    private Date bTime; 
    private String fStatus;
    
    public void setId(int _id){
        id=_id;
    }
    public int getId(){
        return id;
    }
    public void setUserID(int _userID){
        userID=_userID;
    }
    public int getUserID(){
        return userID;
    }
    public void setFlightId(int _flightId){
        flightId=_flightId;
    }
    public int getFlightNo(){
        return flightId;
    }
    public void setActualPrice(int _actPrice){
        actualPrice=_actPrice;
    }
    public int getActualPrice(){
        return actualPrice;
    }
    public void setStatus(int _status){
        if(_status==0)
            status="refunded";
        if(_status==1)
            status="used";
        if(_status==2)
            status="unused";
    }
    public String getStatus(){
        return status;
    }
    public void setLname(String l){
        lname=l;
    }
    public String getLname(){
        return lname;
    }
    public void setFname(String f){
        fname=f;
    }
    public String getFname(){
        return fname;
    }
     public void setFStatus(int _fstatus){
        if(_fstatus==0)
            fStatus="cancelled";
        if(_fstatus==1)
            fStatus="normal";
        if(_fstatus==2)
            fStatus="delayed";
    }
    public String getFStatus(){
        return fStatus;
    }
}
