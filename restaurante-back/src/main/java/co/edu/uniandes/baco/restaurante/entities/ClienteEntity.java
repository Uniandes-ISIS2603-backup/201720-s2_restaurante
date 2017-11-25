/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;


/**
 *
 * @author s.heim
 */
@Entity
public class ClienteEntity extends BaseEntity implements Serializable
{
    private boolean tieneTarjeta;
    private String nombre;
    private String apellido;
    private int numPuntos;
    
    
    @PodamExclude
    @OneToOne
    private TarjetaPuntosEntity tarjeta;
    
    @PodamExclude
    @OneToOne
    private DomicilioEntity dom;

    @PodamExclude
    @ManyToOne
    private RestauranteEntity rest;

    @PodamExclude
    @OneToMany
    private List<PagoEntity> metodos = new ArrayList<>();

    @PodamExclude
    @OneToMany
    private List<ReservaEntity> reservas = new ArrayList<>();
    
    
    public List<ReservaEntity> getReservas() {
        return reservas;
    }

    public TarjetaPuntosEntity getTarjeta() {
        return tarjeta;
    }

    public DomicilioEntity getDom() {
        return dom;
    }

    public RestauranteEntity getRest() {
        return rest;
    }

    public List<PagoEntity> getMetodos() {
        return metodos;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @return the numPuntos
     */
    public int getNumPuntos() {
        return numPuntos;
    }

    /**
     * @return the tieneTarjeta
     */
    public boolean isTieneTarjeta() {
        return tieneTarjeta;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param tieneTarjeta the tieneTarjeta to set
     */
    public void settieneTarjeta(boolean tieneTarjeta) {
        this.tieneTarjeta = tieneTarjeta;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @param numPuntos the numPuntos to set
     */
    public void setNumPuntos(int numPuntos) {
        this.numPuntos = numPuntos;
    }

    public void setMetodos(List<PagoEntity> metodos) {
        this.metodos = metodos;
    }
    
    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }

    public void setTarjeta(TarjetaPuntosEntity tarjeta) {
        this.tarjeta = tarjeta;
    } 

    public void setDom(DomicilioEntity dom) {
        this.dom = dom;
    }

    public void setRest(RestauranteEntity rest) {
        this.rest = rest;
    }

    @Override
    public int hashCode() {
        return 7;
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
        final ClienteEntity other = (ClienteEntity) obj;
        return this.tieneTarjeta == other.tieneTarjeta;
    }

    
    
}
