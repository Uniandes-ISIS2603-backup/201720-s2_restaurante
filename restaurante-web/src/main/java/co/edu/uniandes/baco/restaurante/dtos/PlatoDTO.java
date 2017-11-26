/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;

/**
 *
 * @author df.penap
 */
public class PlatoDTO {
        private Long id;
        private String name;
        private double precio;
        private boolean especialSucursal;




    /**
     * Constructor por defecto
     */
    public PlatoDTO() {
        /**
         * Constructor por defecto
         */
    }

    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param Plato: Es la entidad que se va a convertir a DTO 
     */
    public PlatoDTO(PlatoEntity plato) {
        if(plato != null)
        {
        this.id = plato.getId();
        this.name = plato.getName();
        this.precio = plato.getPrecio();
        this.especialSucursal = plato.isEspecialSucursal();
        }
    }
    
 

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEspecialSucursal() {
        return especialSucursal;
    }

    public void setEspecialSucursal(boolean especialSucursal) {
        this.especialSucursal = especialSucursal;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    
    public PlatoEntity toEntity() {
        PlatoEntity entity = new PlatoEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setEspecialSucursal(this.especialSucursal);
        entity.setPrecio(this.precio);
        return entity;
    }
}
