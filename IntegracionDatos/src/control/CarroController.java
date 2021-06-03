/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import API.ConexionBD;
import entidades.Carro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class CarroController {
    
    ConexionBD conexion = new ConexionBD();
    Connection con = conexion.conectar();
    
       /* public List<Asamblea> getAsambleasConjunto(@PathParam("idConjunto") int id) {
        List<Asamblea> asambleas = new ArrayList<>();
        Asamblea asamblea;
        AsambleaPK asambleaPK;
        String consulta = "SELECT a.IdAsamblea, a.Tema, a.Fecha, a.Hora, a.estado "
                        + "FROM Asamblea a "
                        + "WHERE a.ConjuntoIdConjunto = ? ";
        try (
           PreparedStatement statement = this.con.prepareStatement(consulta);){
           statement.setInt(1, id);
           try(
           ResultSet rs = statement.executeQuery();
            ){
            while (rs.next()){
              asamblea = new Asamblea(); 
              asambleaPK = new AsambleaPK();
              asambleaPK.setIdAsamblea(rs.getInt("IdAsamblea"));
              asamblea.setAsambleaPK(asambleaPK);
              asamblea.setTema(rs.getString("Tema"));
              asamblea.setEstado(rs.getString("estado"));
              asamblea.setFecha(rs.getBigDecimal("Fecha"));
              asamblea.setHora(rs.getBigDecimal("Hora"));
              asambleas.add(asamblea);
            } // end while
           }
        } catch (SQLException sqle) { 
            System.out.println("Error");
        }        
        return asambleas;
    }*/ // end getAsambleasConjunto

    public CarroController() {
    } // end CarroController
    
    List<Carro> consultarCarrosBD(){
        List<Carro> listaCarros = new ArrayList<>();
        Carro carro;
        String consulta ="SELECT * FROM Carro WHERE UnidadesDisponibles = 1";
        try (
           PreparedStatement statement = this.con.prepareStatement(consulta);
           ResultSet rs = statement.executeQuery();){
            while (rs.next()){
              carro = new Carro(); 
              carro.setId(rs.getInt("Id"));
              carro.setPlaca(rs.getString("Placa"));
              carro.setPrecio(rs.getInt("Precio"));
              carro.setPuestos(rs.getInt("Puestos"));
              listaCarros.add(carro);
            } // end while
        } catch (SQLException sqle) { 
            System.out.println("Error trayendo los carros");
        }    
        return listaCarros;
    } // end consultarCarros
    
    public String crearRentaBD(String fecha, String hora){
        String consulta ="INSERT INTO Renta (Fecha, Hora) VALUES(?,?)";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setString(1, fecha);
            statement.setString(2, hora);
            statement.executeUpdate();
            return "Se creo la renta";
        }catch (SQLException sqle) { 
            return "Error en la creacion de renta";
        }    
    } // end crearRentaBD
}
