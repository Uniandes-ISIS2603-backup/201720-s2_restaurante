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
import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;
import co.edu.uniandes.baco.restaurante.entities.RestauranteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ISIS2603
 */
public class RestauranteDetailDTO extends RestauranteDTO {
    private List<PlatoDTO> platos;

    /**
     * Constructor por defecto
     */
    public RestauranteDetailDTO() {
        /**
         * Constructor por defecto
         */
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public RestauranteDetailDTO(RestauranteEntity entity) {
        super(entity);
        if (entity != null) {
            platos=new ArrayList<>();
            for (PlatoEntity entityPlatos : entity.getPlatos()) {
                platos.add(new PlatoDTO(entityPlatos));
            }
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public RestauranteEntity toEntity() {
        RestauranteEntity entity = super.toEntity();
        if (platos != null) {
            List<PlatoEntity> booksEntity = new ArrayList<>();
            for (PlatoDTO dtoBook : platos) {
                booksEntity.add(dtoBook.toEntity());
            }
            entity.setPlatos(booksEntity);
        }
        return entity;
    }

}
