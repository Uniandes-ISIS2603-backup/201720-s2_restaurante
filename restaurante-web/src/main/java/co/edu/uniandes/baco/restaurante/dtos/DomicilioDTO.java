
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;


public class DomicilioDTO {

    private Long id;
    private int rango;
    private String platos;

    /**
     * Constructor por defecto
     */
    public DomicilioDTO() {
        //constructor por defecto
    }

    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param domicilio: Es la entidad que se va a convertir a DTO 
     */
    public DomicilioDTO(DomicilioEntity domicilio) {
        if(domicilio!=null){
        this.id = domicilio.getId();
        this.rango =domicilio.getRango();
        this.platos = domicilio.getPlatos();
        }
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id: id del domicilio
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public DomicilioEntity toEntity() {
        DomicilioEntity entity = new DomicilioEntity();
        entity.setId(this.id);
        entity.setRango(this.rango);
        entity.setPlatos(this.platos);
        return entity;
    }

    /**
     * @return the rango
     */
    public int getRango() {
        return rango;
    }

    /**
     * @param int Rango
     */
    public void setRango(int rango) {
        this.rango = rango;
    }

    /**
     * @return the platos
     */
    public String getPlatos() {
        return platos;
    }

    /**
     * @param String platos
     */
    public void setPlatos(String platos) {
        this.platos = platos;
    }
    
    
    
}
