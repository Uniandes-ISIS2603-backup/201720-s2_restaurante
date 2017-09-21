/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author df.penap
 */
@Entity
public class PlatoEntity extends BaseEntity implements Serializable{
    private String tipo;
    private boolean especialSucursal;
    private double precio;
    @PodamExclude
   @ManyToOne
   private PedidoEntity pedido;
    @PodamExclude
   @ManyToOne
   private RestauranteEntity restaurante;
    @PodamExclude
   @ManyToMany
   private List<SucursalEntity> sucursales = new ArrayList<SucursalEntity>();

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteEntity restaurante) {
        this.restaurante = restaurante;
    }

    public List<SucursalEntity> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<SucursalEntity> sucursales) {
        this.sucursales = sucursales;
    }

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
