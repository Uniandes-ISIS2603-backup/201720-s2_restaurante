package co.edu.uniandes.baco.restaurante.dtos;
import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;

public class DomicilioDetailDTO extends DomicilioDTO {

    public DomicilioDetailDTO() {
    }
    
    public DomicilioDetailDTO(DomicilioEntity entity) {
        super(entity);
    }

    @Override
    public DomicilioEntity toEntity() {
        DomicilioEntity DomicilioE = super.toEntity();
        return DomicilioE;
    }

}
