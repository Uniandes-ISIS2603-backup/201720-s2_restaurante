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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSillasDisponibles() {
        return sillasDisponibles;
    }

    public void setSillasDisponibles(int sillasDisponibles) {
        this.sillasDisponibles = sillasDisponibles;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    /**
     * Constructor por defecto
     */
    public MesaDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Mesa: Es la entidad que se va a convertir a DTO
     */
    public MesaDTO(MesaEntity Mesa) {
        if(Mesa != null)
        {
        this.id = Mesa.getId();
        this.disponible=Mesa.isDisponible();
        this.piso=Mesa.getPiso();
        this.sillasDisponibles=Mesa.getSillasDisponibles();
        }
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
