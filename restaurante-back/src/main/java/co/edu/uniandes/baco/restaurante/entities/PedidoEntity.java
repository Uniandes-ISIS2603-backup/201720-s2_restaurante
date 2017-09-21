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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.heim
 */
@Entity
public class PedidoEntity extends BaseEntity implements Serializable 
{
    private Date fecha;
    private String direccion;
    @PodamExclude
   @OneToMany
   private List<PlatoEntity> platos = new ArrayList<PlatoEntity>();
    @PodamExclude
   @OneToOne
    private DomicilioEntity Domicilio;
    @PodamExclude
    @ManyToOne
    private PagoEntity pago;

    public List<PlatoEntity> getPlatos() {
        return platos;
    }

    public void setPlatos(List<PlatoEntity> platos) {
        this.platos = platos;
    }

    public DomicilioEntity getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(DomicilioEntity Domicilio) {
        this.Domicilio = Domicilio;
    }

    public PagoEntity getPago() {
        return pago;
    }

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
    
}
