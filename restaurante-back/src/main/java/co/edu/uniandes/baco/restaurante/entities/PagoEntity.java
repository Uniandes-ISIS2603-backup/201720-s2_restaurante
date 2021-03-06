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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author df.penap
 */
@Entity
public class PagoEntity extends BaseEntity implements Serializable {

    /*
    *Relaciones y atributos
    */
    private boolean registrado;
    private boolean pagoAnticipado;
    private String tipo;
    @PodamExclude
    @OneToMany
    private List<PedidoEntity> pedidos = new ArrayList<>();
    @PodamExclude
    @OneToOne
    private DomicilioEntity domicilio;
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    /*
    *Getters y Setters
    */
    
    /**
     * @return the pedidos
     */
    public List<PedidoEntity> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoEntity> pedidos) {
        this.pedidos = pedidos;
    }
    
    /**
     * @return the domicilios
     */
    public DomicilioEntity getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioEntity domicilio) {
        this.domicilio = domicilio;
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

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public void setPagoAnticipado(boolean pagoAnticipado) {
        this.pagoAnticipado = pagoAnticipado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * @return the esta registrado
     */
    public boolean getRegistrado() {
        return registrado;
    }
    
    /**
     * @return the pago anticipado
     */
    public boolean getPagoAnticipado() {
        return pagoAnticipado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.registrado ? 1 : 0);
        return hash;
    }

    public String getTipo() {
        return tipo;
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
        final PagoEntity other = (PagoEntity) obj;
        if (this.registrado != other.registrado) {
            return false;
        }
        return true;
    }

}
