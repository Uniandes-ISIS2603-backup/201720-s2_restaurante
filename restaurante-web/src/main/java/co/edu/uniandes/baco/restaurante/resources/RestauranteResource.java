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
package co.edu.uniandes.baco.restaurante.resources;

import co.edu.uniandes.baco.restaurante.ejb.RestauranteLogic;
import co.edu.uniandes.baco.restaurante.dtos.RestauranteDetailDTO;
import co.edu.uniandes.baco.restaurante.entities.RestauranteEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Clase que implementa el recurso REST correspondiente a "Restaurantes".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "Restaurantes". Al ejecutar la aplicación, el
 * recurso será accesibe a través de la ruta "/api/Restaurantes"
 *
 * @author ISIS2603
 *
 */
@Path("restaurantes")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class RestauranteResource {

    @Inject RestauranteLogic restauranteLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * POST http://localhost:8080/restaurante-web/api/restaurantes
     *
     * @param Restaurante correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "RestauranteDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public RestauranteDetailDTO createRestaurante(RestauranteDetailDTO restaurante) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        RestauranteEntity restauranteEntity = restaurante.toEntity();
        // Invoca la lógica para crear la Restaurante nueva
        RestauranteEntity nuevoRestaurante = restauranteLogic.createRestaurante(restauranteEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new RestauranteDetailDTO(nuevoRestaurante);
    }

    /**
     * GET para todas las Restaurantees.
     * http://localhost:8080/restaurante-web/api/restaurantes
     *
     * @return la lista de todas las Restaurantees en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<RestauranteDetailDTO> getRestaurantes() throws BusinessLogicException {
        return listEntity2DetailDTO(restauranteLogic.getRestaurantes());
    }

   
    /**
     * PUT http://localhost:8080/restaurante-web/api/restaurantes/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Restaurante a actualizar.
     * @param restaurante corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Restaurante actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Restaurante a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public RestauranteDetailDTO updateRestaurante(@PathParam("id") Long id, RestauranteDetailDTO restaurante) throws BusinessLogicException {
          throw new UnsupportedOperationException("Este servicio  no está implementado");
      
    }

    /**
     * DELETE http://localhost:8080/restaurante-web/api/restaurantes/{id}
     *
     * @param id corresponde a la Restaurante a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Restaurante a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteRestaurante(@PathParam("id") Long id) throws BusinessLogicException {
         throw new UnsupportedOperationException("Este servicio no está implementado");
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos RestauranteEntity a una lista de
     * objetos RestauranteDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Restaurantees de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Restaurantees en forma DTO (json)
     */
    private List<RestauranteDetailDTO> listEntity2DetailDTO(List<RestauranteEntity> entityList) {
        List<RestauranteDetailDTO> list = new ArrayList<>();
        for (RestauranteEntity entity : entityList) {
            list.add(new RestauranteDetailDTO(entity));
        }
        return list;
    }

}
