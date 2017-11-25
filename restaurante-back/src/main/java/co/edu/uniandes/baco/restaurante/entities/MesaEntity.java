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
    private int sillasDisponibles;
    private int piso;
    private boolean disponible; 

    @PodamExclude
    @ManyToOne
    private SucursalEntity sucursal;
    @PodamExclude
    @OneToOne
    private ReservaEntity reserva;

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }
    
    
    
    public int getSillasDisponibles() {
        return sillasDisponibles;
    }

    public void setSillasDisponibles(int sillasDisponibles) {
        this.sillasDisponibles = sillasDisponibles;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public int hashCode() {
        return 8;
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
    
}
