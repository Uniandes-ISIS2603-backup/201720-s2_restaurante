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

    public TarjetaPuntosDTO(TarjetaPuntosEntity tarjetaPuntos) {
        if(tarjetaPuntos != null)
        {
        this.id = tarjetaPuntos.getId();
        this.puntos=tarjetaPuntos.getPuntos();
        this.vencimientos= tarjetaPuntos.getVencimientos();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<Time> getVencimientos() {
        return vencimientos;
    }

    public void setVencimientos(List<Time> vencimientos) {
        this.vencimientos = vencimientos;
    }

    public TarjetaPuntosEntity toEntity() {
        TarjetaPuntosEntity entity = new TarjetaPuntosEntity();
        entity.setId(this.id);
        entity.setPuntos(this.puntos);
        entity.setVencimientos(this.vencimientos);
        return entity;
    }
    
}
