/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.resources;

import co.edu.uniandes.baco.restaurante.dtos.TarjetaPuntosDetailDTO;
import co.edu.uniandes.baco.restaurante.ejb.TarjetaPuntosLogic;
import co.edu.uniandes.baco.restaurante.entities.TarjetaPuntosEntity;
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
 *
 * @author s.heim
 */
@Path("tarjeta_puntos")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class TarjetaPuntosResource {
    @Inject
    TarjetaPuntosLogic TarjetaPuntosLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(TarjetaPuntosResource.class.getName());

    /**
     * POST http://localhost:8080/restaurante-web/api/tarjeta_puntos
     *
     * @param TarjetaPuntos correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "TarjetaPuntosDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST 
    public TarjetaPuntosDetailDTO  createCliente(TarjetaPuntosDetailDTO TarjetaPuntos) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        TarjetaPuntosEntity TarjetaPuntosEntity = TarjetaPuntos.toEntity();
        // Invoca la lógica para crear la TarjetaPuntos nueva
        TarjetaPuntosEntity nuevoTarjetaPuntos;
        nuevoTarjetaPuntos = TarjetaPuntosLogic.createTarjetaPuntos(TarjetaPuntosEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new TarjetaPuntosDetailDTO(nuevoTarjetaPuntos);
    }

    /**
     * GET para todas las Tarjeta Puntos.
     * http://localhost:8080/restaurante-web/api/tarjeta_puntos
     *
     * @return la lista de todas las TarjetaPuntoses en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET 
    public List<TarjetaPuntosDetailDTO> getTarjetaPuntoss() throws BusinessLogicException {
        return listEntity2DetailDTO(TarjetaPuntosLogic.getTarjetaPuntoss());
    }

   
    /**
     * PUT http://localhost:8080/restaurante-web/api/tarjeta_puntos/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la TarjetaPuntos a actualizar.
     * @param restaurante corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La TarjetaPuntos actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la TarjetaPuntos a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT 
    @Path("{id: \\d+}")
    public TarjetaPuntosDetailDTO updateTarjetaPuntos(@PathParam("id") Long id, TarjetaPuntosDetailDTO restaurante) throws BusinessLogicException, UnsupportedOperationException {
          throw new UnsupportedOperationException("Este servicio  no está implementado");
      
    }

    /**
     * DELETE http://localhost:8080/restaurante-web/api/tarjeta_puntos/{id}
     *
     * @param id corresponde a la TarjetaPuntos a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la TarjetaPuntos a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE 
    @Path("{id: \\d+}")
    public void deleteTarjetaPuntos(@PathParam("id") Long id) throws BusinessLogicException {
         throw new UnsupportedOperationException("Este servicio no está implementado");
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos TarjetaPuntosEntity a una lista de
     * objetos TarjetaPuntosDetailDTO (json)
     *
     * @param entityList corresponde a la lista de TarjetaPuntoses de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de TarjetaPuntoses en forma DTO (json)
     */
    private List<TarjetaPuntosDetailDTO> listEntity2DetailDTO(List<TarjetaPuntosEntity> entityList) {
        List<TarjetaPuntosDetailDTO> list = new ArrayList<>();
        for (TarjetaPuntosEntity entity : entityList) {
            list.add(new TarjetaPuntosDetailDTO(entity));
        }
        return list;
    }
}
