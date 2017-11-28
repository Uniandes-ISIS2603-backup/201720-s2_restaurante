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
    private String dirSuc;
    private String idMesa;
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
        this.dirSuc=reserva.getDirSuc();
        this.idMesa =reserva.getIdMesa();
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
        entity.setDirSuc(this.dirSuc);
        entity.setMesaId(this.idMesa);
        return entity;
    }

    /**
     * @return direccion de la sucursal
     */
    public String getDirSuc() {
        return dirSuc;
    }

    /**
     * @param dirSuc: direccion de la sucursal
     */
    public void setDirSuc(String dirSuc) {
        this.dirSuc = dirSuc;
    }

    /**
     * @return id de la reserva
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id: id de la reserva
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return fecha de la reserva
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha: fecha en la que se realiza la reserva
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
     /**
     * @return id mesa
     */
    public String getIdMesa() {
        return idMesa;
    }

    /**
     * @param mesa: mesa a la que se le dio reserva
     */
    public void setIdMesa(String mesa) {
        this.idMesa = mesa;
    }
}
