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
 * @author af.bejarano
 */
@Entity
public class DomicilioEntity extends BaseEntity implements Serializable{
    private int rango;
    //private PagoEntity pago;
    //private PedidoEntity pedido;
    //private ClienteEntity cliente;

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }
    
    
}
