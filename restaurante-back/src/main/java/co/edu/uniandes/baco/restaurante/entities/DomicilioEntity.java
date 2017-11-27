/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author af.bejarano
 */
@Entity
public class DomicilioEntity extends BaseEntity implements Serializable {

    /*
    *Relaciones y atributos
    */
    private int rango;
    private long plato1;
    private long plato2;
    private long plato3;
    private long plato4;
    private long plato5;
    @PodamExclude
    @OneToOne
    private PagoEntity pago;
    @PodamExclude
    @OneToOne
    private PedidoEntity pedido;
    @PodamExclude
    @OneToOne
    private ClienteEntity cliente;
    @PodamExclude
    @ManyToOne
    private RestauranteEntity rest;

    /*
    *Getters y Setters
    */
    
    /**
     * @return the pago
     */
    public PagoEntity getPago() {
        return pago;
    }

    public void setPago(PagoEntity pago) {
        this.pago = pago;
    }
    
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
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    /**
     * @return the rest
     */
    public RestauranteEntity getRest() {
        return rest;
    }
    
    
    public void setRest(RestauranteEntity rest) {
        this.rest = rest;
    }
    
    /**
     * @return the rango
     */
    public int getRango() {
        return rango;
    }
    
    public void setRango(int rango) {
        this.rango = rango;
    }

    public long getPlato1() {
        return plato1;
    }

    public void setPlato1(long plato1) {
        this.plato1 = plato1;
    }

    public long getPlato2() {
        return plato2;
    }

    public void setPlato2(long plato2) {
        this.plato2 = plato2;
    }

    public long getPlato3() {
        return plato3;
    }

    public void setPlato3(long plato3) {
        this.plato3 = plato3;
    }

    public long getPlato4() {
        return plato4;
    }

    public void setPlato4(long plato4) {
        this.plato4 = plato4;
    }

    public long getPlato5() {
        return plato5;
    }

    public void setPlato5(long plato5) {
        this.plato5 = plato5;
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
        final DomicilioEntity other = (DomicilioEntity) obj;
        if (this.rango != other.rango) {
            return false;
        }
        if (!Objects.equals(this.pago, other.pago)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.rango;
        hash = 53 * hash + Objects.hashCode(this.pago);
        return hash;
    }

}
