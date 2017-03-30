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
public class UserBean {
    private String id;
    private String lastName;
    private String firstName;
    private String email;
    private String password
    
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
    
}
