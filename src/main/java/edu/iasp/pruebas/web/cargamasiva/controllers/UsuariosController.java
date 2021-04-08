/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iasp.pruebas.web.cargamasiva.controllers;

import edu.iasp.pruebas.web.cargamasiva.modelo.dao.UsuarioDAO;
import edu.iasp.pruebas.web.cargamasiva.modelo.dto.CargaDataErrorDTO;
import edu.iasp.pruebas.web.cargamasiva.modelo.dto.InfoCargaUsuarioDTO;
import edu.iasp.pruebas.web.cargamasiva.modelo.entities.Municipio;
import edu.iasp.pruebas.web.cargamasiva.modelo.entities.TipoDocumento;
import edu.iasp.pruebas.web.cargamasiva.modelo.entities.Usuario;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author ismael
 */
@Named
@ViewScoped
public class UsuariosController implements Serializable {

    @EJB
    private UsuarioDAO usuarioDAO;

    private List<Usuario> usuarios;
    private List<InfoCargaUsuarioDTO> infoCargaUsuarios;
    private Part filePart;

    @PostConstruct
    public void init() {
        usuarios = usuarioDAO.findAll();
    }

    public void saludar() {
        System.out.println("Hola con JSF....");
    }

    public void cargarUsuarios() {
        System.out.println("Info: " + filePart.getName());
        System.out.println("Info: " + filePart.getSize());
        System.out.println("Info: " + filePart.getSubmittedFileName());
        System.out.println("Info: " + filePart.getContentType());

        try {
            InputStreamReader isr = new InputStreamReader(filePart.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            List<Usuario> usuariosParaRegistrar = new ArrayList<>();
            infoCargaUsuarios = new ArrayList<>();
            while (Objects.nonNull(line = br.readLine())) {
                Usuario user = strToUsuario(line, infoCargaUsuarios);
                if (Objects.nonNull(user)) {
                    System.out.println(user.getNombres() + " " + user.getApellidos());
                    usuariosParaRegistrar.add(user);
                }
            }
            if(!usuariosParaRegistrar.isEmpty()){
                usuarioDAO.register(usuariosParaRegistrar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Usuario strToUsuario(String info, List<InfoCargaUsuarioDTO> infoCargaUsuarios) {
        String[] data = info.split(";");
        Usuario usuario = null;
        InfoCargaUsuarioDTO infoCarga = new InfoCargaUsuarioDTO(info);
        if (data.length == 6) {
            TipoDocumento td = getTipoDocumento(data[0], infoCarga);
            Municipio municipio = getMunicipio(data[5], infoCarga);
            if(infoCarga.isCargado()){
                usuario = new Usuario();
                usuario.setTipoDocumento(td);
                usuario.setNumeroDocumento(data[1]);
                usuario.setNombres(data[2]);
                usuario.setApellidos(data[3]);
                usuario.setNombreUsuario(data[4]);
                usuario.setClave(data[1]);
                usuario.setMunicipio(municipio);
            }
        } else{
            infoCarga.addError(new CargaDataErrorDTO("Todos", "Data incompleta se esperaban 6 datos."));
        }
        infoCargaUsuarios.add(infoCarga);
        return usuario;
    }
    
    private TipoDocumento getTipoDocumento(String tipoDocumentoData, InfoCargaUsuarioDTO infoCarga){
        Integer idTipoDocumento = toInteger(tipoDocumentoData);
        if(Objects.isNull(idTipoDocumento)){
            infoCarga.addError(new CargaDataErrorDTO("Tipo documento", "No es un número"));
        }
        return new TipoDocumento(idTipoDocumento);
    }
    
    private Municipio getMunicipio(String tipoMunicipioData, InfoCargaUsuarioDTO infoCarga){
        Integer idMunicipio = toInteger(tipoMunicipioData);
        if(Objects.isNull(idMunicipio)){
            infoCarga.addError(new CargaDataErrorDTO("Municipio", "No es un número"));
        }
        return new Municipio(idMunicipio);
    }
    
    private Integer toInteger(String valor){
        try{
            return Integer.valueOf(valor);
        } catch(NumberFormatException nfe){
            return null;
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Part getFilePart() {
        return filePart;
    }

    public void setFilePart(Part filePart) {
        this.filePart = filePart;
    }

    public List<InfoCargaUsuarioDTO> getInfoCargaUsuarios() {
        return infoCargaUsuarios;
    }

}
