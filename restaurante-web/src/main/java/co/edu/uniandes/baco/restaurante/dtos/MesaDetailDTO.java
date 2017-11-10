/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.MesaEntity;

/**
 *
 * @author jf.sanchezg
 */
public class MesaDetailDTO extends MesaDTO {
    /**
     * Constructor por defecto
     */
    public MesaDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public MesaDetailDTO(MesaEntity entity) {
        super(entity);
        
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public MesaEntity toEntity() {
        MesaEntity mesaM = super.toEntity();
        return mesaM;
    }
}
