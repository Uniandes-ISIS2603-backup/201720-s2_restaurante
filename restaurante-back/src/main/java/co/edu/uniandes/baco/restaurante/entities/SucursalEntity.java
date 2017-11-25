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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<PlatoEntity> getPlatos() {
        return platos;
    }

    public void setPlatos(List<PlatoEntity> platos) {
        this.platos = platos;
    }

    public List<MesaEntity> getMesas() {
        return mesas;
    }

    public void setMesas(List<MesaEntity> mesas) {
        this.mesas = mesas;
    }

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
        if (this.dosPisos != other.dosPisos) {
            return false;
        }
        if (!Objects.equals(this.calificacion, other.calificacion)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }

}
