package co.edu.uniandes.baco.restaurante.dtos;
import co.edu.uniandes.baco.restaurante.entities.TarjetaPuntosEntity;

public class TarjetaPuntosDetailDTO extends TarjetaPuntosDTO {


    public TarjetaPuntosDetailDTO() {
    }

    public TarjetaPuntosDetailDTO(TarjetaPuntosEntity entity) {
        super(entity);
    }

    @Override
    public TarjetaPuntosEntity toEntity() {
        TarjetaPuntosEntity TarjetaPuntosE = super.toEntity();
        return TarjetaPuntosE;
    }

}
