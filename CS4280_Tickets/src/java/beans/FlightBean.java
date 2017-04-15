/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.util.*;
/**
 *
 * @author jzhang387
 */
public class FlightBean {
    private int fID;
    private String flightNo;
    private String from;
    private String to;
    private String deptTime;
    private String arrivTime;
    private int remainSeat;
    private double discount;
    private int price;
    private String airType;
    private int status;
    
    public void setFID(int id){
        fID=id;
    }
    public int getFID(){
        return fID;
    }
    public void setFlightNo(String _flightNo){
        flightNo=_flightNo;
    }
    public String getFlightNo(){
        return flightNo;
    }
      public void setFrom(String _from){
        from=_from;
    }
    public String getFrom(){
        return from;
    }
     public void setTo(String _to){
        to=_to;
    }
    public String getTo(){
        return to;
    }
     public void setRemainSeat(int _rseat){
        remainSeat=_rseat;
    }
    public int getRemainSeat(){
        return remainSeat;
    }
     public void setDiscout(double _discount){
        discount=_discount;
    }
    public double getDiscount(){
        return discount;
    }
     public void setPrice(int _price){
        price=_price;
    }
    public int getPrice(){
        return price;
    }
     public void setAirType(String _airType){
        airType=_airType;
    }
    public String getAirType(){
        return airType;
    }
    public void setDeptTime(String _deptTime){
        deptTime=_deptTime;
    }
    public String getDeptTime(){
        return deptTime;
    }
    public void setArrivTime(String _arrivTime){
        arrivTime=_arrivTime;
    }
    public String getArrivTime(){
        return arrivTime;
    }
    public void setStatus(int _status){
        status=_status;
    }
    public int getStatus(){
        return status;
    }
}
