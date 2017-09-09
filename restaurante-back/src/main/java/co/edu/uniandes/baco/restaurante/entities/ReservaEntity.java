/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Entity;

/**
 *
 * @author jf.sanchezg
 */
@Entity
public class ReservaEntity extends BaseEntity implements Serializable{
    private Time fecha;

    public Time getFecha() {
        return fecha;
    }

    public void setFecha(Time fecha) {
        this.fecha = fecha;
    }
    
}
