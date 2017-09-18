/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author af.bejarano
 */
@Entity
public class TarjetaPuntosEntity extends BaseEntity implements Serializable{
    private int puntos;
    private ArrayList<Time> vencimientos;
    @ManyToOne
    private RestauranteEntity rest;
    private ClienteEntity cliente;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Time> getVencimientos() {
        return vencimientos;
    }

    public void setVencimientos(ArrayList<Time> vencimientos) {
        this.vencimientos = vencimientos;
    }
    
}
