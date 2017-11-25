
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;


public class DomicilioDTO {

    private Long id;
    private int rango;

    public DomicilioDTO() {
        //constructor por defecto
    }

    public DomicilioDTO(DomicilioEntity domicilio) {
        if(domicilio!=null){
        this.id = domicilio.getId();
        this.rango =domicilio.getRango();
        }
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

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }
    
    
    
}
