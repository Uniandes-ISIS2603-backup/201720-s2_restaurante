/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author df.penap
 */
@Entity
public class PlatoEntity extends BaseEntity implements Serializable{
    private String tipo;
    private boolean especialSucursal;
    private double precio;

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the especialSucursal
     */
    public boolean isEspecialSucursal() {
        return especialSucursal;
    }

    /**
     * @param especialSucursal the especialSucursal to set
     */
    public void setEspecialSucursal(boolean especialSucursal) {
        this.especialSucursal = especialSucursal;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
