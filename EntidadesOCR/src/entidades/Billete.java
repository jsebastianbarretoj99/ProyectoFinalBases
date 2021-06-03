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
@Table(name = "BILLETE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billete.findAll", query = "SELECT b FROM Billete b"),
    @NamedQuery(name = "Billete.findById", query = "SELECT b FROM Billete b WHERE b.id = :id"),
    @NamedQuery(name = "Billete.findByCantidad", query = "SELECT b FROM Billete b WHERE b.cantidad = :cantidad"),
    @NamedQuery(name = "Billete.findByDenominacion", query = "SELECT b FROM Billete b WHERE b.denominacion = :denominacion")})
public class Billete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "DENOMINACION")
    private int denominacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billete")
    private Collection<Billetesxrenta> billetesxrentaCollection;

    public Billete() {
    }

    public Billete(Integer id) {
        this.id = id;
    }

    public Billete(Integer id, int cantidad, int denominacion) {
        this.id = id;
        this.cantidad = cantidad;
        this.denominacion = denominacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(int denominacion) {
        this.denominacion = denominacion;
    }

    @XmlTransient
    public Collection<Billetesxrenta> getBilletesxrentaCollection() {
        return billetesxrentaCollection;
    }

    public void setBilletesxrentaCollection(Collection<Billetesxrenta> billetesxrentaCollection) {
        this.billetesxrentaCollection = billetesxrentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billete)) {
            return false;
        }
        Billete other = (Billete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Billete[ id=" + id + " ]";
    }
    
}
