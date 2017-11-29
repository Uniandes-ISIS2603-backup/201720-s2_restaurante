/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.heim
 */
@Entity
public class PedidoEntity extends BaseEntity implements Serializable 
{
    /*
    Relaciones y atributos
    */
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String direccion;
    private String dirSucursal;
    private String nomCliente;
    @PodamExclude
   @OneToMany
   private List<PlatoEntity> platos = new ArrayList<>();
    @PodamExclude
   @OneToOne
    private DomicilioEntity domicilio;
    @PodamExclude
    @ManyToOne
    private PagoEntity pago;

    /**
     * @return the platos
     */
    public List<PlatoEntity> getPlatos() {
        return platos;
    }

    /**
     * @param List platos
     */
    public void setPlatos(List<PlatoEntity> platos) {
        this.platos = platos;
    }

    public DomicilioEntity getDomicilio() {
        return domicilio;
    }

    /**
     * @param DomicilioEntity domicilio 
     */
    public void setDomicilio(DomicilioEntity domicilio) {
        this.domicilio = domicilio;
    }

    public PagoEntity getPago() {
        return pago;
    }

    /**
     * @param PagoEntity pago a destinar
     */
    public void setPago(PagoEntity pago) {
        this.pago = pago;
    }


    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDirSucursal() {
        return dirSucursal;
    }

    /**
     * @param String direccion de la sucursal
     */
    public void setDirSucursal(String dirSucursal) {
        this.dirSucursal = dirSucursal;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * @return the nomCliente
     */
    public String getNomCliente() {
        return nomCliente;
    }

    /**
     * @param nomCliente the nomCliente to set
     */
    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.fecha);
        hash = 71 * hash + Objects.hashCode(this.direccion);
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
        final PedidoEntity other = (PedidoEntity) obj;
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    
    
}
