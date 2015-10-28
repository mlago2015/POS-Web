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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mlago
 */
@Entity
@Table(name = "cajero_monto", catalog = "facturacion", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CajeroMonto.findAll", query = "SELECT c FROM CajeroMonto c"),
    @NamedQuery(name = "CajeroMonto.findByUserCreate", query = "SELECT c FROM CajeroMonto c WHERE c.userCreate = :userCreate"),
    @NamedQuery(name = "CajeroMonto.findByUserModify", query = "SELECT c FROM CajeroMonto c WHERE c.userModify = :userModify"),
    @NamedQuery(name = "CajeroMonto.findByDateCreate", query = "SELECT c FROM CajeroMonto c WHERE c.dateCreate = :dateCreate"),
    @NamedQuery(name = "CajeroMonto.findByDateModify", query = "SELECT c FROM CajeroMonto c WHERE c.dateModify = :dateModify"),
    @NamedQuery(name = "CajeroMonto.findByCajero", query = "SELECT c FROM CajeroMonto c WHERE c.cajeroMontoPK.cajero = :cajero"),
    @NamedQuery(name = "CajeroMonto.findById", query = "SELECT c FROM CajeroMonto c WHERE c.cajeroMontoPK.id = :id"),
    @NamedQuery(name = "CajeroMonto.findByFechaCaja", query = "SELECT c FROM CajeroMonto c WHERE c.cajeroMontoPK.fechaCaja = :fechaCaja"),
    @NamedQuery(name = "CajeroMonto.findByCodigoCaja", query = "SELECT c FROM CajeroMonto c WHERE c.codigoCaja = :codigoCaja"),
    @NamedQuery(name = "CajeroMonto.findByNombreCaja", query = "SELECT c FROM CajeroMonto c WHERE c.nombreCaja = :nombreCaja"),
    @NamedQuery(name = "CajeroMonto.findByCantidad", query = "SELECT c FROM CajeroMonto c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CajeroMonto.findByDenominacion", query = "SELECT c FROM CajeroMonto c WHERE c.denominacion = :denominacion")})
public class CajeroMonto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CajeroMontoPK cajeroMontoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_create")
    private String userCreate;
    @Size(max = 255)
    @Column(name = "user_modify")
    private String userModify;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Column(name = "date_modify")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModify;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "denominacion")
    private double denominacion;

    public CajeroMonto() {
    }

    public CajeroMonto(CajeroMontoPK cajeroMontoPK) {
        this.cajeroMontoPK = cajeroMontoPK;
    }

    public CajeroMonto(CajeroMontoPK cajeroMontoPK, String userCreate, Date dateCreate, String codigoCaja, String nombreCaja, int cantidad, double denominacion) {
        this.cajeroMontoPK = cajeroMontoPK;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.codigoCaja = codigoCaja;
        this.nombreCaja = nombreCaja;
        this.cantidad = cantidad;
        this.denominacion = denominacion;
    }

    public CajeroMonto(String cajero, int id, Date fechaCaja) {
        this.cajeroMontoPK = new CajeroMontoPK(cajero, id, fechaCaja);
    }

    public CajeroMontoPK getCajeroMontoPK() {
        return cajeroMontoPK;
    }

    public void setCajeroMontoPK(CajeroMontoPK cajeroMontoPK) {
        this.cajeroMontoPK = cajeroMontoPK;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getUserModify() {
        return userModify;
    }

    public void setUserModify(String userModify) {
        this.userModify = userModify;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(double denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajeroMontoPK != null ? cajeroMontoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajeroMonto)) {
            return false;
        }
        CajeroMonto other = (CajeroMonto) object;
        if ((this.cajeroMontoPK == null && other.cajeroMontoPK != null) || (this.cajeroMontoPK != null && !this.cajeroMontoPK.equals(other.cajeroMontoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CajeroMonto[ cajeroMontoPK=" + cajeroMontoPK + " ]";
    }
    
}
