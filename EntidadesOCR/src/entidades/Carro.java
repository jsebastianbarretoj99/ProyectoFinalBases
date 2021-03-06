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
@Table(name = "CARRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c"),
    @NamedQuery(name = "Carro.findById", query = "SELECT c FROM Carro c WHERE c.id = :id"),
    @NamedQuery(name = "Carro.findByPlaca", query = "SELECT c FROM Carro c WHERE c.placa = :placa"),
    @NamedQuery(name = "Carro.findByUnidadesdisponibles", query = "SELECT c FROM Carro c WHERE c.unidadesdisponibles = :unidadesdisponibles"),
    @NamedQuery(name = "Carro.findByPrecio", query = "SELECT c FROM Carro c WHERE c.precio = :precio"),
    @NamedQuery(name = "Carro.findByPuestos", query = "SELECT c FROM Carro c WHERE c.puestos = :puestos")})
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PLACA")
    private String placa;
    @Basic(optional = false)
    @Column(name = "UNIDADESDISPONIBLES")
    private int unidadesdisponibles;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private int precio;
    @Basic(optional = false)
    @Column(name = "PUESTOS")
    private int puestos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carroid")
    private Collection<Linea> lineaCollection;

    public Carro() {
    }

    public Carro(Integer id) {
        this.id = id;
    }

    public Carro(Integer id, String placa, int unidadesdisponibles, int precio, int puestos) {
        this.id = id;
        this.placa = placa;
        this.unidadesdisponibles = unidadesdisponibles;
        this.precio = precio;
        this.puestos = puestos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getUnidadesdisponibles() {
        return unidadesdisponibles;
    }

    public void setUnidadesdisponibles(int unidadesdisponibles) {
        this.unidadesdisponibles = unidadesdisponibles;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPuestos() {
        return puestos;
    }

    public void setPuestos(int puestos) {
        this.puestos = puestos;
    }

    @XmlTransient
    public Collection<Linea> getLineaCollection() {
        return lineaCollection;
    }

    public void setLineaCollection(Collection<Linea> lineaCollection) {
        this.lineaCollection = lineaCollection;
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
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " Puestos: " + Integer.toString(puestos);
    }
    
}
