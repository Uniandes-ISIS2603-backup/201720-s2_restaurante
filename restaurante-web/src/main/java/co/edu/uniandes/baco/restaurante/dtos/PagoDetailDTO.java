/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.PagoEntity;

/**
 *
 * @author df.penap
 */
public class PagoDetailDTO extends PagoDTO{
     /**
     * Constructor por defecto
     */
    public PagoDetailDTO() {
        /**
         * Constructor por defecto
         */
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public PagoDetailDTO(PagoEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public PagoEntity toEntity() {
        return super.toEntity();
    }
}
