/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.ClienteEntity;

/**
 *
 * @author s.heim
 */
public class ClienteDetailDTO extends ClienteDTO{
    /**
     * Constructor por defecto
     */
    public ClienteDetailDTO() {
        /**
         * Constructor por defecto
         */
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ClienteDetailDTO(ClienteEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ClienteEntity toEntity() {
        return super.toEntity();
    }
}