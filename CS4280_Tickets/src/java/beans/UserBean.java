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
public class UserBean {
    private String id;
    private int gender;
    private String userName;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private int mile;
    private int bonus;
    
    
    public void setId(String _id){
        id=_id;
    }
    public String getId(){
        return id;
    }
    public void setLastName(String _lname){
        lastName=_lname;
    }
    public String getLastName(){
        return lastName;
    }
    public void setFirstName(String _fname){
        firstName=_fname;
    }
    public String getFirstName(){
        return firstName;
    } 
    public void setGender(int g){
        gender=g;
    }
    public int getGender(){
        return gender;
    }
    public void setUserName(String _uname){
        userName=_uname;
    }
    public String getUserName(){
        return userName;
    } public void setEmail(String _email){
        email=_email;
    }
    public String getEmail(){
        return email;
    } public void setPassword(String _pswd){
        password=_pswd;
    }
    public String getPassword(){
        return password;
    }
    public void setMile(int _mile){
        mile=_mile;
    }
    public int getMile(){
        return mile;
    }
    public void setBonus(int _bonus){
        bonus=_bonus;
    }
    public int getBonus(){
        return bonus;
    }
}
