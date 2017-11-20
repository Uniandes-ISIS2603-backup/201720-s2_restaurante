/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.SucursalEntity;

/**
 *
 * @author jd.correa
 */
public class SucursalDTO {
    private Long id;
     private String calificacion;
    private boolean dosPisos;
    private String direccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isDosPisos() {
        return dosPisos;
    }

    public void setDosPisos(boolean dosPisos) {
        this.dosPisos = dosPisos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
     /**
     * Constructor por defecto
     */
    public SucursalDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Sucursal: Es la entidad que se va a convertir a DTO
     */
    public SucursalDTO(SucursalEntity Sucursal) {
        this.id = Sucursal.getId();
    }
    public SucursalEntity toEntity() {
        SucursalEntity entity = new SucursalEntity();
        entity.setId(this.id);
        entity.setCalificacion(this.calificacion);
        entity.setDireccion(this.direccion);
        entity.setDosPisos(this.dosPisos);
        return entity;
    }
}
