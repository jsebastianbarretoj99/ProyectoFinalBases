/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juansebastianbarretojimenez
 */
@Entity
@Table(name = "RENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Renta.findAll", query = "SELECT r FROM Renta r"),
    @NamedQuery(name = "Renta.findByNumero", query = "SELECT r FROM Renta r WHERE r.numero = :numero")})
public class Renta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private Integer numero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "renta")
    private Collection<Billetesxrenta> billetesxrentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "renta")
    private Collection<Linea> lineaCollection;
    @JoinColumn(name = "PARAMETROID", referencedColumnName = "ID")
    @ManyToOne
    private Parametro parametroid;
    @JoinColumn(name = "PERIODOID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Periodo periodoid;

    public Renta() {
    }

    public Renta(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @XmlTransient
    public Collection<Billetesxrenta> getBilletesxrentaCollection() {
        return billetesxrentaCollection;
    }

    public void setBilletesxrentaCollection(Collection<Billetesxrenta> billetesxrentaCollection) {
        this.billetesxrentaCollection = billetesxrentaCollection;
    }

    @XmlTransient
    public Collection<Linea> getLineaCollection() {
        return lineaCollection;
    }

    public void setLineaCollection(Collection<Linea> lineaCollection) {
        this.lineaCollection = lineaCollection;
    }

    public Parametro getParametroid() {
        return parametroid;
    }

    public void setParametroid(Parametro parametroid) {
        this.parametroid = parametroid;
    }

    public Periodo getPeriodoid() {
        return periodoid;
    }

    public void setPeriodoid(Periodo periodoid) {
        this.periodoid = periodoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Renta)) {
            return false;
        }
        Renta other = (Renta) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Renta[ numero=" + numero + " ]";
    }
    
}
