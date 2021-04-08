/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iasp.pruebas.web.cargamasiva.modelo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ismael
 */
@Entity
@Table(name = "tbl_roles_has_tbl_operaciones")
@NamedQueries({
    @NamedQuery(name = "RolOperacion.findAll", query = "SELECT r FROM RolOperacion r"),
    @NamedQuery(name = "RolOperacion.findById", query = "SELECT r FROM RolOperacion r WHERE r.id = :id"),
    @NamedQuery(name = "RolOperacion.findByHabilitado", query = "SELECT r FROM RolOperacion r WHERE r.habilitado = :habilitado")})
public class RolOperacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "habilitado")
    private Short habilitado;
    @JoinColumn(name = "tbl_operacion_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operacion tblOperacionId;
    @JoinColumn(name = "tbl_rol_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rol tblRolId;

    public RolOperacion() {
    }

    public RolOperacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Short habilitado) {
        this.habilitado = habilitado;
    }

    public Operacion getTblOperacionId() {
        return tblOperacionId;
    }

    public void setTblOperacionId(Operacion tblOperacionId) {
        this.tblOperacionId = tblOperacionId;
    }

    public Rol getTblRolId() {
        return tblRolId;
    }

    public void setTblRolId(Rol tblRolId) {
        this.tblRolId = tblRolId;
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
        if (!(object instanceof RolOperacion)) {
            return false;
        }
        RolOperacion other = (RolOperacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.iasp.pruebas.web.cargamasiva.modelo.entities.RolOperacion[ id=" + id + " ]";
    }
    
}
