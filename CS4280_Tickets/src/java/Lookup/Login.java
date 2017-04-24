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
public class Login {
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    static final String DB_URL = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db";
   
    static final String USER = "aiad092";
    static final String PASS = "aiad092";

    public static void logout(int id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement stmt = null;
        String pswd = null;
        boolean isV = false;

        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           String strQl = "SELECT * FROM dbo.userList";
           //, Email, firstName, lastName, bonus
          
             stmt.execute("UPDATE dbo.usersList SET Online = 0 WHERE UserID = "+id+"");
            
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

    public static int count() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement stmt = null;
        String pswd = null;
        int number=0;
        ResultSet rs = null;

        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           //, Email, firstName, lastName, bonus
          
           rs = stmt.executeQuery("SELECT COUNT(*)[1] FROM dbo.usersList WHERE Online = 1 AND Membership!=4");
            while(rs.next()){
                number = rs.getInt(1);
            }
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
        
        return number;
    }
    
    private int userID;
    private String username;
    private String password;
    private int membership;
    private String email;
    private String firstName;
    private String lastName;
    private int bonus=-1;
    
    public Login(String s1, String s2){
        this.username=s1;
        this.password=s2;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public boolean isValid() throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        Statement stmt = null;
        String pswd = null;
        boolean isV = false;

        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           String strQl = "SELECT * FROM dbo.userList";
           //, Email, firstName, lastName, bonus
          
           ResultSet rs = stmt.executeQuery("SELECT UserID, Password, Membership FROM dbo.usersList WHERE UserName = '"+this.getUsername()+"'");
           
           
           while(rs != null && rs.next() != false){
               this.setUserID(rs.getInt("UserID"));
               String pswds=rs.getString("Password");
                //pswd = rs.getString("Password"); 
                //this.setEmail(pswds);
                this.setRole(rs.getInt("Membership"));
                //setRole(4);
                String pasd = pswds;
               
                String tmp = this.getPassword();
                if(pasd!=null&&(tmp.equals(pasd))){
                    isV=true;               
                }
                //break;
           }
           rs.close();
            
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
        if(isV){
            login();
        }
        return isV;
    }

    public void login() throws ClassNotFoundException, SQLException{
        Connection con = null;
        Statement stmt = null;
        String pswd = null;
        boolean isV = false;

        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           String strQl = "SELECT * FROM dbo.userList";
           //, Email, firstName, lastName, bonus
          
             stmt.execute("UPDATE dbo.usersList SET Online = 1 WHERE UserName = '"+this.getUsername()+"'");
            
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
    public String getLastname() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFirstname() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEmail(String a){
        this.email=a;
    }
    
    public String getEmail() {
        return this.email;
    }
    public void setBonus(int a){
        this.bonus=a;
    }
    public int getBonus() {
        return this.bonus;
    }
    
    public void setUserID(int a){
        this.userID = a;
    }

    public int getUserId() {
        return this.userID;
    }
    
    public void setRole(int a){
        this.membership=a;
    }
    
    public int getRole() {
        return this.membership;
    }
}
