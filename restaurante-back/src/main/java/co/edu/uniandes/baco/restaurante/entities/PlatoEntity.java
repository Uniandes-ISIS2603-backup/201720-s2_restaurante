/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;

/**
 *
 * @author df.penap
 */
public class PlatoEntity extends BaseEntity implements Serializable{
    private String tipo;
    private boolean especialSucursal;
    private double precio;
    public void setTipo(String tipo)
    {
        
    }
    public void setEspecialSucursal(boolean especialSucursal)
    {
        this.especialSucursal = especialSucursal;
    }
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
    public String getTipo()
    {
        return tipo;
    }
    public boolean getEspecialSucursal()
    {
        return especialSucursal;
    }
    public double getPrecio()
    {
        return getPrecio();
    }
}
