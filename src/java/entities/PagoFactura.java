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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pago_factura", catalog = "facturacion", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoFactura.findAll", query = "SELECT p FROM PagoFactura p"),
    @NamedQuery(name = "PagoFactura.findByUserCreate", query = "SELECT p FROM PagoFactura p WHERE p.userCreate = :userCreate"),
    @NamedQuery(name = "PagoFactura.findByUserModify", query = "SELECT p FROM PagoFactura p WHERE p.userModify = :userModify"),
    @NamedQuery(name = "PagoFactura.findByDateCreate", query = "SELECT p FROM PagoFactura p WHERE p.dateCreate = :dateCreate"),
    @NamedQuery(name = "PagoFactura.findByDateModify", query = "SELECT p FROM PagoFactura p WHERE p.dateModify = :dateModify"),
    @NamedQuery(name = "PagoFactura.findById", query = "SELECT p FROM PagoFactura p WHERE p.id = :id"),
    @NamedQuery(name = "PagoFactura.findByFacturaId", query = "SELECT p FROM PagoFactura p WHERE p.facturaId = :facturaId"),
    @NamedQuery(name = "PagoFactura.findByNombrePagador", query = "SELECT p FROM PagoFactura p WHERE p.nombrePagador = :nombrePagador"),
    @NamedQuery(name = "PagoFactura.findByDescripcionPago", query = "SELECT p FROM PagoFactura p WHERE p.descripcionPago = :descripcionPago"),
    @NamedQuery(name = "PagoFactura.findByFormaPagoCodigo", query = "SELECT p FROM PagoFactura p WHERE p.formaPagoCodigo = :formaPagoCodigo"),
    @NamedQuery(name = "PagoFactura.findByFormaPagoNombre", query = "SELECT p FROM PagoFactura p WHERE p.formaPagoNombre = :formaPagoNombre"),
    @NamedQuery(name = "PagoFactura.findByMontoPagado", query = "SELECT p FROM PagoFactura p WHERE p.montoPagado = :montoPagado")})
public class PagoFactura implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "factura_id")
    private int facturaId;
    @Size(max = 255)
    @Column(name = "nombre_pagador")
    private String nombrePagador;
    @Size(max = 500)
    @Column(name = "descripcion_pago")
    private String descripcionPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "forma_pago_codigo")
    private String formaPagoCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "forma_pago_nombre")
    private String formaPagoNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_pagado")
    private double montoPagado;

    public PagoFactura() {
    }

    public PagoFactura(Integer id) {
        this.id = id;
    }

    public PagoFactura(Integer id, String userCreate, Date dateCreate, int facturaId, String formaPagoCodigo, String formaPagoNombre, double montoPagado) {
        this.id = id;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.facturaId = facturaId;
        this.formaPagoCodigo = formaPagoCodigo;
        this.formaPagoNombre = formaPagoNombre;
        this.montoPagado = montoPagado;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(int facturaId) {
        this.facturaId = facturaId;
    }

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    public String getDescripcionPago() {
        return descripcionPago;
    }

    public void setDescripcionPago(String descripcionPago) {
        this.descripcionPago = descripcionPago;
    }

    public String getFormaPagoCodigo() {
        return formaPagoCodigo;
    }

    public void setFormaPagoCodigo(String formaPagoCodigo) {
        this.formaPagoCodigo = formaPagoCodigo;
    }

    public String getFormaPagoNombre() {
        return formaPagoNombre;
    }

    public void setFormaPagoNombre(String formaPagoNombre) {
        this.formaPagoNombre = formaPagoNombre;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
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
        if (!(object instanceof PagoFactura)) {
            return false;
        }
        PagoFactura other = (PagoFactura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PagoFactura[ id=" + id + " ]";
    }
    
}
