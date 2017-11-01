/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.PedidoEntity;

/**
 *
 * @author s.heim
 */
public class PedidoDTO 
{
    private Long id;
    private String name;

    /**
     * Constructor por defecto
     */
    public PedidoDTO() {
    }

    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param pedido: Es la entidad que se va a convertir a DTO 
     */
    public PedidoDTO(PedidoEntity pedido) {
        this.id = pedido.getId();
        this.name = pedido.getName();
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
    
    public PedidoEntity toEntity() {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        return entity;
    }
}