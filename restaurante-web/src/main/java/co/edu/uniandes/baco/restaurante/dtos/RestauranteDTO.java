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
import java.sql.Time;
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
    private Date hora_inicio_maniana;
   private Date hora_inicio_tarde;
   private Date hora_fin_maniana;
   private Date hora_fin_tarde;

    public Date getHora_inicio_maniana() {
        return hora_inicio_maniana;
    }

    public void setHora_inicio_maniana(Date hora_inicio_maniana) {
        this.hora_inicio_maniana = hora_inicio_maniana;
    }

    public Date getHora_inicio_tarde() {
        return hora_inicio_tarde;
    }

    public void setHora_inicio_tarde(Date hora_inicio_tarde) {
        this.hora_inicio_tarde = hora_inicio_tarde;
    }

    public Date getHora_fin_maniana() {
        return hora_fin_maniana;
    }

    public void setHora_fin_maniana(Date hora_fin_maniana) {
        this.hora_fin_maniana = hora_fin_maniana;
    }

    public Date getHora_fin_tarde() {
        return hora_fin_tarde;
    }

    public void setHora_fin_tarde(Date hora_fin_tarde) {
        this.hora_fin_tarde = hora_fin_tarde;
    }

    /**
     * Constructor por defecto
     */
    public RestauranteDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Restaurante: Es la entidad que se va a convertir a DTO
     */
    public RestauranteDTO(RestauranteEntity Restaurante) {
        this.id = Restaurante.getId();
        this.hora_fin_maniana=Restaurante.getHora_fin_maniana();
        this.hora_fin_tarde=Restaurante.getHora_fin_tarde();
        this.hora_inicio_maniana=Restaurante.getHora_inicio_maniana();
        this.hora_inicio_tarde=Restaurante.getHora_inicio_tarde();
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
        entity.setHora_fin_maniana(hora_fin_maniana);
        entity.setHora_fin_tarde(hora_fin_tarde);
        entity.setHora_inicio_tarde(hora_inicio_tarde);
        entity.setHora_inicio_maniana(hora_inicio_maniana);
        return entity;
    }
    
}
