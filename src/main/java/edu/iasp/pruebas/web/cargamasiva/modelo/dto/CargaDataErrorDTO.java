/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iasp.pruebas.web.cargamasiva.modelo.dto;

/**
 *
 * @author ismael
 */
public class CargaDataErrorDTO {
    
    private String nombreCampo;
    private String error;

    public CargaDataErrorDTO(String nombreCampo, String error) {
        this.nombreCampo = nombreCampo;
        this.error = error;
    }
    

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
}
