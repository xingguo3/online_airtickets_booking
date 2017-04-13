/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author jzhang387
 */
public class BookedTicketBean {
    private String id;
    private String userID;
    private String flightNo;
    private int actualPrice;
    private String status;
    
    public void setId(String _id){
        id=_id;
    }
    public String getId(){
        return id;
    }
    public void setUserID(String _userID){
        userID=_userID;
    }
    public String getUserID(){
        return userID;
    }
    public void setFlightNo(String _flightNo){
        flightNo=_flightNo;
    }
    public String getFlightNo(){
        return flightNo;
    }
    public void setActualPrice(int _actPrice){
        actualPrice=_actPrice;
    }
    public int getActualPrice(){
        return actualPrice;
    }
    public void setStatus(String _status){
        status=_status;
    }
    public String getStatus(){
        return status;
    }
}
