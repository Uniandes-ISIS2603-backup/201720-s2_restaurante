/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.ClienteEntity;

/**
 *
 * @author s.heim
 */
public class ClienteDTO {
    private Long id;
    private String name;
    private String nombre;
    private String apellido;
    private int numPuntos;
    private boolean tieneTarjeta;

    /**
     * Constructor por defecto
     */
    public ClienteDTO() {
    }

    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param cliente: Es la entidad que se va a convertir a DTO 
     */
    public ClienteDTO(ClienteEntity cliente) {
        if(cliente != null)
        {
        this.id = cliente.getId();
        this.name = cliente.getName();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.numPuntos = cliente.getNumPuntos();
        this.tieneTarjeta = false;
        }
        
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
    public ClienteEntity toEntity() {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setNombre(this.nombre);
        entity.setApellido((this.apellido));
        entity.setNumPuntos(this.numPuntos);
        entity.settieneTarjeta(this.tieneTarjeta);
        return entity;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the numPuntos
     */
    public int getNumPuntos() {
        return numPuntos;
    }

    /**
     * @param numPuntos the numPuntos to set
     */
    public void setNumPuntos(int numPuntos) {
        this.numPuntos = numPuntos;
    }

    /**
     * @return the tieneTarjeta
     */
    public boolean isTieneTarjeta() {
        return tieneTarjeta;
    }

    /**
     * @param tieneTarjeta the tieneTarjeta to set
     */
    public void setTieneTarjeta(boolean tieneTarjeta) {
        this.tieneTarjeta = tieneTarjeta;
    }
}
