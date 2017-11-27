/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    /*
    *Relaciones y atributos
    */
    private String tipo;
    private boolean especialSucursal;
    private double precio;
    private String image;
    @PodamExclude
   @ManyToOne
   private PedidoEntity pedido;
    @PodamExclude
   @ManyToOne
   private RestauranteEntity restaurante;
    @PodamExclude
   @ManyToMany
   private List<SucursalEntity> sucursales = new ArrayList<>();

    /**
     * @return the pedido
     */
    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the restaurante
     */
    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteEntity restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * @return the sucursales
     */
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

    /**
     * @return the imagen
     */
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.tipo);
        hash = 29 * hash + (this.especialSucursal ? 1 : 0);
        return hash;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlatoEntity other = (PlatoEntity) obj;
        if (this.especialSucursal != other.especialSucursal) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }
    
}
