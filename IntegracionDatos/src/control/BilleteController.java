/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import API.ConexionBD;
import entidades.Billete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class BilleteController {
    
    ConexionBD conexion = new ConexionBD();
    Connection con = conexion.conectar();

    public BilleteController() {
    }
    
    List<Billete> consultaTiposBilletesBD(){
        List<Billete> listaBil = new ArrayList<>();
        Billete billete;
        String consulta ="SELECT * FROM Billete";
        try (
           PreparedStatement statement = this.con.prepareStatement(consulta);
           ResultSet rs = statement.executeQuery();){
            while (rs.next()){
              billete = new Billete(); 
              billete.setId(rs.getInt("Id"));
              billete.setDenominacion(rs.getInt("Denominacion"));
              billete.setCantidad(rs.getInt("Cantidad"));
              listaBil.add(billete);
            } // end while
        } catch (SQLException sqle) { 
            System.out.println("Error trayendo los billetes");
        }    
        return listaBil;
    } // end consultaTiposBilletesBD
    
}
