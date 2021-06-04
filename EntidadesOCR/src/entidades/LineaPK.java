package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

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
@Embeddable
public class LineaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NUMERO")
    private int numero;
    @Basic(optional = false)
    @Column(name = "RENTANUMERO")
    private int rentanumero;

    public LineaPK() {
    }

    public LineaPK(int numero, int rentanumero) {
        this.numero = numero;
        this.rentanumero = rentanumero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getRentanumero() {
        return rentanumero;
    }

    public void setRentanumero(int rentanumero) {
        this.rentanumero = rentanumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numero;
        hash += (int) rentanumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaPK)) {
            return false;
        }
        LineaPK other = (LineaPK) object;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.rentanumero != other.rentanumero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LineaPK[ numero=" + numero + ", rentanumero=" + rentanumero + " ]";
    }
    
}
