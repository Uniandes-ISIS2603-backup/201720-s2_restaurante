/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
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
    private int puntos;
    private ArrayList<Time> vencimientos;
    @PodamExclude
    @ManyToOne
    private RestauranteEntity rest;
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    public RestauranteEntity getRest() {
        return rest;
    }

    public void setRest(RestauranteEntity rest) {
        this.rest = rest;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<Time> getVencimientos() {
        return vencimientos;
    }

    public void setVencimientos(List<Time> vencimientos) {
        this.vencimientos = (ArrayList<Time>) vencimientos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.puntos;
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
        final TarjetaPuntosEntity other = (TarjetaPuntosEntity) obj;
        if (this.puntos != other.puntos) {
            return false;
        }
        return true;
    }
    
}
