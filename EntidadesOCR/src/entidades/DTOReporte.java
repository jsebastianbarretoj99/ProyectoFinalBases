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
    
    private Integer anio;
    private Integer mes;
    private Integer cantidadCarros;

    public DTOReporte() {
    }
    
    public DTOReporte(Integer anio, Integer mes, Integer cantidadCarros) {
        this.anio = anio;
        this.mes = mes;
        this.cantidadCarros = cantidadCarros;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getCantidadCarros() {
        return cantidadCarros;
    }

    public void setCantidadCarros(Integer cantidadCarros) {
        this.cantidadCarros = cantidadCarros;
    }
    
}
