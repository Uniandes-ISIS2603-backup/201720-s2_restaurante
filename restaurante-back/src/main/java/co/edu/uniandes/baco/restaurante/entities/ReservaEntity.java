/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jf.sanchezg
 */
@Entity
public class ReservaEntity extends BaseEntity implements Serializable{
    /**
    *Relaciones y atributos
    */
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @PodamExclude
    @ManyToOne
    private RestauranteEntity restaurante;
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    @PodamExclude
    @OneToOne
    private MesaEntity mesa;
    private String dirSuc;
    private String idMesa;
    
    /**
     * @return the restaurante
     */
    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteEntity restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the mesa
     */
    public MesaEntity getMesa() {
        return mesa;
    }

    /**
     * @return the direccion de la sucursal
     */
    public String getDirSuc() {
        return dirSuc;
    }

    public void setDirSuc(String dirSuc) {
        this.dirSuc = dirSuc;
    }

    public void setMesa(MesaEntity mesa) {
        this.mesa = mesa;
    }
    

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.fecha);
        hash = 71 * hash + Objects.hashCode(this.restaurante);
        return hash;
    }

    /**
     * @param Object obj
     */
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
        final ReservaEntity other = (ReservaEntity) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    public void setMesaId(String idMesa) {
      this.idMesa = idMesa;
    }
    
    public String getIdMesa()
    {
        return idMesa;
    }  
}
