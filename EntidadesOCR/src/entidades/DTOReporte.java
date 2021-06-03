/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author juansebastianbarretojimenez
 */
public class DTOReporte {
    
    private int anio;
    private int mes;
    private int cantidadCarros;

    public DTOReporte() {
    }
    
    public DTOReporte(int anio, int mes, int cantidadCarros) {
        this.anio = anio;
        this.mes = mes;
        this.cantidadCarros = cantidadCarros;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getCantidadCarros() {
        return cantidadCarros;
    }

    public void setCantidadCarros(int cantidadCarros) {
        this.cantidadCarros = cantidadCarros;
    }
    
}
