package entidades;

import java.sql.Time;
import java.util.Date;
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
public class DTOResumen {
    
    private String mensaje;
    private List<Linea> listaCarrosLinea;
    private int totalRenta;
    private int saldoBilletesIngresados;
    private int vueltasRenta;
    private Date fecha;
    private Time hora;
    private Renta renta;

    public DTOResumen() {
    }

    public DTOResumen(String mensaje, List<Linea> listaCarrosLinea, int totalRenta, int saldoBilletesIngresados, int vueltasRenta, Date fecha, Time hora) {
        this.mensaje = mensaje;
        this.listaCarrosLinea = listaCarrosLinea;
        this.totalRenta = totalRenta;
        this.saldoBilletesIngresados = saldoBilletesIngresados;
        this.vueltasRenta = vueltasRenta;
        this.fecha = fecha;
        this.hora = hora;
    }

    public DTOResumen(String mensaje, List<Linea> listaCarrosLinea, int totalRenta, int saldoBilletesIngresados, int vueltasRenta, Date fecha, Time hora, Renta renta) {
        this.mensaje = mensaje;
        this.listaCarrosLinea = listaCarrosLinea;
        this.totalRenta = totalRenta;
        this.saldoBilletesIngresados = saldoBilletesIngresados;
        this.vueltasRenta = vueltasRenta;
        this.fecha = fecha;
        this.hora = hora;
        this.renta = renta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Linea> getListaCarrosLinea() {
        return listaCarrosLinea;
    }

    public void setListaCarrosLinea(List<Linea> listaCarrosLinea) {
        this.listaCarrosLinea = listaCarrosLinea;
    }

    public int getTotalRenta() {
        return totalRenta;
    }

    public void setTotalRenta(int totalRenta) {
        this.totalRenta = totalRenta;
    }

    public int getSaldoBilletesIngresados() {
        return saldoBilletesIngresados;
    }

    public void setSaldoBilletesIngresados(int saldoBilletesIngresados) {
        this.saldoBilletesIngresados = saldoBilletesIngresados;
    }

    public int getVueltasRenta() {
        return vueltasRenta;
    }

    public void setVueltasRenta(int vueltasRenta) {
        this.vueltasRenta = vueltasRenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    } 

    public Renta getRenta() {
        return renta;
    }

    public void setRenta(Renta renta) {
        this.renta = renta;
    }

    @Override
    public String toString() {
        return "DTOResumen{" + "mensaje=" + mensaje + ", listaCarrosLinea=" + listaCarrosLinea + ", totalRenta=" + totalRenta + ", saldoBilletesIngresados=" + saldoBilletesIngresados + ", vueltasRenta=" + vueltasRenta + ", fecha=" + fecha + ", hora=" + hora + ", renta=" + renta + '}';
    }

}
