/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;
import co.edu.uniandes.baco.restaurante.entities.SucursalEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jd.correa
 */
public class SucursalDetailDTO extends SucursalDTO {

    private RestauranteDTO restaurante;
    private List<PlatoDTO> platos;

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
        if (entity != null) {
            this.restaurante = new RestauranteDTO(entity.getRestaurante());
            platos = new ArrayList<>();
            for (PlatoEntity entityPlatos : entity.getPlatos()) {
                platos.add(new PlatoDTO(entityPlatos));
            }
        }
    }

    @Override
    public SucursalEntity toEntity() {
        SucursalEntity entity = super.toEntity();
        if (platos != null) {
            List<PlatoEntity> booksEntity = new ArrayList<>();
            for (PlatoDTO dtoBook : platos) {
                booksEntity.add(dtoBook.toEntity());
            }
            entity.setPlatos(booksEntity);
        }
        if (restaurante != null) {
            entity.setRestaurante(restaurante.toEntity());
        }
        return entity;
    }
}
