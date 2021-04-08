/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iasp.pruebas.web.cargamasiva.modelo.dao;

import java.util.List;

/**
 *
 * @author ismael
 */
public interface DAO<T,K> {
    
    List<T> findAll();
    
    T findById(K id);
    
    void register(T obj);
    
    void register(List<T> obj);
}
