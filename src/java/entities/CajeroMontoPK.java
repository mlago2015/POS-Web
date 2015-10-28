/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mlago
 */
@Embeddable
public class CajeroMontoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cajero")
    private String cajero;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_caja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaja;

    public CajeroMontoPK() {
    }

    public CajeroMontoPK(String cajero, int id, Date fechaCaja) {
        this.cajero = cajero;
        this.id = id;
        this.fechaCaja = fechaCaja;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCaja() {
        return fechaCaja;
    }

    public void setFechaCaja(Date fechaCaja) {
        this.fechaCaja = fechaCaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajero != null ? cajero.hashCode() : 0);
        hash += (int) id;
        hash += (fechaCaja != null ? fechaCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajeroMontoPK)) {
            return false;
        }
        CajeroMontoPK other = (CajeroMontoPK) object;
        if ((this.cajero == null && other.cajero != null) || (this.cajero != null && !this.cajero.equals(other.cajero))) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if ((this.fechaCaja == null && other.fechaCaja != null) || (this.fechaCaja != null && !this.fechaCaja.equals(other.fechaCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CajeroMontoPK[ cajero=" + cajero + ", id=" + id + ", fechaCaja=" + fechaCaja + " ]";
    }
    
}
