/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iasp.pruebas.web.cargamasiva.modelo.dao.impl;

import edu.iasp.pruebas.web.cargamasiva.modelo.dao.UsuarioDAO;
import edu.iasp.pruebas.web.cargamasiva.modelo.entities.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author ismael
 */
@Stateless
public class UsuarioDAOJPA extends GenericDAO<Usuario, Long> implements UsuarioDAO{
    
    public UsuarioDAOJPA(){
        super(Usuario.class);
    }
    
}
