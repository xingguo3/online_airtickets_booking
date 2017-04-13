/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lookup;

import java.sql.*;

/**
 *
 * @author GUOXING
 */
public class Registration {
    private static int CustomerID=111;
    
   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String DB_URL = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db";
   
   static final String USER = "aiad092";
   static final String PASS = "aiad092";
   
    private String username;
    private String gender;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private int membership;
    
   public Registration(String s1, String s2, String s3, String s4, String s5, String s6) {
        this.username=s1;
        this.gender=s2;
        this.password=s3;
        this.email=s4;
        this.firstname=s5;
        this.lastname=s6;     
   }
   
   public Registration(String s1, String s2, String s3, String s4, String s5, String s6, int s7) {
        this.username=s1;
        this.gender=s2;
        this.password=s3;
        this.email=s4;
        this.firstname=s5;
        this.lastname=s6; 
        this.membership=s7;
   }
   

   
    public void setCustomerID(){
        this.CustomerID = 111;
    }
    public int getCustomerID(){
        CustomerID++;
        return this.CustomerID;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public String getLastname(){
        return this.lastname;
    }
    
    public int getMembership(){
        return this.membership;
    }
   
    public boolean isExist() throws SQLException, ClassNotFoundException{
        Connection con = null;
        Statement stmt = null;
        int isExist = 0;
        try{

           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");

           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           String strQl = "SELECT UserName FROM dbo.userList WHERE UserName = '"+ this.getUsername() +"'";
           ResultSet rs = stmt.executeQuery(strQl);
           if(rs.next()){
               rs.close();
               isExist = 0;
           }else{
               rs.close();
               isExist = 1;
           }
           
        }finally{
            if (stmt!=null) {
                con.close();
            } 
           try{
              if(con!=null)
                 con.close();
           }catch(SQLException se){
              se.printStackTrace();
           }
        }
        if(isExist==0)
            return true;
        return false;
    }
    
   public void insert() throws SQLException, ClassNotFoundException{
       //System.out.printf("successful");
        Connection con = null;
        Statement stmt = null;
        try{

           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");

           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           //tring strQL = "INSERT INTO dbo.userList VALUES ("+ this.getCustomerID()+ ", '"+this.getUsername()+"', '"+this.getPassword()+ "', "+this.getGender()+", '"+this.getFirstname()+"', '"+this.getLastname()+"', '0', '0', 0, '0', '0'，'" +this.getEmail()+"')";
           String strQl = "INSERT INTO dbo.userList VALUES ("+ this.getCustomerID()+ ", '"+this.getUsername()+ "', '"+this.getPassword()+"','"+this.getGender()+"', '"+this.getFirstname()+"', '"+this.getLastname()+"', '0', '0', 0, '0', '0','"+this.getEmail()+"')";
           stmt.executeQuery(strQl);
           
        }finally{
            if (stmt!=null) {
                con.close();
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


//private String username;
//    //private String gender ;
//    private String password;
//    private String email;
//    private String firstname;
//    private String lastname;
//    private Connection con;
//    public Registration(String s1, String s2, String s3, String s4, String s5, String s6) throws SQLException{
//        this.con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
//        this.username=s1;
//        this.password=s3;
//        this.email=s4;
//        this.firstname=s5;
//        this.lastname=s6;
//    }
//    public static void main(String[] args) {
//        Connection con = null;
//        Statement stmt = null;
//    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        
//    
//    //String strQl = "INSERT INTO dbo.usersList VALUES ("+ this.getCustomerID()+ ", 'chingming', 'ching','M', 'notok', 'ching', 'ming', '0', '0', 0, '0', '0')";
//    
//    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//    ResultSet rs = stmt.executeQuery(strQL);
//    if (rs != null) {
//        rs.close();
//    }
//    if (stmt != null) {
//        stmt.close();
//    }
//    if (con != null) {
//        con.close();
//    }
//    
//    
//    }

