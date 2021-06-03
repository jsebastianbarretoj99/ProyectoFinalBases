/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author juansebastianbarretojimenez
 */
@Embeddable
public class BilletesxrentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "RENTANUMERO")
    private int rentanumero;
    @Basic(optional = false)
    @Column(name = "BILLETEID")
    private int billeteid;

    public BilletesxrentaPK() {
    }

    public BilletesxrentaPK(int rentanumero, int billeteid) {
        this.rentanumero = rentanumero;
        this.billeteid = billeteid;
    }

    public int getRentanumero() {
        return rentanumero;
    }

    public void setRentanumero(int rentanumero) {
        this.rentanumero = rentanumero;
    }

    public int getBilleteid() {
        return billeteid;
    }

    public void setBilleteid(int billeteid) {
        this.billeteid = billeteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rentanumero;
        hash += (int) billeteid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BilletesxrentaPK)) {
            return false;
        }
        BilletesxrentaPK other = (BilletesxrentaPK) object;
        if (this.rentanumero != other.rentanumero) {
            return false;
        }
        if (this.billeteid != other.billeteid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.BilletesxrentaPK[ rentanumero=" + rentanumero + ", billeteid=" + billeteid + " ]";
    }
    
}
