/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iasp.pruebas.web.cargamasiva.modelo.dao;

import edu.iasp.pruebas.web.cargamasiva.modelo.entities.Usuario;
import javax.ejb.Local;

/**
 *
 * @author ismael
 */
@Local
public interface UsuarioDAO extends DAO<Usuario, Long>{
    
}
