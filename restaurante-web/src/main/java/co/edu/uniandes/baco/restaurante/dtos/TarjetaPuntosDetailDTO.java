package co.edu.uniandes.baco.restaurante.dtos;
import co.edu.uniandes.baco.restaurante.entities.TarjetaPuntosEntity;

public class TarjetaPuntosDetailDTO extends TarjetaPuntosDTO {


    public TarjetaPuntosDetailDTO() {
        //Constructor por defecto
    }

    public TarjetaPuntosDetailDTO(TarjetaPuntosEntity entity) {
        super(entity);
    }

}
