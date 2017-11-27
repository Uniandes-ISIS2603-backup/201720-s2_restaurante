
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;


public class DomicilioDTO {

    private Long id;
    private int rango;
    private long plato1;
    private long plato2;
    private long plato3;
    private long plato4;
    private long plato5;

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
        this.plato1 = domicilio.getPlato1();
        this.plato2 = domicilio.getPlato2();
        this.plato3 = domicilio.getPlato3();
        this.plato4 = domicilio.getPlato4();
        this.plato5 = domicilio.getPlato5();
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
        entity.setPlato1(this.plato1);
        entity.setPlato2(this.plato2);
        entity.setPlato3(this.plato3);
        entity.setPlato4(this.plato4);
        entity.setPlato5(this.plato5);
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

    public long getPlato1() {
        return plato1;
    }

    public void setPlato1(long plato1) {
        this.plato1 = plato1;
    }

    public long getPlato2() {
        return plato2;
    }

    public void setPlato2(long plato2) {
        this.plato2 = plato2;
    }

    public long getPlato3() {
        return plato3;
    }

    public void setPlato3(long plato3) {
        this.plato3 = plato3;
    }

    public long getPlato4() {
        return plato4;
    }

    public void setPlato4(long plato4) {
        this.plato4 = plato4;
    }

    public long getPlato5() {
        return plato5;
    }

    public void setPlato5(long plato5) {
        this.plato5 = plato5;
    }

    
    
    
    
}
