package control;

import entidades.Billete;
import entidades.Carro;
import entidades.DTOReporte;
import entidades.DTOResumen;
import entidades.Linea;
import entidades.Parametro;
import entidades.Renta;
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
    
    private DTOResumen calculoTotal(List<Linea> lineas, int idRenta){
        DTOResumen dtoResumen = new DTOResumen();
        String mensaje = "";
        int descuento = 0;
        int total = 0;
        List<Parametro> parametros;
        parametros = this.rentaContro.buscarParametros();
        for(Parametro par: parametros){
             if(par.getTasacarros() < lineas.size()){
                 mensaje = this.rentaContro.agregarDescuentoBD(par.getId(), idRenta);
                 descuento = par.getValor();
                 if("Se actualizo renta".equals(mensaje))
                     mensaje = "";
                 break;
             } 
        } // en for
        for(Linea lin: lineas){
            lin.setCarroRentado(this.carroContro.buscarCarroBD(lin.getCarroid()));
            total += lin.getCarroRentado().getPrecio();
        } // en for
        total -= (total*descuento/100);
        dtoResumen.setMensaje(mensaje);
        dtoResumen.setTotalRenta(total);
        return dtoResumen;
    } // end calculoTotal
    
    public DTOResumen agregarLinea(Linea dtoLinea){
        DTOResumen dtoResumen = new DTOResumen();
        List<Linea> lineas;
        String mensaje = "";
        Carro carro;
        if(!this.carroContro.verificarCarroBD(dtoLinea.getCarroid())){
            mensaje = "Carro no existe en el catalogo";
        }else{
            carro = this.carroContro.buscarCarroBD(dtoLinea.getCarroid());
            if(carro.getUnidadesdisponibles() == 0){
                mensaje = "Carro no cuenta con unidades disponibles";
            }else{
               mensaje = this.rentaContro.agregarLineaBD(dtoLinea);
               if("Se creo la linea".equals(mensaje)){
                   mensaje = "";
                   dtoLinea.setCarroRentado(carro);
                   lineas = this.rentaContro.buscarLineas(dtoLinea.getLineaPK().getRentanumero());
                   DTOResumen resAux = this.calculoTotal(lineas,dtoLinea.getLineaPK().getRentanumero());
                   return contruirRespuestaRenta(new Renta(),lineas,0,resAux.getTotalRenta(),0,resAux.getMensaje());
               }
            } // end if
        } // end if
        return contruirRespuestaRenta(new Renta(), new ArrayList<>(),0,0,0,mensaje);
    } // end agregarLinea
    
    public DTOResumen eliminarLinea(Linea dtoLinea){
        DTOResumen dtoResumen = new DTOResumen();
        String mensaje;
        if( dtoLinea == null ){
            mensaje = "Linea ingresada es vacia";
        }else{
            List<Linea> listaB;
            listaB = this.rentaContro.buscarLineas(dtoLinea.getLineaPK().getRentanumero());
            if( listaB.isEmpty() ){
                mensaje = "Linea no registrada";
            }else{
                mensaje = this.rentaContro.eliminarLineaBD(dtoLinea.getLineaPK().getNumero(), dtoLinea.getLineaPK().getRentanumero());
                if("".equals(mensaje)){
                    listaB = this.rentaContro.buscarLineas(dtoLinea.getLineaPK().getRentanumero());
                    DTOResumen resAux = this.calculoTotal(listaB,dtoLinea.getLineaPK().getRentanumero());
                    return contruirRespuestaRenta(new Renta(),listaB,0,resAux.getTotalRenta(),0,resAux.getMensaje());
                } // end if
            }
        }
        return contruirRespuestaRenta(new Renta(),new ArrayList<>(),0,0,0,mensaje);
    } // end eliminarLinea
    
    public DTOResumen agregarBillete(Billete dtoBillete, int idRenta){
        DTOResumen dtoResumen = new DTOResumen();
        String mensaje = "";
        int total=0;
        List<Billete> billRent = this.billeteContro.billxRenta(idRenta);
        for(Billete bill: billRent){
            total+= bill.getCantidad() * bill.getDenominacion();
        }
        // a.validar que exista la denominacion que llega como parametro
        int denominacioLlegada = dtoBillete.getDenominacion();
        List<Billete> temp = billeteContro.consultaTiposBilletesBD();
        
        boolean esta=false;
        for(Billete billeteAct: temp ){
            int denominacionCompr = billeteAct.getDenominacion();
            if(denominacioLlegada==denominacionCompr)
            {
                esta = true;
                billeteAct.setCantidad(dtoBillete.getCantidad());
                total+=billeteAct.getCantidad()*billeteAct.getDenominacion();
                mensaje = this.billeteContro.actualizarBilletesBD(billeteAct.getDenominacion(), idRenta, billeteAct.getId(), billeteAct.getCantidad());
            }
        }
        // b.si no se encuentra se diligencia el 'mensaje' del 'DtoResumen'
        if(!esta)
        {
            mensaje = "No existe esa denominacion de billete ingresado";
            return contruirRespuestaRenta(new Renta(),new ArrayList<>(),0,0,0,mensaje);
        }
        else
        { // c. crear el dtoResumen que se va a retorna
            Renta renta = new Renta();
            billRent = this.billeteContro.billxRenta(idRenta);
            renta.setPagoBilletes(billRent);
            return contruirRespuestaRenta(renta,new ArrayList<>(),total,0,0,mensaje);
        }
    } // end agregarBillete
    
    public DTOResumen terminarRenta(List<Linea> lineas, int idRenta, int saldo){
        String mensaje = "";
        DTOResumen tot = calculoTotal(lineas, idRenta);
        int vueltas = 0;
        int total = tot.getTotalRenta() ;
        if(saldo < total){
          mensaje = "Debe pagar el total de la renta";
        }
        if(saldo >= total){
          vueltas = calcularVueltos(saldo,total);
        }
        return contruirRespuestaRenta(new Renta(), new ArrayList(), 0, 0, vueltas, mensaje);
    } // end terminarRenta
    
    private int calcularVueltos(int t1, int t2){
        return t1-t2;
    }
    
    public DTOResumen consultaRenta(Renta dtoRenta){
        String res = "";
        List<Linea> lineas;
        List<Billete> billetes;
        int total = 0;
        int saldo = 0;
        int vueltas;
        Renta renta = this.rentaContro.buscarRentaBD(dtoRenta.getNumero());
        if(renta == null){
            res = "No se encontro Renta que coincida";
        }else{
            lineas = this.rentaContro.buscarLineas(dtoRenta.getNumero());
            for(Linea lin: lineas)
                lin.setCarroRentado(this.carroContro.buscarCarroBD(lin.getCarroid()));
            total = this.calculoTotal(lineas, dtoRenta.getNumero()).getTotalRenta();
            billetes = this.billeteContro.billxRenta(dtoRenta.getNumero());
            for(Billete bil: billetes)
                saldo+= bil.getCantidad() * bil.getDenominacion(); 
            vueltas = this.calcularVueltos(saldo, total);
            return contruirRespuestaRenta(renta, lineas, saldo, total, vueltas, res);
        }
        return contruirRespuestaRenta(new Renta(), new ArrayList<>(), 0, 0, 0, res);
    }  // end consultaRenta
    
    public List<DTOReporte> consultarAcumlados(){
        return this.rentaContro.consultarAcumladosBD();
    } // end consultarAcumlados
    
    public List<Carro> consultarCarros(){
        return this.carroContro.consultarCarrosBD();
    } // end consultarCarros
    
    public List<Billete> consultaTiposBilletes(){
        return this.billeteContro.consultaTiposBilletesBD();
    } // end consultaTiposBilletes
 
}
