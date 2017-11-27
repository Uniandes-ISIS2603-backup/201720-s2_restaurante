/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.RestauranteEntity;
import java.util.Date;

/**
 * RestauranteDTO Objeto de transferencia de datos de Restaurantees. Los DTO
 * contienen las represnetaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 *
 * @author ISIS2603
 */
public class RestauranteDTO {

    private Long id;
    private Date horaInicManiana;
    private Date horaInicTarde;
    private Date horaEndManiana;
    private Date horaEndTarde;

    /**
     * Constructor por defecto
     */
    public RestauranteDTO() {
        //constructor por defecto
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Restaurante: Es la entidad que se va a convertir a DTO
     */
    public RestauranteDTO(RestauranteEntity restaurante) {
        if (restaurante != null) {
            this.horaEndManiana = restaurante.getHoraFinManiana();
            this.horaEndTarde = restaurante.getHoraFinTarde();
            this.horaInicManiana = restaurante.getHoraInicioManiana();
            this.horaInicTarde = restaurante.getHoraInicioTarde();
            this.id = restaurante.getId();
        }
    }

    /**
     * @return hora de inicio en la maniana
     */
    public Date getHoraInicManiana() {
        return horaInicManiana;
    }
    

    /**
     * @param horaInicManiana hora de abrir en la maniana
     */
    public void setHoraInicManiana(Date horaInicManiana) {
        this.horaInicManiana = horaInicManiana;
    }

    /**
     * @return hora inicio tarde
     */
    public Date getHoraInicTarde() {
        return horaInicTarde;
    }

    /**
     * @param horaInicTarde hora de abrir en la tarde
     */
    public void setHoraInicTarde(Date horaInicTarde) {
        this.horaInicTarde = horaInicTarde;
    }

    /**
     * @return hora de cierre en la maniana
     */
    public Date getHoraEndManiana() {
        return horaEndManiana;
    }

    /**
     * @param horaEndManiana: hora de cierre en la maniana
     */
    public void setHoraEndManiana(Date horaEndManiana) {
        this.horaEndManiana = horaEndManiana;
    }

    /**
     * @return hora cierre tarde
     */
    public Date getHoraEndTarde() {
        return horaEndTarde;
    }

    /**
     * @param horaEndTarde hora en la que cierra en la tarde
     */
    public void setHoraEndTarde(Date horaEndTarde) {
        this.horaEndTarde = horaEndTarde;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public RestauranteEntity toEntity() {
        RestauranteEntity entity = new RestauranteEntity();
        entity.setId(this.id);
        entity.setHoraFinManiana(horaEndManiana);
        entity.setHoraFinTarde(horaEndTarde);
        entity.setHoraInicioTarde(horaInicTarde);
        entity.setHoraInicioManiana(horaInicManiana);
        return entity;
    }

}
