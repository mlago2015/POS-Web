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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "detalle_factura", catalog = "facturacion", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByUserCreate", query = "SELECT d FROM DetalleFactura d WHERE d.userCreate = :userCreate"),
    @NamedQuery(name = "DetalleFactura.findByUserModify", query = "SELECT d FROM DetalleFactura d WHERE d.userModify = :userModify"),
    @NamedQuery(name = "DetalleFactura.findByDateCreate", query = "SELECT d FROM DetalleFactura d WHERE d.dateCreate = :dateCreate"),
    @NamedQuery(name = "DetalleFactura.findByDateModify", query = "SELECT d FROM DetalleFactura d WHERE d.dateModify = :dateModify"),
    @NamedQuery(name = "DetalleFactura.findById", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.id = :id"),
    @NamedQuery(name = "DetalleFactura.findByFacturaId", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.facturaId = :facturaId"),
    @NamedQuery(name = "DetalleFactura.findByCodigo", query = "SELECT d FROM DetalleFactura d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "DetalleFactura.findByBarra", query = "SELECT d FROM DetalleFactura d WHERE d.barra = :barra"),
    @NamedQuery(name = "DetalleFactura.findByNombre", query = "SELECT d FROM DetalleFactura d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DetalleFactura.findByDescripcion", query = "SELECT d FROM DetalleFactura d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFactura.findByPrecioVenta", query = "SELECT d FROM DetalleFactura d WHERE d.precioVenta = :precioVenta"),
    @NamedQuery(name = "DetalleFactura.findByPorcentajeDescuento", query = "SELECT d FROM DetalleFactura d WHERE d.porcentajeDescuento = :porcentajeDescuento"),
    @NamedQuery(name = "DetalleFactura.findByImpuesto", query = "SELECT d FROM DetalleFactura d WHERE d.impuesto = :impuesto"),
    @NamedQuery(name = "DetalleFactura.findByCajero", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.cajero = :cajero"),
    @NamedQuery(name = "DetalleFactura.findByFechaCaja", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.fechaCaja = :fechaCaja"),
    @NamedQuery(name = "DetalleFactura.findByCodigoCaja", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.codigoCaja = :codigoCaja"),
    @NamedQuery(name = "DetalleFactura.findByNombreCaja", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.nombreCaja = :nombreCaja")})
public class DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleFacturaPK detalleFacturaPK;
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
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "barra")
    private String barra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_descuento")
    private Double porcentajeDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuesto")
    private double impuesto;
    @JoinColumns({
        @JoinColumn(name = "factura_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "fecha_caja", referencedColumnName = "fecha_caja", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_caja", referencedColumnName = "codigo_caja", insertable = false, updatable = false),
        @JoinColumn(name = "nombre_caja", referencedColumnName = "nombre_caja", insertable = false, updatable = false),
        @JoinColumn(name = "cajero", referencedColumnName = "cajero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Factura factura;

    public DetalleFactura() {
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK, String userCreate, Date dateCreate, String codigo, String barra, String nombre, double cantidad, double precioVenta, double impuesto) {
        this.detalleFacturaPK = detalleFacturaPK;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.codigo = codigo;
        this.barra = barra;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.impuesto = impuesto;
    }

    public DetalleFactura(int id, int facturaId, String cajero, Date fechaCaja, String codigoCaja, String nombreCaja) {
        this.detalleFacturaPK = new DetalleFacturaPK(id, facturaId, cajero, fechaCaja, codigoCaja, nombreCaja);
    }

    public DetalleFacturaPK getDetalleFacturaPK() {
        return detalleFacturaPK;
    }

    public void setDetalleFacturaPK(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleFacturaPK != null ? detalleFacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.detalleFacturaPK == null && other.detalleFacturaPK != null) || (this.detalleFacturaPK != null && !this.detalleFacturaPK.equals(other.detalleFacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetalleFactura[ detalleFacturaPK=" + detalleFacturaPK + " ]";
    }
    
}
