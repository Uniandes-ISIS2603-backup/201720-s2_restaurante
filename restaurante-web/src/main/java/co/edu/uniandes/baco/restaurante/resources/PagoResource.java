/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.resources;

import co.edu.uniandes.baco.restaurante.dtos.PagoDetailDTO;
import co.edu.uniandes.baco.restaurante.ejb.PagoLogic;
import co.edu.uniandes.baco.restaurante.entities.PagoEntity;
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
 * @author s.heim
 */
@Path("pagos")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class PagoResource {
    @Inject
    PagoLogic PagoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(PagoResource.class.getName());

    /**
     * POST http://localhost:8080/restaurante-web/api/pagos
     *
     * @param Pago correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "PagoDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST 
    public PagoDetailDTO  createCliente(PagoDetailDTO Pago) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        PagoEntity PagoEntity = Pago.toEntity();
        // Invoca la lógica para crear la Pago nueva
        PagoEntity nuevoPago;
        nuevoPago = PagoLogic.createPago(PagoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new PagoDetailDTO(nuevoPago);
    }

    /**
     * GET para todas las Pagoes.
     * http://localhost:8080/restaurante-web/api/pagos
     *
     * @return la lista de todas las Pagoes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET 
    public List<PagoDetailDTO> getPagos() throws BusinessLogicException {
        return listEntity2DetailDTO(PagoLogic.getPagos());
    }

    @GET
    @Path("{id: \\d+}")
    public PagoDetailDTO getPago(@PathParam("id") Long id) throws BusinessLogicException {
        PagoEntity entity = PagoLogic.gePago(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Pago/" + id + " no existe.", 404);
        }
        return new PagoDetailDTO(entity);
    }
   
    /**
     * PUT http://localhost:8080/restaurante-web/api/pagos/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Pago a actualizar.
     * @param restaurante corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Pago actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Pago a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT 
    @Path("{id: \\d+}")
    public PagoDetailDTO updatePago(@PathParam("id") Long id, PagoDetailDTO pago) throws BusinessLogicException, UnsupportedOperationException {
         pago.setId(id);
        PagoEntity entity = PagoLogic.gePago(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Pagoes/" + id + " no existe.", 404);
        }
        return new PagoDetailDTO(PagoLogic.updatePago(id, pago.toEntity()));
      
    }

    /**
     * DELETE http://localhost:8080/restaurante-web/api/pagos/{id}
     *
     * @param id corresponde a la Pago a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Pago a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE 
    @Path("{id: \\d+}")
    public void deletePago(@PathParam("id") Long id) throws BusinessLogicException {
         PagoEntity entity = PagoLogic.gePago(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Pago/" + id + " no existe.", 404);
        }
        PagoLogic.deletePago(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos PagoEntity a una lista de
     * objetos PagoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Pagoes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Pagoes en forma DTO (json)
     */
    private List<PagoDetailDTO> listEntity2DetailDTO(List<PagoEntity> entityList) {
        List<PagoDetailDTO> list = new ArrayList<>();
        for (PagoEntity entity : entityList) {
            list.add(new PagoDetailDTO(entity));
        }
        return list;
    }
}
