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
    
    private String username;
    private String password;
    
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
        
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad092_db", "aiad092", "aiad092");
           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           String strQl = "SELECT Password FROM dbo.userList " + "WHERE UserName = '"+this.getUsername()+"'";
           ResultSet rs = stmt.executeQuery(strQl);
           while(rs.next()){
            String pswds = rs.getString("Password"); 
             if(pswds!=null&&pswds.equals(this.getPassword()))
                return true;
            pswd = pswds;
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
       
        return false;
    }

    public String getLastname() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFirstname() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getBonus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUserId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getRole() {
        return 0;
    }
}
