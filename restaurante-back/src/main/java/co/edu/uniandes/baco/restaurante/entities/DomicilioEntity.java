/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author af.bejarano
 */
@Entity
public class DomicilioEntity extends BaseEntity implements Serializable{
    private int rango;
    @OneToOne
    private PagoEntity pago;
    @OneToOne
    private PedidoEntity pedido;
    @OneToOne
    private ClienteEntity cliente;

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

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
    
    
}
