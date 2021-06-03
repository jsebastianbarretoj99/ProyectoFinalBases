/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class DTOResumen {
    
    private String mensaje;
    private List<Carro> listaCarrosLinea;
    private int totalRenta;
    private int saldoBilletesIngresados;
    private int vueltasRenta;
    private String fecha;
    private String hora;

    public DTOResumen() {
    }

    public DTOResumen(String mensaje, List<Carro> listaCarrosLinea, int totalRenta, int saldoBilletesIngresados, int vueltasRenta, String fecha, String hora) {
        this.mensaje = mensaje;
        this.listaCarrosLinea = listaCarrosLinea;
        this.totalRenta = totalRenta;
        this.saldoBilletesIngresados = saldoBilletesIngresados;
        this.vueltasRenta = vueltasRenta;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Carro> getListaCarrosLinea() {
        return listaCarrosLinea;
    }

    public void setListaCarrosLinea(List<Carro> listaCarrosLinea) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    } 

    @Override
    public String toString() {
        return "DTOResumen{" + "mensaje=" + mensaje + ", listaCarrosLinea=" + listaCarrosLinea + ", totalRenta=" + totalRenta + ", saldoBilletesIngresados=" + saldoBilletesIngresados + ", vueltasRenta=" + vueltasRenta + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
 
}
