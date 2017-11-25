/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.ReservaEntity;
import java.util.Date;

/**
 *
 * @author jf.sanchezg
 */
public class ReservaDTO {
    
    private Long id;
    private Date fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Constructor por defecto
     */
    public ReservaDTO() {
        //Constructor por defecto
    }
    

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param reserva: Es la entidad que se va a convertir a DTO
     */
    public ReservaDTO(ReservaEntity reserva) {
        if(reserva != null)
        {
        this.id = reserva.getId();
        this.fecha = reserva.getFecha();
        }
    }
    
    
    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public ReservaEntity toEntity() {
        ReservaEntity entity = new ReservaEntity();
        entity.setId(this.id);
        entity.setFecha(this.fecha);
        return entity;
    }
}
