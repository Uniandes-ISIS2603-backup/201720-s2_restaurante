/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jf.sanchezg
 */
@Entity
public class ReservaEntity extends BaseEntity implements Serializable{
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @PodamExclude
    @ManyToOne
    private RestauranteEntity restaurante;
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    @PodamExclude
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
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
