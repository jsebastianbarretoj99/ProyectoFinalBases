/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.Billete;
import entidades.Carro;
import entidades.DTOReporte;
import entidades.DTOResumen;
import entidades.Linea;
import entidades.Renta;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class FacadeOCR {
    
    private CarroController carroContro = new CarroController();
    private BilleteController billeteContro = new BilleteController();
    private RentaController rentaContro = new RentaController();

    public FacadeOCR() {
    } // end FacadeOCR
    
    DTOResumen contruirRespuestaRenta(Renta renta){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    } // end contruirRespuestaRenta
    
    DTOResumen crearRenta(){
        DTOResumen dtoResumen = new DTOResumen();
        String res = "";
        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now();
        dtoResumen.setFecha(fecha);
        dtoResumen.setHora(hora);
        List<Carro> lisCarros = new ArrayList<>();
        dtoResumen.setListaCarrosLinea(lisCarros);
        dtoResumen.setSaldoBilletesIngresados(0);
        dtoResumen.setTotalRenta(0);
        dtoResumen.setVueltasRenta(0);
        if(this.carroContro.consultarCarrosBD().size() > 0){
            res = this.rentaContro.crearRentaBD(fecha, hora);
            if("Se creo la renta".equals(res))
                dtoResumen.setMensaje("");
            else
                dtoResumen.setMensaje(res);
        }else{
            dtoResumen.setMensaje("No hay carros disponibles");
        }
        dtoResumen.setRenta(this.rentaContro.buscarUltimaRenta());
        return dtoResumen;
    } // end crearRenta
    
    DTOResumen agregarLinea(Linea dtoLinea){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    } // end agregarLinea
    
    DTOResumen eliminarLinea(Linea dtoLinea){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    } // end eliminarLinea
    
    DTOResumen agregarBillete(Billete dtoBillete){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    } // end agregarBillete
    
    DTOResumen terminarRenta(){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    } // end terminarRenta
    
    DTOResumen consultaRenta(Renta dtoRenta){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    }  // end consultaRenta
    
    List<DTOReporte> consultarAcumlados(){
        List<DTOReporte> dtoReporte = null;
        return dtoReporte;
    } // end consultarAcumlados
    
    List<Carro> consultarCarros(){
        return this.carroContro.consultarCarrosBD();
    } // end consultarCarros
    
    List<Billete> consultaTiposBilletes(){
        return this.billeteContro.consultaTiposBilletesBD();
    } // end consultaTiposBilletes
}
