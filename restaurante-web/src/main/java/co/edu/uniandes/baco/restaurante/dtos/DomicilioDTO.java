
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;


public class DomicilioDTO {

    private Long id;
    private int rango;

    public DomicilioDTO() {
    }

    public DomicilioDTO(DomicilioEntity domicilio) {
        this.id = domicilio.getId();
        this.rango =domicilio.getRango();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DomicilioEntity toEntity() {
        DomicilioEntity entity = new DomicilioEntity();
        entity.setId(this.id);
        entity.setRango(this.rango);
        return entity;
    }
    
}
