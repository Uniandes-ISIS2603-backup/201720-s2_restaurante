/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;

/**
 *
 * @author df.penap
 */
public class PlatoDetailDTO extends PlatoDTO{
     /**
     * Constructor por defecto
     */
    public PlatoDetailDTO() {
        /**
         * Constructor por defecto
         */
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public PlatoDetailDTO(PlatoEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public PlatoEntity toEntity() {
        return super.toEntity();
    }
}
