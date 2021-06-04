package entidades;

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
