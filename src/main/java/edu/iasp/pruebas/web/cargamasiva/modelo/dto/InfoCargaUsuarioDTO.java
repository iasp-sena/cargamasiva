/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iasp.pruebas.web.cargamasiva.modelo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ismael
 */
public class InfoCargaUsuarioDTO {
    
    private String infoData;
    private List<CargaDataErrorDTO> errores;
    private boolean cargado;

    public InfoCargaUsuarioDTO(String info) {
        this.infoData = info;
        this.errores = new ArrayList<>();
        this.cargado = true;
    }

    public String getInfoData() {
        return infoData;
    }

    public void setInfoData(String infoData) {
        this.infoData = infoData;
    }

    public List<CargaDataErrorDTO> getErrores() {
        return errores;
    }

    public boolean isCargado() {
        return cargado;
    }

    public void addError(CargaDataErrorDTO cargaDataErrorDTO) {
        errores.add(cargaDataErrorDTO);
        this.cargado = false;
    }
    
    
    
}
