/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author juansebastianbarretojimenez
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
    private Carro carroid;
    @JoinColumn(name = "RENTANUMERO", referencedColumnName = "NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Renta renta;

    public Linea() {
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

    public Carro getCarroid() {
        return carroid;
    }

    public void setCarroid(Carro carroid) {
        this.carroid = carroid;
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