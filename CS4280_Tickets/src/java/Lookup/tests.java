/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lookup;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author GUOXING
 */
public class tests {
    public static void main(String[] args) throws ClassNotFoundException {
        Registration re = null;
        try {
            re = new Registration(" "," "," "," "," "," ");
        } catch (SQLException ex) {
            Logger.getLogger(tests.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            re.insert();
        } catch (SQLException ex) {
            Logger.getLogger(tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
