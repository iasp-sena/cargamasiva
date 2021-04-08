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
@Table(name = "tbl_usuarios_has_tbl_roles")
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u"),
    @NamedQuery(name = "UsuarioRol.findById", query = "SELECT u FROM UsuarioRol u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioRol.findByHabilitado", query = "SELECT u FROM UsuarioRol u WHERE u.habilitado = :habilitado")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "habilitado")
    private Short habilitado;
    @JoinColumn(name = "tbl_rol_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rol tblRolId;
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario tblUsuarioId;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer id) {
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

    public Rol getTblRolId() {
        return tblRolId;
    }

    public void setTblRolId(Rol tblRolId) {
        this.tblRolId = tblRolId;
    }

    public Usuario getTblUsuarioId() {
        return tblUsuarioId;
    }

    public void setTblUsuarioId(Usuario tblUsuarioId) {
        this.tblUsuarioId = tblUsuarioId;
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
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.iasp.pruebas.web.cargamasiva.modelo.entities.UsuarioRol[ id=" + id + " ]";
    }
    
}
