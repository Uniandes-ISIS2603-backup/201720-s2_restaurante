/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.util.List;
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
    //atributos
    private boolean tieneTarjeta;
    private String nombre;
    private String apellido;
    private int numPuntos;

    //relaciones
    @PodamExclude
    @OneToMany
    private List<ReservaEntity> reservas;
    
    @PodamExclude
    @OneToMany
    private List<PagoEntity> pagos;
    
    @PodamExclude
    @ManyToOne
    private RestauranteEntity restaurante;
    
    @OneToOne
    private DomicilioEntity domicilio;
    
    @OneToOne
    private TarjetaPuntosEntity tarjetaPuntos;
    
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
}
