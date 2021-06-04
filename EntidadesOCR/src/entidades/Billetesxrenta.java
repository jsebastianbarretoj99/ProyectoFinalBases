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
@Table(name = "BILLETESXRENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billetesxrenta.findAll", query = "SELECT b FROM Billetesxrenta b"),
    @NamedQuery(name = "Billetesxrenta.findByRentanumero", query = "SELECT b FROM Billetesxrenta b WHERE b.billetesxrentaPK.rentanumero = :rentanumero"),
    @NamedQuery(name = "Billetesxrenta.findByBilleteid", query = "SELECT b FROM Billetesxrenta b WHERE b.billetesxrentaPK.billeteid = :billeteid"),
    @NamedQuery(name = "Billetesxrenta.findByCantidad", query = "SELECT b FROM Billetesxrenta b WHERE b.cantidad = :cantidad")})
public class Billetesxrenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BilletesxrentaPK billetesxrentaPK;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @JoinColumn(name = "BILLETEID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Billete billete;
    @JoinColumn(name = "RENTANUMERO", referencedColumnName = "NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Renta renta;

    public Billetesxrenta() {
    }

    public Billetesxrenta(BilletesxrentaPK billetesxrentaPK) {
        this.billetesxrentaPK = billetesxrentaPK;
    }

    public Billetesxrenta(BilletesxrentaPK billetesxrentaPK, int cantidad) {
        this.billetesxrentaPK = billetesxrentaPK;
        this.cantidad = cantidad;
    }

    public Billetesxrenta(int rentanumero, int billeteid) {
        this.billetesxrentaPK = new BilletesxrentaPK(rentanumero, billeteid);
    }

    public BilletesxrentaPK getBilletesxrentaPK() {
        return billetesxrentaPK;
    }

    public void setBilletesxrentaPK(BilletesxrentaPK billetesxrentaPK) {
        this.billetesxrentaPK = billetesxrentaPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Billete getBillete() {
        return billete;
    }

    public void setBillete(Billete billete) {
        this.billete = billete;
    }

    public Renta getRenta() {
        return renta;
    }

    public void setRenta(Renta renta) {
        this.renta = renta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billetesxrentaPK != null ? billetesxrentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billetesxrenta)) {
            return false;
        }
        Billetesxrenta other = (Billetesxrenta) object;
        if ((this.billetesxrentaPK == null && other.billetesxrentaPK != null) || (this.billetesxrentaPK != null && !this.billetesxrentaPK.equals(other.billetesxrentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Billetesxrenta[ billetesxrentaPK=" + billetesxrentaPK + " ]";
    }
    
}
