/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.ReservaEntity;

/**
 *
 * @author jf.sanchezg
 */
public class ReservaDetailDTO extends ReservaDTO{
     /**
     * Constructor por defecto
     */
    public ReservaDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ReservaDetailDTO(ReservaEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ReservaEntity toEntity() {
        ReservaEntity ReservaR = super.toEntity();
        return ReservaR;
    }
}
