/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iasp.pruebas.web.cargamasiva.modelo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ismael
 */
@Entity
@Table(name = "tbl_operaciones")
@NamedQueries({
    @NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o"),
    @NamedQuery(name = "Operacion.findById", query = "SELECT o FROM Operacion o WHERE o.id = :id"),
    @NamedQuery(name = "Operacion.findByNombre", query = "SELECT o FROM Operacion o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "Operacion.findByIcono", query = "SELECT o FROM Operacion o WHERE o.icono = :icono")})
public class Operacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "icono")
    private String icono;
    @Lob
    @Size(max = 65535)
    @Column(name = "link")
    private String link;
    @JoinTable(name = "tbl_roles_has_tbl_operaciones1", joinColumns = {
        @JoinColumn(name = "tbl_operaciones_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tbl_roles_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Rol> rolList;
    @OneToMany(mappedBy = "tblOperacionSuperiorId")
    private List<Operacion> operacionList;
    @JoinColumn(name = "tbl_operacion_superior_id", referencedColumnName = "id")
    @ManyToOne
    private Operacion tblOperacionSuperiorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOperacionId")
    private List<RolOperacion> rolOperacionList;

    public Operacion() {
    }

    public Operacion(Integer id) {
        this.id = id;
    }

    public Operacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public List<Operacion> getOperacionList() {
        return operacionList;
    }

    public void setOperacionList(List<Operacion> operacionList) {
        this.operacionList = operacionList;
    }

    public Operacion getTblOperacionSuperiorId() {
        return tblOperacionSuperiorId;
    }

    public void setTblOperacionSuperiorId(Operacion tblOperacionSuperiorId) {
        this.tblOperacionSuperiorId = tblOperacionSuperiorId;
    }

    public List<RolOperacion> getRolOperacionList() {
        return rolOperacionList;
    }

    public void setRolOperacionList(List<RolOperacion> rolOperacionList) {
        this.rolOperacionList = rolOperacionList;
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
        if (!(object instanceof Operacion)) {
            return false;
        }
        Operacion other = (Operacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.iasp.pruebas.web.cargamasiva.modelo.entities.Operacion[ id=" + id + " ]";
    }
    
}
