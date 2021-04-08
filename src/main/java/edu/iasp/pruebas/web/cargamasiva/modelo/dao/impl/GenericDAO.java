/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iasp.pruebas.web.cargamasiva.modelo.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ismael
 */
public abstract class GenericDAO<T,K> {
    
    @PersistenceContext(unitName = "cargamasiva_PU")
    protected EntityManager em;
    private Class<T> classs;

    public GenericDAO(Class<T> classs) {
        this.classs = classs;
    }
    
    public List<T> findAll(){
        //Usuario.findAll
        return em.createNamedQuery(classs.getSimpleName() + ".findAll", classs)
                .getResultList();
        
    }
    
    public T findById(K id){
        return em.find(classs, id);
    }
    
    public void register(T obj){
        em.persist(obj);
    }
    
    public void register(List<T> objs){
        objs.forEach(obj -> em.persist(obj));
    }
    
}
