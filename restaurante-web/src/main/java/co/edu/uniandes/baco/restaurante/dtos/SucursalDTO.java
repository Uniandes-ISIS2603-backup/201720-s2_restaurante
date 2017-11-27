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
    private String image;

    /**
     * Constructor por defecto
     */
    public SucursalDTO() {
        /**
         * Constructor por defecto
         */
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param sucursal: Es la entidad que se va a convertir a DTO
     */
    public SucursalDTO(SucursalEntity sucursal) {
        if (sucursal != null) {
            this.id = sucursal.getId();
            this.calificacion = sucursal.getCalificacion();
            this.direccion = sucursal.getDireccion();
            this.dosPisos = sucursal.isDosPisos();
            this.image = sucursal.getImage();
        }
    }

    /**
     * @return calificacion de la sucursal
     */
    public String getCalificacion() {
        return calificacion;
    }

    /**
     * @return la sucursal es de dos pisos?
     */
    public boolean isDosPisos() {
        return dosPisos;
    }

    /**
     * @return direccion de la sucursal
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param calificacion: calificacion de la sucursal
     */
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @param dosPisos: la sucursal es de dos pisos?
     */
    public void setDosPisos(boolean dosPisos) {
        this.dosPisos = dosPisos;
    }

    /**
     * @param direccion: direccion de la sucursal
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public SucursalEntity toEntity() {
        SucursalEntity entity = new SucursalEntity();
        entity.setId(this.id);
        entity.setCalificacion(this.calificacion);
        entity.setDireccion(this.direccion);
        entity.setDosPisos(this.dosPisos);
        entity.setImage(this.image);
        return entity;
    }

    /**
     * @return imagen de la sucursal
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image: imagen de la sucursal
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return id de la sucursal
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id: id de la sucursal
     */
    public void setId(Long id) {
        this.id = id;
    }
}
