/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author jf.sanchezg
 */
@Entity
public class ReservaEntity extends BaseEntity implements Serializable{
    private Time fecha;
    
    @ManyToOne
    private RestauranteEntity restaurante;
    @ManyToOne
    private ClienteEntity cliente;
    @OneToOne
    private MesaEntity mesa;
    
    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public MesaEntity getMesa() {
        return mesa;
    }

    public void setMesa(MesaEntity mesa) {
        this.mesa = mesa;
    }
    

    public Time getFecha() {
        return fecha;
    }

    public void setFecha(Time fecha) {
        this.fecha = fecha;
    }
    
}
