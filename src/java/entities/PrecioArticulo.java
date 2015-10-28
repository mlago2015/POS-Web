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
@Table(name = "precio_articulo", catalog = "facturacion", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioArticulo.findAll", query = "SELECT p FROM PrecioArticulo p"),
    @NamedQuery(name = "PrecioArticulo.findByUserCreate", query = "SELECT p FROM PrecioArticulo p WHERE p.userCreate = :userCreate"),
    @NamedQuery(name = "PrecioArticulo.findByUserModify", query = "SELECT p FROM PrecioArticulo p WHERE p.userModify = :userModify"),
    @NamedQuery(name = "PrecioArticulo.findByDateCreate", query = "SELECT p FROM PrecioArticulo p WHERE p.dateCreate = :dateCreate"),
    @NamedQuery(name = "PrecioArticulo.findByDateModify", query = "SELECT p FROM PrecioArticulo p WHERE p.dateModify = :dateModify"),
    @NamedQuery(name = "PrecioArticulo.findById", query = "SELECT p FROM PrecioArticulo p WHERE p.precioArticuloPK.id = :id"),
    @NamedQuery(name = "PrecioArticulo.findByArticuloId", query = "SELECT p FROM PrecioArticulo p WHERE p.precioArticuloPK.articuloId = :articuloId"),
    @NamedQuery(name = "PrecioArticulo.findByCodigo", query = "SELECT p FROM PrecioArticulo p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "PrecioArticulo.findByDescripcion", query = "SELECT p FROM PrecioArticulo p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PrecioArticulo.findByCosto", query = "SELECT p FROM PrecioArticulo p WHERE p.costo = :costo"),
    @NamedQuery(name = "PrecioArticulo.findByPorcentajeGanaciaMax", query = "SELECT p FROM PrecioArticulo p WHERE p.porcentajeGanaciaMax = :porcentajeGanaciaMax"),
    @NamedQuery(name = "PrecioArticulo.findByPorcentajeGanaciaMin", query = "SELECT p FROM PrecioArticulo p WHERE p.porcentajeGanaciaMin = :porcentajeGanaciaMin"),
    @NamedQuery(name = "PrecioArticulo.findByPrecioVenta", query = "SELECT p FROM PrecioArticulo p WHERE p.precioVenta = :precioVenta"),
    @NamedQuery(name = "PrecioArticulo.findByTieneDescuento", query = "SELECT p FROM PrecioArticulo p WHERE p.tieneDescuento = :tieneDescuento"),
    @NamedQuery(name = "PrecioArticulo.findByPorcentajeDescuentoMax", query = "SELECT p FROM PrecioArticulo p WHERE p.porcentajeDescuentoMax = :porcentajeDescuentoMax"),
    @NamedQuery(name = "PrecioArticulo.findByPorcentajeDescuentoMin", query = "SELECT p FROM PrecioArticulo p WHERE p.porcentajeDescuentoMin = :porcentajeDescuentoMin")})
public class PrecioArticulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrecioArticuloPK precioArticuloPK;
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
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_ganacia_max")
    private double porcentajeGanaciaMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_ganacia_min")
    private double porcentajeGanaciaMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta;
    @Column(name = "tiene_descuento")
    private Boolean tieneDescuento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_descuento_max")
    private Double porcentajeDescuentoMax;
    @Column(name = "porcentaje_descuento_min")
    private Double porcentajeDescuentoMin;
    @JoinColumn(name = "articulo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulo articulo;

    public PrecioArticulo() {
    }

    public PrecioArticulo(PrecioArticuloPK precioArticuloPK) {
        this.precioArticuloPK = precioArticuloPK;
    }

    public PrecioArticulo(PrecioArticuloPK precioArticuloPK, String userCreate, Date dateCreate, String codigo, String descripcion, double costo, double porcentajeGanaciaMax, double porcentajeGanaciaMin, double precioVenta) {
        this.precioArticuloPK = precioArticuloPK;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.porcentajeGanaciaMax = porcentajeGanaciaMax;
        this.porcentajeGanaciaMin = porcentajeGanaciaMin;
        this.precioVenta = precioVenta;
    }

    public PrecioArticulo(int id, int articuloId) {
        this.precioArticuloPK = new PrecioArticuloPK(id, articuloId);
    }

    public PrecioArticuloPK getPrecioArticuloPK() {
        return precioArticuloPK;
    }

    public void setPrecioArticuloPK(PrecioArticuloPK precioArticuloPK) {
        this.precioArticuloPK = precioArticuloPK;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPorcentajeGanaciaMax() {
        return porcentajeGanaciaMax;
    }

    public void setPorcentajeGanaciaMax(double porcentajeGanaciaMax) {
        this.porcentajeGanaciaMax = porcentajeGanaciaMax;
    }

    public double getPorcentajeGanaciaMin() {
        return porcentajeGanaciaMin;
    }

    public void setPorcentajeGanaciaMin(double porcentajeGanaciaMin) {
        this.porcentajeGanaciaMin = porcentajeGanaciaMin;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Boolean getTieneDescuento() {
        return tieneDescuento;
    }

    public void setTieneDescuento(Boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }

    public Double getPorcentajeDescuentoMax() {
        return porcentajeDescuentoMax;
    }

    public void setPorcentajeDescuentoMax(Double porcentajeDescuentoMax) {
        this.porcentajeDescuentoMax = porcentajeDescuentoMax;
    }

    public Double getPorcentajeDescuentoMin() {
        return porcentajeDescuentoMin;
    }

    public void setPorcentajeDescuentoMin(Double porcentajeDescuentoMin) {
        this.porcentajeDescuentoMin = porcentajeDescuentoMin;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (precioArticuloPK != null ? precioArticuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioArticulo)) {
            return false;
        }
        PrecioArticulo other = (PrecioArticulo) object;
        if ((this.precioArticuloPK == null && other.precioArticuloPK != null) || (this.precioArticuloPK != null && !this.precioArticuloPK.equals(other.precioArticuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PrecioArticulo[ precioArticuloPK=" + precioArticuloPK + " ]";
    }
    
}
