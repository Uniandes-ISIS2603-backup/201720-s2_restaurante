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

    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }
    
    public TarjetaPuntosEntity getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaPuntosEntity tarjeta) {
        this.tarjeta = tarjeta;
    }

    public DomicilioEntity getDom() {
        return dom;
    }

    public void setDom(DomicilioEntity dom) {
        this.dom = dom;
    }

    public RestauranteEntity getRest() {
        return rest;
    }

    public void setRest(RestauranteEntity rest) {
        this.rest = rest;
    }

    public List<PagoEntity> getMetodos() {
        return metodos;
    }

    public void setMetodos(List<PagoEntity> metodos) {
        this.metodos = metodos;
    }
   

    /**
     * @return the tieneTarjeta
     */
    public boolean isTieneTarjeta() {
        return tieneTarjeta;
    }

    /**
     * @param tieneTarjeta the tieneTarjeta to set
     */
    public void settieneTarjeta(boolean tieneTarjeta) {
        this.tieneTarjeta = tieneTarjeta;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the numPuntos
     */
    public int getNumPuntos() {
        return numPuntos;
    }

    /**
     * @param numPuntos the numPuntos to set
     */
    public void setNumPuntos(int numPuntos) {
        this.numPuntos = numPuntos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.tieneTarjeta ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.apellido);
        hash = 41 * hash + this.numPuntos;
        hash = 41 * hash + Objects.hashCode(this.tarjeta);
        hash = 41 * hash + Objects.hashCode(this.dom);
        hash = 41 * hash + Objects.hashCode(this.rest);
        hash = 41 * hash + Objects.hashCode(this.metodos);
        hash = 41 * hash + Objects.hashCode(this.reservas);
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
        final ClienteEntity other = (ClienteEntity) obj;
        if (this.tieneTarjeta != other.tieneTarjeta) {
            return false;
        }
        if (this.numPuntos != other.numPuntos) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.tarjeta, other.tarjeta)) {
            return false;
        }
        if (!Objects.equals(this.dom, other.dom)) {
            return false;
        }
        if (!Objects.equals(this.rest, other.rest)) {
            return false;
        }
        if (!Objects.equals(this.metodos, other.metodos)) {
            return false;
        }
        if (!Objects.equals(this.reservas, other.reservas)) {
            return false;
        }
        return true;
    }

    
    
}
