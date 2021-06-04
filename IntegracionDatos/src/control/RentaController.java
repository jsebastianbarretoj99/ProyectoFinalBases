package control;

import API.ConexionBD;
import entidades.DTOReporte;
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
 * @author
 * Nombre Grupo: Maria Madre de Dios ruega por nosotros los desarrolladores
 *      Nombres:
 *          1. Juan Sebastian Barreto Jimenez.
 *          2. Janet Chen He.
 *          3. Maria Jose Nino Rodriguez.
 *          4. Maria Kamila Obregon Ortega.
 *          5. David Santiago Quintana Echavarria
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
        }    
        return renta;
    } // end consultaTiposBilletesBD
    
    public Renta buscarRentaBD(int numero ){
        Renta renta = null;
        String consulta ="SELECT * FROM Renta WHERE Numero = ?";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setInt(1,numero);
            try(ResultSet rs = statement.executeQuery();){
                while (rs.next()){
                  renta = new Renta(); 
                  renta.setNumero(rs.getInt("Numero"));
                  renta.setFecha(rs.getDate("Fecha"));
                  renta.setHora(rs.getTime("Hora"));
                  break;
                } // end while
            }
        } catch (SQLException sqle) { 
        }
        return renta;
    } // end buscarRentaBD
    
    public String agregarLineaBD(Linea dtoLinea){
        String consulta ="INSERT INTO Linea (Numero, Rentanumero, CarroId, Cantidad) VALUES(?,?,?,1)";
        String consulta1 = "UPDATE Carro SET UnidadesDisponibles = 0 WHERE Id = ?";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);
            PreparedStatement statement1 = this.con.prepareStatement(consulta1);){
            statement.setInt(1, dtoLinea.getLineaPK().getNumero());
            statement.setInt(2, dtoLinea.getLineaPK().getRentanumero());
            statement.setInt(3, dtoLinea.getCarroid());
            statement1.setInt(1, dtoLinea.getCarroid());
            statement.executeUpdate();
            statement1.executeUpdate();
            return "Se creo la linea";
        }catch (SQLException sqle) { 
            return "Error en la creacion de la linea";
        }    
    } // end agregarLineaBD
    
    public String eliminarLineaBD(int numero, int rentaNumero){
        String consulta ="DELETE FROM Linea WHERE Numero = ? AND Rentanumero = ?";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setInt(1,numero);
            statement.setInt(2,rentaNumero);
            statement.executeUpdate();
            return "";
        } catch (SQLException sqle) { 
            return "Error eliminando linea";
        }
    } // end eliminarLineaBD
    
    public String agregarDescuentoBD(int id, int numero){
        String consulta ="UPDATE Renta SET ParametroId = ? WHERE Numero = ?";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);){
            statement.setInt(1, id);
            statement.setInt(2, numero);
            statement.executeUpdate();
            return "Se actualizo renta";
        }catch (SQLException sqle) { 
            return "Error en la actualizacion de la renta";
        }
    } // end agregarDescuentoBD
    
    public List<Linea> buscarLineas(int idRenta){
        List<Linea> lineas = new ArrayList<>();
        Linea linea = null;
        String consulta ="SELECT * FROM Linea WHERE Rentanumero = ?";
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
        }    
        return parametros;
    } // end buscarLineas
    
    public List<DTOReporte> consultarAcumladosBD(){
        List<DTOReporte> dtoReporte = new ArrayList<>();
        DTOReporte auxRep;
        String consulta ="SELECT Year(Fecha) AS Anio, Month(Fecha) AS Mes, COUNT(*) AS Cantidad FROM Renta GROUP BY Year(Fecha), Month(Fecha)";
        try (
            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();){
            while (rs.next()){
              auxRep = new DTOReporte(); 
              auxRep.setAnio(rs.getInt("Anio"));
              auxRep.setMes(rs.getInt("Mes"));
              auxRep.setCantidadCarros(rs.getInt("Cantidad"));
              dtoReporte.add(auxRep);
            } // end while
        } catch (SQLException sqle) { 
        }
        return dtoReporte;
    } // end consultarAcumlados
    
} // end RentaController
