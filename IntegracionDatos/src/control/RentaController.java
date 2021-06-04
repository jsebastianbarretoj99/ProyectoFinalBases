/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import API.ConexionBD;
import entidades.DTOResumen;
import entidades.Renta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class RentaController {
    
    ConexionBD conexion = new ConexionBD();
    Connection con = conexion.conectar();

    public RentaController() {
    } // end RentaController
    
    private String convertirHora(LocalTime hora){
        String horaS = "";
        horaS += Integer.toString(hora.getHour()) + ":";
        if(hora.getMinute() < 10)
            horaS += '0';
        horaS += Integer.toString(hora.getMinute()) + ":";
        if(hora.getSecond() < 10)
            horaS += '0';
        horaS += Integer.toString(hora.getSecond());
        return horaS;
    } // end convertirHora
    
    public String crearRentaBD(LocalDate fecha, LocalTime hora){
        String consulta ="INSERT INTO Renta (Fecha, Hora) VALUES(?,?)";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setString(1, fecha.toString());
            statement.setString(2,  this.convertirHora(hora));
            statement.executeUpdate();
            return "Se creo la renta";
        }catch (SQLException sqle) { 
            return "Error en la creacion de renta";
        }    
    } // end crearRentaBD
    
    public Renta buscarUltimaRenta(){
        Renta renta = null;
        String consulta ="SELECT * FROM Renta ORDER BY 1 DESC";
        Integer paramAux;
        int x;
        try (
           PreparedStatement statement = this.con.prepareStatement(consulta);
           ResultSet rs = statement.executeQuery();){
            while (rs.next()){
              renta = new Renta(); 
              renta.setNumero(rs.getInt("Numero"));
              renta.setFecha(rs.getDate("Fecha"));
              renta.setHora(rs.getTime("Hora"));
              renta.setParametroid(rs.getInt("ParametroId"));
              break;
            } // end while
        } catch (SQLException sqle) { 
            System.out.println("Error trayendo los billetes");
        }    
        return renta;
    } // end consultaTiposBilletesBD
    
}
