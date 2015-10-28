/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mlago
 */
@Entity
@Table(name = "factura", catalog = "facturacion", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByUserCreate", query = "SELECT f FROM Factura f WHERE f.userCreate = :userCreate"),
    @NamedQuery(name = "Factura.findByUserModify", query = "SELECT f FROM Factura f WHERE f.userModify = :userModify"),
    @NamedQuery(name = "Factura.findByDateCreate", query = "SELECT f FROM Factura f WHERE f.dateCreate = :dateCreate"),
    @NamedQuery(name = "Factura.findByDateModify", query = "SELECT f FROM Factura f WHERE f.dateModify = :dateModify"),
    @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.facturaPK.id = :id"),
    @NamedQuery(name = "Factura.findByNumeroFactura", query = "SELECT f FROM Factura f WHERE f.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "Factura.findByNumeroControl", query = "SELECT f FROM Factura f WHERE f.numeroControl = :numeroControl"),
    @NamedQuery(name = "Factura.findByFechaFactura", query = "SELECT f FROM Factura f WHERE f.fechaFactura = :fechaFactura"),
    @NamedQuery(name = "Factura.findByFormaPagoCodigo", query = "SELECT f FROM Factura f WHERE f.formaPagoCodigo = :formaPagoCodigo"),
    @NamedQuery(name = "Factura.findByFormaPagoNombre", query = "SELECT f FROM Factura f WHERE f.formaPagoNombre = :formaPagoNombre"),
    @NamedQuery(name = "Factura.findByFormaPagoDescripcion", query = "SELECT f FROM Factura f WHERE f.formaPagoDescripcion = :formaPagoDescripcion"),
    @NamedQuery(name = "Factura.findByFormaPagoValor", query = "SELECT f FROM Factura f WHERE f.formaPagoValor = :formaPagoValor"),
    @NamedQuery(name = "Factura.findByFechaVencimiento", query = "SELECT f FROM Factura f WHERE f.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Factura.findByRifCedula", query = "SELECT f FROM Factura f WHERE f.rifCedula = :rifCedula"),
    @NamedQuery(name = "Factura.findByNombreCliente", query = "SELECT f FROM Factura f WHERE f.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Factura.findByDireccionCliente", query = "SELECT f FROM Factura f WHERE f.direccionCliente = :direccionCliente"),
    @NamedQuery(name = "Factura.findByTelefonoCliente", query = "SELECT f FROM Factura f WHERE f.telefonoCliente = :telefonoCliente"),
    @NamedQuery(name = "Factura.findByDescuentoGeneral", query = "SELECT f FROM Factura f WHERE f.descuentoGeneral = :descuentoGeneral"),
    @NamedQuery(name = "Factura.findByCajero", query = "SELECT f FROM Factura f WHERE f.facturaPK.cajero = :cajero"),
    @NamedQuery(name = "Factura.findByFechaCaja", query = "SELECT f FROM Factura f WHERE f.facturaPK.fechaCaja = :fechaCaja"),
    @NamedQuery(name = "Factura.findByCodigoCaja", query = "SELECT f FROM Factura f WHERE f.facturaPK.codigoCaja = :codigoCaja"),
    @NamedQuery(name = "Factura.findByNombreCaja", query = "SELECT f FROM Factura f WHERE f.facturaPK.nombreCaja = :nombreCaja")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturaPK facturaPK;
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
    @Column(name = "numero_factura")
    private int numeroFactura;
    @Size(max = 255)
    @Column(name = "numero_control")
    private String numeroControl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_factura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;
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
    @Size(min = 1, max = 255)
    @Column(name = "forma_pago_descripcion")
    private String formaPagoDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forma_pago_valor")
    private int formaPagoValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "rif_cedula")
    private String rifCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Size(max = 500)
    @Column(name = "direccion_cliente")
    private String direccionCliente;
    @Size(max = 500)
    @Column(name = "telefono_cliente")
    private String telefonoCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento_general")
    private Double descuentoGeneral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Collection<DetalleFactura> detalleFacturaCollection;

    public Factura() {
    }

    public Factura(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
    }

    public Factura(FacturaPK facturaPK, String userCreate, Date dateCreate, int numeroFactura, Date fechaFactura, String formaPagoCodigo, String formaPagoNombre, String formaPagoDescripcion, int formaPagoValor, Date fechaVencimiento, String rifCedula, String nombreCliente) {
        this.facturaPK = facturaPK;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.numeroFactura = numeroFactura;
        this.fechaFactura = fechaFactura;
        this.formaPagoCodigo = formaPagoCodigo;
        this.formaPagoNombre = formaPagoNombre;
        this.formaPagoDescripcion = formaPagoDescripcion;
        this.formaPagoValor = formaPagoValor;
        this.fechaVencimiento = fechaVencimiento;
        this.rifCedula = rifCedula;
        this.nombreCliente = nombreCliente;
    }

    public Factura(int id, String cajero, Date fechaCaja, String codigoCaja, String nombreCaja) {
        this.facturaPK = new FacturaPK(id, cajero, fechaCaja, codigoCaja, nombreCaja);
    }

    public FacturaPK getFacturaPK() {
        return facturaPK;
    }

    public void setFacturaPK(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
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

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
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

    public String getFormaPagoDescripcion() {
        return formaPagoDescripcion;
    }

    public void setFormaPagoDescripcion(String formaPagoDescripcion) {
        this.formaPagoDescripcion = formaPagoDescripcion;
    }

    public int getFormaPagoValor() {
        return formaPagoValor;
    }

    public void setFormaPagoValor(int formaPagoValor) {
        this.formaPagoValor = formaPagoValor;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getRifCedula() {
        return rifCedula;
    }

    public void setRifCedula(String rifCedula) {
        this.rifCedula = rifCedula;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public Double getDescuentoGeneral() {
        return descuentoGeneral;
    }

    public void setDescuentoGeneral(Double descuentoGeneral) {
        this.descuentoGeneral = descuentoGeneral;
    }

    @XmlTransient
    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaPK != null ? facturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facturaPK == null && other.facturaPK != null) || (this.facturaPK != null && !this.facturaPK.equals(other.facturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Factura[ facturaPK=" + facturaPK + " ]";
    }
    
}
