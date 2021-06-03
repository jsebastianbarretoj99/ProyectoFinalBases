/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class ConexionBD {
    public static final String sURL = "jdbc:derby://localhost:1527/sample"; 
    public static final String  usuario= "app";
    public static final String password ="app";
    public static final String driver= "org.apache.derby.jdbc.ClientDriver";
    
    
    public ConexionBD(){
    }
    
    public Connection conectar(){
    Connection con= null;
        try {
            con = DriverManager.getConnection(sURL, usuario, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
}
