/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author af.bejarano
 */
@Entity
public class TarjetaPuntosEntity extends BaseEntity implements Serializable{
    /**
     * Relaciones y atributos
     */
    private int puntos;
    private List<Time> vencimientos;
    @PodamExclude
    @ManyToOne
    private RestauranteEntity rest;
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * @return the rest
     */
    public RestauranteEntity getRest() {
        return rest;
    }

    /**
     * @return the fecha
     */
    public void setRest(RestauranteEntity rest) {
        this.rest = rest;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param ClienteEntity cliente
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param int puntos de la tarjeta
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the vencimientos
     */
    public List<Time> getVencimientos() {
        return vencimientos;
    }

    /**
     * @param List vencimientos de los puntos
     */
    public void setVencimientos(List<Time> vencimientos) {
        this.vencimientos = vencimientos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.puntos;
        return hash;
    }

    /**
     * @param Object obj
     */
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
        final TarjetaPuntosEntity other = (TarjetaPuntosEntity) obj;
        if (this.puntos != other.puntos) {
            return false;
        }
        return true;
    }
    
}
