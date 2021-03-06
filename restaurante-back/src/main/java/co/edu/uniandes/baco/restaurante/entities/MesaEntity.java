/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jf.sanchezg
 */
@Entity
public class MesaEntity extends BaseEntity implements Serializable{
    
    /*
    *Relaciones y atributos
    */
    private int sillasDisponibles;
    private int piso;
    private boolean disponible; 

    @PodamExclude
    @ManyToOne
    private SucursalEntity sucursal;
    @PodamExclude
    @OneToOne
    private ReservaEntity reserva;

    /*
    *Getters y Setters
    */
    
    /**
     * @return the sucursal
     */
    public SucursalEntity getSucursal() {
        return sucursal;
    }
    
    /**
     * @return the reserva
     */
    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }
    
    
    /**
     * @return the sillas disponibles
     */
    public int getSillasDisponibles() {
        return sillasDisponibles;
    }

    public void setSillasDisponibles(int sillasDisponibles) {
        this.sillasDisponibles = sillasDisponibles;
    }
    
    /**
     * @return the piso
     */
    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    
    /**
     * @return the disponibilidad
     */
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.sillasDisponibles;
        return hash;
    }
    
}
