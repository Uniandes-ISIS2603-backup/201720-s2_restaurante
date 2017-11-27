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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jd.correa
 */
@Entity
public class SucursalEntity extends BaseEntity implements Serializable {

    private String calificacion;
    private boolean dosPisos;
    private String direccion;
    private String image;

    @PodamExclude
    @ManyToOne
    private RestauranteEntity restaurante;
    @PodamExclude
    @ManyToMany
    private List<PlatoEntity> platos = new ArrayList<>();
    @PodamExclude
    @OneToMany
    private List<MesaEntity> mesas = new ArrayList<>();

    /**
     * @return the imagen
     */
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the platos
     */
    public List<PlatoEntity> getPlatos() {
        return platos;
    }

    public void setPlatos(List<PlatoEntity> platos) {
        this.platos = platos;
    }

    /**
     * @return the mesas
     */
    public List<MesaEntity> getMesas() {
        return mesas;
    }

    public void setMesas(List<MesaEntity> mesas) {
        this.mesas = mesas;
    }

    /**
     * @return the restaurante
     */
    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteEntity restaurante) {
        this.restaurante = restaurante;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return la sucursal tiene dos pisos?
     */
    public boolean isDosPisos() {
        return dosPisos;
    }

    
    public void setDosPisos(boolean dosPisos) {
        this.dosPisos = dosPisos;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.calificacion);
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
        final SucursalEntity other = (SucursalEntity) obj;
        return Objects.equals(this.calificacion, other.calificacion);
    }
    
    

}
