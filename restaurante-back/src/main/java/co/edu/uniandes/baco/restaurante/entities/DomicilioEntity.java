/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
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
    @PodamExclude
    @ManyToOne
    private RestauranteEntity rest;

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }
    
    
}
