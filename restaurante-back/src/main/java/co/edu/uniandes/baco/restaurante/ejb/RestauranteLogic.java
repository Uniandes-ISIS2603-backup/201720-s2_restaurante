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
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.RestauranteEntity;
import co.edu.uniandes.baco.restaurante.entities.SucursalEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.RestaurantePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @restaurante ISIS2603
 */
@Stateless
public class RestauranteLogic {

    private static final Logger LOGGER = Logger.getLogger(RestauranteLogic.class.getName());

    @Inject
    private RestaurantePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public RestauranteEntity createRestaurante(RestauranteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Restaurante");
        // Invoca la persistencia para crear la Restaurante
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Restaurante");
        return entity;
    }

    /**
     * 
     * Obtener todas las Restaurantees existentes en la base de datos.
     *
     * @return una lista de Restaurantees.
     */
    public List<RestauranteEntity> getRestaurantes() {
        LOGGER.info("Inicia proceso de consultar todas las Restaurantees");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<RestauranteEntity> Restaurantes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Restaurantees");
        return Restaurantes;
    }
    /**
     * Actualiza la información de una instancia de Restaurante.
     *
     * @param entity Instancia de RestauranteEntity con los nuevos datos.
     * @return Instancia de RestauranteEntity con los datos actualizados.
     * @generated
     */
    public RestauranteEntity updateRestaurante(RestauranteEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un autor ");
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Restaurante de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteRestaurante(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor ");
        persistence.delete(id);
    }
    public RestauranteEntity getRestaurante(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor con id = {0}", id);
        return persistence.find(id);
    }
    /**
     * Obtiene una instancia de SucursalEntity asociada a una instancia de Restaurante
     *
     * @param restauranteId Identificador de la instancia de Restaurante
     * @param sucursalsId Identificador de la instancia de Sucursal
     * @return
     * @generated
     */
    public SucursalEntity getSucursal(Long restauranteId, Long sucursalsId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un libro con id = {0}", sucursalsId);
        List<SucursalEntity> list = getRestaurante(restauranteId).getSucursales();
        SucursalEntity sucursalsEntity = new SucursalEntity();
        sucursalsEntity.setId(sucursalsId);
        int index = list.indexOf(sucursalsEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }


}
