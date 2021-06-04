/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import API.ConexionBD;
import entidades.Linea;
import entidades.Parametro;
import entidades.Renta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
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
    
    public String agregarLineaBD(Linea dtoLinea){
        String consulta ="INSERT INTO Linea (Numero, Rentanumero, CarroId, Cantidad) VALUES(?,?,?,1)";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setInt(1, dtoLinea.getLineaPK().getNumero());
            statement.setInt(2, dtoLinea.getLineaPK().getRentanumero());
            statement.setInt(3, dtoLinea.getCarroid());
            statement.executeUpdate();
            return "Se creo la linea";
        }catch (SQLException sqle) { 
            return "Error en la creacion de la linea";
        }    
    } // end agregarLineaBD
    
    public List<Linea> buscarLineas(int idRenta){
        List<Linea> lineas = new ArrayList<>();
        Linea linea = null;
        String consulta ="SELECT * FROM Linea WHERE Id = ?";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setInt(1,idRenta);
            try(
                ResultSet rs = statement.executeQuery();){
                while (rs.next()){
                  linea = new Linea(); 
                  linea.getLineaPK().setNumero(rs.getInt("Numero"));
                  linea.getLineaPK().setRentanumero(rs.getInt("Rentanumero"));
                  linea.setCarroid(rs.getInt("CarroId"));
                  linea.setCantidad(rs.getInt("Cantidad"));
                  lineas.add(linea);
                } // end while
            }
        } catch (SQLException sqle) { 
            System.out.println("Error trayendo los billetes");
        }    
        return lineas;
    } // end buscarLineas
    
    public List<Parametro> buscarParametros(){
        List<Parametro> parametros = new ArrayList<>();
        Parametro parametro = null;
        String consulta ="SELECT * FROM Parametro ORDER BY 1 DESC";
        try (
           PreparedStatement statement = this.con.prepareStatement(consulta);
           ResultSet rs = statement.executeQuery();){
            while (rs.next()){
              parametro = new Parametro(); 
              parametro.setId(rs.getInt("Id"));
              parametro.setValor(rs.getInt("Valor"));
              parametro.setTasacarros(rs.getInt("TasaCarros"));
              parametros.add(parametro);
            } // end while
        } catch (SQLException sqle) { 
            System.out.println("Error trayendo los Parametros");
        }    
        return parametros;
    } // end buscarLineas
    
} // end RentaController
