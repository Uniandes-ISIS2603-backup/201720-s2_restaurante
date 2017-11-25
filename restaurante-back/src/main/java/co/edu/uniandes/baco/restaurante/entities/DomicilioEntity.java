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
public class DomicilioEntity extends BaseEntity implements Serializable{
    private int rango;
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

    public PagoEntity getPago() {
        return pago;
    }

    public void setPago(PagoEntity pago) {
        this.pago = pago;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public RestauranteEntity getRest() {
        return rest;
    }

    public void setRest(RestauranteEntity rest) {
        this.rest = rest;
    }
    

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    @Override
    public int hashCode() {
        return 3;
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
    
    
}
