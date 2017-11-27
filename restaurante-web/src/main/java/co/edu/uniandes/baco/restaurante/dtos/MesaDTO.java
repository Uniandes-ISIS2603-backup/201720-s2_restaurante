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
public class MesaDTO {
    
    private Long id;
    private int sillasDisponibles;
    private int piso;
    private boolean disponible;
     /**
     * Constructor por defecto
     */
    public MesaDTO() {
        /**
         * Constructor por defecto
         */
    }
    
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Mesa: Es la entidad que se va a convertir a DTO
     */
    public MesaDTO(MesaEntity mesa) {
        if(mesa != null)
        {
        this.id = mesa.getId();
        this.disponible=mesa.isDisponible();
        this.piso=mesa.getPiso();
        this.sillasDisponibles=mesa.getSillasDisponibles();
        }
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @return sillas disponibles en la mesa
     */
     public int getSillasDisponibles() {
        return sillasDisponibles;
    }
     
     /**
     * @return piso en el que esta la mesa
     */
     public int getPiso() {
        return piso;
    }
     
     /**
     * @return disponibilidad de la mesa
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param id: id de la mesa
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param sillasDisponibles: sillas que estan libres para reservas
     */
    public void setSillasDisponibles(int sillasDisponibles) {
        this.sillasDisponibles = sillasDisponibles;
    }  

    /**
     * @param piso: piso en el que esta la mesa
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public MesaEntity toEntity() {
        MesaEntity entity = new MesaEntity();
        entity.setId(this.id);
        entity.setDisponible(this.disponible);
        entity.setPiso(this.piso);
        entity.setSillasDisponibles(this.sillasDisponibles);
        return entity;
    }
    
}
