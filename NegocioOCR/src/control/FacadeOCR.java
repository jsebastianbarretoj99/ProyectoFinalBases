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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class FacadeOCR {
    
    CarroController carroControl = new CarroController();
    BilleteController billeteControl = new BilleteController();

    public FacadeOCR() {
    } // end FacadeOCR
    
    public String convertirHora(LocalDateTime hora){
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
    
    public String convertirFecha(LocalDateTime fecha){
        String fechaS = "";
        fechaS += Integer.toString(fecha.getYear()) + "-";
        if(fecha.getMonthValue() < 10)
            fechaS += '0';
        fechaS += Integer.toString(fecha.getMonthValue()) + "-";
        if(fecha.getDayOfMonth() < 10)
            fechaS += '0';
        fechaS += Integer.toString(fecha.getDayOfMonth());
        return fechaS;
    } // end convertirFecha
    
    DTOResumen contruirRespuestaRenta(Renta renta){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    } // end contruirRespuestaRenta
    
    DTOResumen crearRenta(){
        DTOResumen dtoResumen = new DTOResumen();
        LocalDateTime date = LocalDateTime.now();
        String fecha = this.convertirFecha(date);
        String hora = this.convertirHora(date);
        dtoResumen.setFecha(fecha);
        dtoResumen.setHora(hora);
        List<Carro> lisCarros = new ArrayList<>();
        dtoResumen.setListaCarrosLinea(lisCarros);
        dtoResumen.setSaldoBilletesIngresados(0);
        dtoResumen.setTotalRenta(0);
        dtoResumen.setVueltasRenta(0);
        dtoResumen.setMensaje(carroControl.crearRentaBD(fecha, hora));
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
        return carroControl.consultarCarrosBD();
    } // end consultarCarros
    
    List<Billete> consultaTiposBilletes(){
        return billeteControl.consultaTiposBilletesBD();
    } // end consultaTiposBilletes
}
