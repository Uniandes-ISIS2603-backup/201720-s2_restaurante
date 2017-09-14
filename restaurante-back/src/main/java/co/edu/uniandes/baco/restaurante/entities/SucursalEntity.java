/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jd.correa
 */
@Entity
public class SucursalEntity extends BaseEntity implements Serializable{
    private String calificacion;
    private boolean dosPisos;
    private String direccion;
    @PodamExclude
   @OneToMany
   private List<MesaEntity> mesas;
    @PodamExclude
   @ManyToOne
   private List<RestauranteEntity> restaurante;
    @PodamExclude
   @ManyToMany
   private List<PlatoEntity> platos;

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isDosPisos() {
        return dosPisos;
    }

    public void setDosPisos(boolean dosPisos) {
        this.dosPisos = dosPisos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
