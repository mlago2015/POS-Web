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
@Table(name = "log_sys", catalog = "facturacion", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogSys.findAll", query = "SELECT l FROM LogSys l"),
    @NamedQuery(name = "LogSys.findById", query = "SELECT l FROM LogSys l WHERE l.id = :id"),
    @NamedQuery(name = "LogSys.findByUsuario", query = "SELECT l FROM LogSys l WHERE l.usuario = :usuario"),
    @NamedQuery(name = "LogSys.findByTabla", query = "SELECT l FROM LogSys l WHERE l.tabla = :tabla"),
    @NamedQuery(name = "LogSys.findByOperacion", query = "SELECT l FROM LogSys l WHERE l.operacion = :operacion"),
    @NamedQuery(name = "LogSys.findByObservacion", query = "SELECT l FROM LogSys l WHERE l.observacion = :observacion"),
    @NamedQuery(name = "LogSys.findByFecha", query = "SELECT l FROM LogSys l WHERE l.fecha = :fecha")})
public class LogSys implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tabla")
    private String tabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "operacion")
    private String operacion;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public LogSys() {
    }

    public LogSys(Integer id) {
        this.id = id;
    }

    public LogSys(Integer id, String usuario, String tabla, String operacion, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.tabla = tabla;
        this.operacion = operacion;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof LogSys)) {
            return false;
        }
        LogSys other = (LogSys) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LogSys[ id=" + id + " ]";
    }
    
}
