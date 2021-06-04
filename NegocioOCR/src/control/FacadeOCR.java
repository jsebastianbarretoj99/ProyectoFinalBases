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
import entidades.DTOTabla;
import entidades.Linea;
import entidades.Parametro;
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
    
    private final CarroController carroContro;
    private final BilleteController billeteContro;
    private final RentaController rentaContro;

    public FacadeOCR() {
        this.carroContro = new CarroController();
        this.billeteContro = new BilleteController();
        this.rentaContro = new RentaController();
    } // end FacadeOCR
    
    public DTOResumen contruirRespuestaRenta(Renta renta, List<Linea> lisLineas, int saldoBilletesIngresados, int totalRenta, int vueltasRenta, String mensaje){
        renta.setLineas(lisLineas);
        return new DTOResumen(mensaje, lisLineas, totalRenta, saldoBilletesIngresados, vueltasRenta, renta.getFecha(), renta.getHora(), renta);
    } // end contruirRespuestaRenta
    
    public DTOResumen crearRenta(){
        DTOResumen dtoResumen;
        String res = "";
        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now();
        List<Linea> lisLineas = new ArrayList<>();
        if(this.carroContro.consultarCarrosBD().size() > 0){
            res = this.rentaContro.crearRentaBD(fecha, hora);
            if("Se creo la renta".equals(res))
                res = "";
        }else{
            res = "No hay carros disponibles";
        } // end if
        dtoResumen = this.contruirRespuestaRenta(this.rentaContro.buscarUltimaRenta(), lisLineas, 0, 0, 0, res);
        return dtoResumen;
    } // end crearRenta
    
    public DTOResumen agregarLinea(Linea dtoLinea){
        DTOResumen dtoResumen = null;
        String mensaje;
        Carro carro;
        List<Parametro> parametros;
        int descuento = 0;
        if(!this.carroContro.verificarCarroBD(dtoLinea.getCarroid())){
            mensaje = "Carro no existe en el catalogo";
        }else{
            carro = this.carroContro.buscarCarroBD(dtoLinea.getCarroid());
            if(carro.getUnidadesdisponibles() == 0){
                mensaje = "Carro no cuenta con unidades disponibles";
            }else{
               mensaje = this.rentaContro.agregarLineaBD(dtoLinea);
               if("Se creo la linea".equals(mensaje)){
                   dtoLinea.setCarroRentado(carro);
                   dtoResumen.setListaCarrosLinea(this.rentaContro.buscarLineas(dtoLinea.getLineaPK().getRentanumero()));
                   parametros = this.rentaContro.buscarParametros();
                   for(Parametro par: parametros){
                       if(par.getTasacarros() < dtoResumen.getListaCarrosLinea().size()){
                           // ALTERAR
                          descuento = par.getValor();
                       } 
                   }
                   
               }
            } // end if
        } // end if
        dtoResumen.setMensaje(mensaje);
        return dtoResumen;
    } // end agregarLinea
    
    public DTOResumen eliminarLinea(Linea dtoLinea){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    } // end eliminarLinea
    
    public DTOResumen agregarBillete(Billete dtoBillete){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    } // end agregarBillete
    
    public DTOResumen terminarRenta(){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    } // end terminarRenta
    
    public DTOResumen consultaRenta(Renta dtoRenta){
        DTOResumen dtoResumen = null;
        return dtoResumen;
    }  // end consultaRenta
    
    public List<DTOReporte> consultarAcumlados(){
        List<DTOReporte> dtoReporte = null;
        return dtoReporte;
    } // end consultarAcumlados
    
    public List<Carro> consultarCarros(){
        return this.carroContro.consultarCarrosBD();
    } // end consultarCarros
    
    public List<Billete> consultaTiposBilletes(){
        return this.billeteContro.consultaTiposBilletesBD();
    } // end consultaTiposBilletes
 
}
