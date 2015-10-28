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
public class FacturaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cajero")
    private String cajero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_caja")
    @Temporal(TemporalType.DATE)
    private Date fechaCaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codigo_caja")
    private String codigoCaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_caja")
    private String nombreCaja;

    public FacturaPK() {
    }

    public FacturaPK(int id, String cajero, Date fechaCaja, String codigoCaja, String nombreCaja) {
        this.id = id;
        this.cajero = cajero;
        this.fechaCaja = fechaCaja;
        this.codigoCaja = codigoCaja;
        this.nombreCaja = nombreCaja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public Date getFechaCaja() {
        return fechaCaja;
    }

    public void setFechaCaja(Date fechaCaja) {
        this.fechaCaja = fechaCaja;
    }

    public String getCodigoCaja() {
        return codigoCaja;
    }

    public void setCodigoCaja(String codigoCaja) {
        this.codigoCaja = codigoCaja;
    }

    public String getNombreCaja() {
        return nombreCaja;
    }

    public void setNombreCaja(String nombreCaja) {
        this.nombreCaja = nombreCaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (cajero != null ? cajero.hashCode() : 0);
        hash += (fechaCaja != null ? fechaCaja.hashCode() : 0);
        hash += (codigoCaja != null ? codigoCaja.hashCode() : 0);
        hash += (nombreCaja != null ? nombreCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaPK)) {
            return false;
        }
        FacturaPK other = (FacturaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.cajero == null && other.cajero != null) || (this.cajero != null && !this.cajero.equals(other.cajero))) {
            return false;
        }
        if ((this.fechaCaja == null && other.fechaCaja != null) || (this.fechaCaja != null && !this.fechaCaja.equals(other.fechaCaja))) {
            return false;
        }
        if ((this.codigoCaja == null && other.codigoCaja != null) || (this.codigoCaja != null && !this.codigoCaja.equals(other.codigoCaja))) {
            return false;
        }
        if ((this.nombreCaja == null && other.nombreCaja != null) || (this.nombreCaja != null && !this.nombreCaja.equals(other.nombreCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FacturaPK[ id=" + id + ", cajero=" + cajero + ", fechaCaja=" + fechaCaja + ", codigoCaja=" + codigoCaja + ", nombreCaja=" + nombreCaja + " ]";
    }
    
}
