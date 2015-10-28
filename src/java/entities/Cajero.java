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
@Table(name = "cajero", catalog = "facturacion", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cajero.findAll", query = "SELECT c FROM Cajero c"),
    @NamedQuery(name = "Cajero.findByUserCreate", query = "SELECT c FROM Cajero c WHERE c.userCreate = :userCreate"),
    @NamedQuery(name = "Cajero.findByUserModify", query = "SELECT c FROM Cajero c WHERE c.userModify = :userModify"),
    @NamedQuery(name = "Cajero.findByDateCreate", query = "SELECT c FROM Cajero c WHERE c.dateCreate = :dateCreate"),
    @NamedQuery(name = "Cajero.findByDateModify", query = "SELECT c FROM Cajero c WHERE c.dateModify = :dateModify"),
    @NamedQuery(name = "Cajero.findById", query = "SELECT c FROM Cajero c WHERE c.id = :id"),
    @NamedQuery(name = "Cajero.findByNombre", query = "SELECT c FROM Cajero c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cajero.findByInicioSesion", query = "SELECT c FROM Cajero c WHERE c.inicioSesion = :inicioSesion"),
    @NamedQuery(name = "Cajero.findByFinSesion", query = "SELECT c FROM Cajero c WHERE c.finSesion = :finSesion"),
    @NamedQuery(name = "Cajero.findByFechaCaja", query = "SELECT c FROM Cajero c WHERE c.fechaCaja = :fechaCaja"),
    @NamedQuery(name = "Cajero.findByCodigoCaja", query = "SELECT c FROM Cajero c WHERE c.codigoCaja = :codigoCaja"),
    @NamedQuery(name = "Cajero.findByNombreCaja", query = "SELECT c FROM Cajero c WHERE c.nombreCaja = :nombreCaja")})
public class Cajero implements Serializable {
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
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio_sesion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioSesion;
    @Column(name = "fin_sesion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finSesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_caja")
    @Temporal(TemporalType.DATE)
    private Date fechaCaja;
    @Size(max = 255)
    @Column(name = "codigo_caja")
    private String codigoCaja;
    @Size(max = 255)
    @Column(name = "nombre_caja")
    private String nombreCaja;

    public Cajero() {
    }

    public Cajero(Integer id) {
        this.id = id;
    }

    public Cajero(Integer id, String userCreate, Date dateCreate, String nombre, Date inicioSesion, Date fechaCaja) {
        this.id = id;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
        this.nombre = nombre;
        this.inicioSesion = inicioSesion;
        this.fechaCaja = fechaCaja;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getInicioSesion() {
        return inicioSesion;
    }

    public void setInicioSesion(Date inicioSesion) {
        this.inicioSesion = inicioSesion;
    }

    public Date getFinSesion() {
        return finSesion;
    }

    public void setFinSesion(Date finSesion) {
        this.finSesion = finSesion;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cajero)) {
            return false;
        }
        Cajero other = (Cajero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cajero[ id=" + id + " ]";
    }
    
}
