/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.resources;


import co.edu.uniandes.baco.restaurante.dtos.DomicilioDetailDTO;
import co.edu.uniandes.baco.restaurante.ejb.DomicilioLogic;
import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;
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
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author af.bejarano
 */
@Path("domicilioes")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class DomicilioResource {
    DomicilioLogic domicilioLogic;
    @Inject
    DomicilioLogic DomicilioLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(DomicilioResource.class.getName());

    /**
     * POST http://localhost:8080/restaurante-web/api/domicilioes
     *
     * @param Domicilio correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "DomicilioDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST 
    public DomicilioDetailDTO  createCliente(DomicilioDetailDTO Domicilio) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        DomicilioEntity DomicilioEntity = Domicilio.toEntity();
        // Invoca la lógica para crear la Domicilio nueva
        DomicilioEntity nuevoDomicilio;
        nuevoDomicilio = DomicilioLogic.createDomicilio(DomicilioEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new DomicilioDetailDTO(nuevoDomicilio);
    }

    /**
     * GET para todas las Domicilioes.
     * http://localhost:8080/restaurante-web/api/domicilioes
     *
     * @return la lista de todas las Domicilioes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET 
    public List<DomicilioDetailDTO> getDomicilios() throws BusinessLogicException {
        return listEntity2DetailDTO(DomicilioLogic.getDomicilios());
    }
    @GET
    @Path("{id: \\d+}")
    public DomicilioDetailDTO getDomicilio(@PathParam("id") Long id) throws BusinessLogicException {
        DomicilioEntity entity = domicilioLogic.getDomicilio(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /domicilios/" + id + " no existe.", 404);
        }
        return new DomicilioDetailDTO(entity);
    }

   
    /**
     * PUT http://localhost:8080/restaurante-web/api/domicilioes/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Domicilio a actualizar.
     * @param restaurante corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Domicilio actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Domicilio a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public DomicilioDetailDTO updateDomicilio(@PathParam("id") Long id, DomicilioDetailDTO suc) throws BusinessLogicException {
        suc.setId(id);
        DomicilioEntity entity = domicilioLogic.getDomicilio(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /domicilios/" + id + " no existe.", 404);
        }
        return new DomicilioDetailDTO(domicilioLogic.updateDomicilio(id, suc.toEntity()));
    }

    /**
     * DELETE http://localhost:8080/restaurante-web/api/domicilioes/{id}
     *
     * @param id corresponde a la Domicilio a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Domicilio a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE 
    @Path("{id: \\d+}")
    public void deleteDomicilio(@PathParam("domiciliosId") Long id) throws BusinessLogicException {
        DomicilioEntity entity = domicilioLogic.getDomicilio(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /domicilios/" + id + " no existe.", 404);
        }
        domicilioLogic.deleteDomicilio(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos DomicilioEntity a una lista de
     * objetos DomicilioDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Domicilioes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Domicilioes en forma DTO (json)
     */
    private List<DomicilioDetailDTO> listEntity2DetailDTO(List<DomicilioEntity> entityList) {
        List<DomicilioDetailDTO> list = new ArrayList<>();
        for (DomicilioEntity entity : entityList) {
            list.add(new DomicilioDetailDTO(entity));
        }
        return list;
    }
}