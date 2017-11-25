
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.PedidoEntity;

/**
 *
 * @author s.heim
 */
public class PedidoDetailDTO extends PedidoDTO{
    /**
     * Constructor por defecto
     */
    public PedidoDetailDTO() {
        /**
         * Constructor por defecto
         */
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public PedidoDetailDTO(PedidoEntity entity) {
        super(entity);
    }

}


