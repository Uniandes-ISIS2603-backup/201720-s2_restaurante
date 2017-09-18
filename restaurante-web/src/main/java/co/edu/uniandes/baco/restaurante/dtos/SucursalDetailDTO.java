/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.SucursalEntity;
import java.util.ArrayList;

/**
 *
 * @author jd.correa
 */
public class SucursalDetailDTO extends SucursalDTO{
    private RestauranteDTO restaurante;
    public SucursalDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public SucursalDetailDTO(SucursalEntity entity) {
        super(entity);
        if (entity.getRestaurante() != null) {
            this.restaurante = new RestauranteDTO(entity.getRestaurante());
        } else {
            entity.setRestaurante(null);
        }
        }
    
}
