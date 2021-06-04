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
 * @author
 * Nombre Grupo: Maria Madre de Dios ruega por nosotros los desarrolladores
 *      Nombres:
 *          1. Juan Sebastian Barreto Jimenez.
 *          2. Janet Chen He.
 *          3. Maria Jose Nino Rodriguez.
 *          4. Maria Kamila Obregon Ortega.
 *          5. David Santiago Quintana Echavarria
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
        }    
        return listaBil;
    } // end consultaTiposBilletesBD
    
    public String actualizarBilletesBD(int denominacion, int idRenta, int idBillete, int cantidad){
        String consulta = "UPDATE Billete SET Cantidad = Cantidad + ? WHERE Denominacion = ?";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setInt(1, cantidad);
            statement.setInt(2, denominacion);
            statement.executeUpdate();
        }catch (SQLException sqle) { 
            return "Error en la actualizacion en el billete";
        }    
        boolean esta = false;
        String consult = "INSERT INTO BilletesXRenta (Rentanumero, BilleteId, Cantidad) VALUES (?,?,?)";
        String consult2 = "UPDATE BilletesXRenta SET Cantidad = Cantidad + ? WHERE BilleteId = ?";
        String consult3 = "SELECT * FROM BilletesXRenta WHERE Rentanumero = ? AND BilleteId = ?";
        try (
            PreparedStatement statement2 = this.con.prepareStatement(consult3);){
            statement2.setInt(1, idRenta);
            statement2.setInt(2, idBillete);
            try (
                ResultSet rs = statement2.executeQuery();){
                while (rs.next()){
                 esta = true;
                } // end while
            }
            if(esta == true){
                try (
                    PreparedStatement statement3 = this.con.prepareStatement(consult2);){
                    statement3.setInt(1, cantidad);
                    statement3.setInt(2, idBillete);
                    statement3.executeUpdate();
                }
            }else{
                try (
                    PreparedStatement statement4 = this.con.prepareStatement(consult);){
                    statement4.setInt(1, idRenta);
                    statement4.setInt(2, idBillete);
                    statement4.setInt(3, cantidad);
                    statement4.executeUpdate();
                }
            }
        }catch (SQLException sqle) { 
            return "Error en la actualizacion en el billete";
        } 
        return "";
    } // end actualizarBilletesBD
    
    public List<Billete> billxRenta(int idRenta){
        List<Billete> listaBil = new ArrayList<>();
        Billete billete;
        String consulta ="SELECT b.Id, b.Denominacion, bxr.Cantidad  FROM Billete AS b, BilletesXRenta AS bxr WHERE b.Id = bxr.BilleteId AND bxr.Rentanumero = ?";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setInt(1, idRenta);
            try(ResultSet rs = statement.executeQuery();){
                while (rs.next()){
                  billete = new Billete(); 
                  billete.setId(rs.getInt("Id"));
                  billete.setDenominacion(rs.getInt("Denominacion"));
                  billete.setCantidad(rs.getInt("Cantidad"));
                  listaBil.add(billete);
                } // end while
        }
        } catch (SQLException sqle) { 
        }
        return listaBil;
    }
}
