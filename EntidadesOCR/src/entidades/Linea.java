package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
@Entity
@Table(name = "LINEA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linea.findAll", query = "SELECT l FROM Linea l"),
    @NamedQuery(name = "Linea.findByNumero", query = "SELECT l FROM Linea l WHERE l.lineaPK.numero = :numero"),
    @NamedQuery(name = "Linea.findByRentanumero", query = "SELECT l FROM Linea l WHERE l.lineaPK.rentanumero = :rentanumero"),
    @NamedQuery(name = "Linea.findByCantidad", query = "SELECT l FROM Linea l WHERE l.cantidad = :cantidad")})
public class Linea implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LineaPK lineaPK;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @JoinColumn(name = "CARROID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Integer carroid;
    
    private Carro carroRentado;

    public Linea() {
        this.lineaPK = new LineaPK();
    }

    public Linea(LineaPK lineaPK) {
        this.lineaPK = lineaPK;
    }

    public Linea(LineaPK lineaPK, int cantidad) {
        this.lineaPK = lineaPK;
        this.cantidad = cantidad;
    }

    public Linea(int numero, int rentanumero) {
        this.lineaPK = new LineaPK(numero, rentanumero);
    }

    public LineaPK getLineaPK() {
        return lineaPK;
    }

    public void setLineaPK(LineaPK lineaPK) {
        this.lineaPK = lineaPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCarroid() {
        return carroid;
    }

    public void setCarroid(Integer carroid) {
        this.carroid = carroid;
    }

    public Carro getCarroRentado() {
        return carroRentado;
    }

    public void setCarroRentado(Carro carroRentado) {
        this.carroRentado = carroRentado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineaPK != null ? lineaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linea)) {
            return false;
        }
        Linea other = (Linea) object;
        if ((this.lineaPK == null && other.lineaPK != null) || (this.lineaPK != null && !this.lineaPK.equals(other.lineaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Linea[ lineaPK=" + lineaPK + " ]";
    }
    
}
