package co.edu.uniandes.baco.restaurante.dtos;

import co.edu.uniandes.baco.restaurante.entities.TarjetaPuntosEntity;
import java.sql.Time;
import java.util.ArrayList;


public class TarjetaPuntosDTO {

    private Long id;
    private int puntos;
    private ArrayList<Time> vencimientos;

    public TarjetaPuntosDTO() {
    }

    public TarjetaPuntosDTO(TarjetaPuntosEntity tarjetaPuntos) {
        this.id = tarjetaPuntos.getId();
        this.puntos=tarjetaPuntos.getPuntos();
        this.vencimientos= tarjetaPuntos.getVencimientos();
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

    public ArrayList<Time> getVencimientos() {
        return vencimientos;
    }

    public void setVencimientos(ArrayList<Time> vencimientos) {
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
