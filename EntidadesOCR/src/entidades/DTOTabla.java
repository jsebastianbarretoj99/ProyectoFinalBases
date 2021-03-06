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
public class DTOTabla {
    
    private int numero;
    private String placa;
    private int cantidad;
    private int subtotalM;

    public DTOTabla() {
    }

    public DTOTabla(int numero, String placa, int cantidad, int subtotalM) {
        this.numero = numero;
        this.placa = placa;
        this.cantidad = cantidad;
        this.subtotalM = subtotalM;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getSubtotalM() {
        return subtotalM;
    }

    public void setSubtotalM(int subtotalM) {
        this.subtotalM = subtotalM;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
             
}
