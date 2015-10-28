/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mlago
 */
@Embeddable
public class PrecioArticuloPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "articulo_id")
    private int articuloId;

    public PrecioArticuloPK() {
    }

    public PrecioArticuloPK(int id, int articuloId) {
        this.id = id;
        this.articuloId = articuloId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(int articuloId) {
        this.articuloId = articuloId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) articuloId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioArticuloPK)) {
            return false;
        }
        PrecioArticuloPK other = (PrecioArticuloPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.articuloId != other.articuloId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PrecioArticuloPK[ id=" + id + ", articuloId=" + articuloId + " ]";
    }
    
}
