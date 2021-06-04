package control;

import API.ConexionBD;
import entidades.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * Nombre Grupo: Maria Madre de Dios ruega por nosotros los desarrolladores
 *      Nombres:
 *          1. Juan Sebastian Barreto Jimenez.
 *          2. Janet Chen He.
 *          3. Maria Jose Nino Rodriguez.
 *          4. Maria Kamila Obregon Ortega.
 *          5. David Santiago Quintana Echavarria
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
    
    public boolean verificarCarroBD(int id){
        String consulta ="SELECT * FROM Carro WHERE Id=?";
        try (
           PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setInt(1, id);
            try(
           ResultSet rs = statement.executeQuery();){
                while (rs.next())
                    return true;
            }
        } catch (SQLException sqle) { 
        }  
        return false;
    } // end verificarCarroBD
    
    public Carro buscarCarroBD(int id){
        Carro carro = null;
        String consulta ="SELECT * FROM Carro WHERE Id=?";
        try (
           PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setInt(1, id);
            try(
                ResultSet rs = statement.executeQuery();){
                while (rs.next()){
                    carro = new Carro();
                    carro.setId(rs.getInt("Id"));
                    carro.setId(rs.getInt("Id"));
                    carro.setPlaca(rs.getString("Placa"));
                    carro.setPrecio(rs.getInt("Precio"));
                    carro.setPuestos(rs.getInt("Puestos"));
                    carro.setUnidadesdisponibles(rs.getInt("UnidadesDisponibles"));
                }
            }
        } catch (SQLException sqle) { 
        }  
        return carro;
    } // end buscarCarroBD
    
    public List<Carro> consultarCarrosBD(){
        List<Carro> listaCarros = new ArrayList<>();
        Carro carro;
        String consulta ="SELECT * FROM Carro";
        try (
           PreparedStatement statement = this.con.prepareStatement(consulta);
           ResultSet rs = statement.executeQuery();){
            while (rs.next()){
              carro = new Carro(); 
              carro.setId(rs.getInt("Id"));
              carro.setPlaca(rs.getString("Placa"));
              carro.setPrecio(rs.getInt("Precio"));
              carro.setPuestos(rs.getInt("Puestos"));
              carro.setUnidadesdisponibles(rs.getInt("UnidadesDisponibles"));
              listaCarros.add(carro);
            } // end while
        } catch (SQLException sqle) { 
        }    
        return listaCarros;
    } // end consultarCarros
 
}
