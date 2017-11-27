package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.TarjetaPuntosEntity;
import java.sql.Time;
import java.util.List;


public class TarjetaPuntosDTO {

    private Long id;
    private int puntos;
    private List<Time> vencimientos;

    public TarjetaPuntosDTO() {
        /**
         * Constructor por defecto
         */
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param tarjetaPuntos: Es la entidad que se va a convertir a DTO
     */
    public TarjetaPuntosDTO(TarjetaPuntosEntity tarjetaPuntos) {
        if(tarjetaPuntos != null)
        {
        this.id = tarjetaPuntos.getId();
        this.puntos=tarjetaPuntos.getPuntos();
        this.vencimientos= tarjetaPuntos.getVencimientos();
        }
    }

    /**
     * @return id de la tarjeta
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id: id de la tarjeta
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return puntos de la tarjeta
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos: puntos de la tarjeta
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return fecha de vencimiento de la tarjeta
     */
    public List<Time> getVencimientos() {
        return vencimientos;
    }

    /**
     * @param vencimientos: fecha de los vencimientos de la tarjeta
     */
    public void setVencimientos(List<Time> vencimientos) {
        this.vencimientos = vencimientos;
    }

    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public TarjetaPuntosEntity toEntity() {
        TarjetaPuntosEntity entity = new TarjetaPuntosEntity();
        entity.setId(this.id);
        entity.setPuntos(this.puntos);
        entity.setVencimientos(this.vencimientos);
        return entity;
    }
    
}
